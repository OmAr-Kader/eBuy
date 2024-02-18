package com.ramo.ebuy.ui.product

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.preat.peekaboo.image.picker.SelectionMode
import com.preat.peekaboo.image.picker.rememberImagePickerLauncher
import com.preat.peekaboo.image.picker.toImageBitmap
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.di.Stater
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.navigation.MokoModel
import com.ramo.ebuy.global.navigation.Navigator
import com.ramo.ebuy.global.navigation.RootComponent
import com.ramo.ebuy.global.ui.LoadingScreen
import com.ramo.ebuy.global.ui.OnLaunchScreen
import com.ramo.ebuy.global.ui.rememberAdd
import com.ramo.ebuy.global.ui.rememberClose
import com.ramo.ebuy.global.ui.rememberCorrect
import com.ramo.ebuy.global.ui.rememberDeleteForever
import com.ramo.ebuy.global.ui.rememberEdit
import com.ramo.ebuy.global.ui.rememberHelp
import com.ramo.ebuy.global.ui.rememberWrong
import com.seiko.imageloader.rememberImagePainter
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun ProductSellingScreen(
    navigator: Navigator,
    productId: Long,
    isAdmin: Boolean,
    project: Project = koinInject(),
    theme: Theme = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.stateProductSellingModel.copy()) {
            apply {
                stater.stateProductSelling = this@apply
            }
        }
    }
) {
    val state by viewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()
    val scaffoldState = remember { SnackbarHostState() }
    val multiImagePicker = rememberImagePickerLauncher(
        selectionMode = SelectionMode.Multiple(11),
        scope = scope,
        onResult = { byteArrays ->
            viewModel.appendImageUrl(byteArrays)
        }
    )
    val isAllValid = state.product.title.isNotEmpty() && state.product.parentCategory.isNotEmpty() &&
            state.product.priceValid && (if (isAdmin) true else state.deliveryProcess.deliveryCostValid)
    OnLaunchScreen {
        viewModel.loadProduct(productId)
    }
    Scaffold(
        snackbarHost = {
            SnackbarHost(scaffoldState) {
                Snackbar(it, containerColor = theme.backDarkSec, contentColor = theme.textColor)
            }
        },
    ) { pad ->
        Column(
            modifier = Modifier.fillMaxSize().padding(pad).background(color = theme.background)
        ) {
            ProductSellingHeadBar(theme) {
                scope.launch {
                    navigator.goBack()
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = theme.background)
            ) {
                ProductSellingHeadItem("Photos", theme)
                ProductSellingPhotos(state, theme, onDeleteCloud = {
                    viewModel.removeImageUrl(it)
                }, onDeletePicker = {
                    viewModel.removeImageByte(it)
                }) {
                    multiImagePicker.launch()
                }
                ProductSellingHeadItemCorrectable(state.product.title.isNotEmpty(), "Title", theme) {
                    scope.launch {
                        navigator.navigateTo(RootComponent.Configuration.ProductSellingTitleRoute)
                    }
                }
                item {
                    Text(modifier = Modifier.padding(horizontal = 10.dp), text = state.product.title, color = theme.textColor, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                }
                ProductSellingHeadItemCorrectable(state.product.parentCategory.isNotEmpty(), "Category", theme) {
                    scope.launch {
                        navigator.navigateTo(RootComponent.Configuration.ProductSellingCategoryRoute)
                    }
                }
                ProductSellingCato(state, theme)
                ProductSellingHeadItemCorrectable(state.product.priceValid, "Pricing", theme) {
                    scope.launch {
                        navigator.navigateTo(RootComponent.Configuration.ProductSellingPriceRoute)
                    }
                }
                ProductSellingDiscount(state, theme)
                ProductSellingPrice(state, theme)
                ProductSellingHeadItemCorrectable(true, "Item specifics", theme) {
                    scope.launch {
                        stater.subStateProductSelling = state
                        navigator.navigateTo(RootComponent.Configuration.ProductSellingSpecRoute(isAdmin))
                    }
                }
                ProductSellingSpecs(state, theme)
                if (state.product.priceValid) {
                    ProductSellingHeadItemCorrectable(true, "Item Listed specifics", theme) {
                        scope.launch {
                            stater.subStateProductSelling = state
                            navigator.navigateTo(RootComponent.Configuration.ProductSellingCustomSpecExtraRoute)
                        }
                    }
                    ProductSellingSpecsExtra(state, theme)
                }
                if (!isAdmin) {
                    ProductSellingHeadItemCorrectable(state.deliveryProcess.deliveryCostValid, "Delivery", theme) {
                        scope.launch {
                            stater.subStateProductSelling = state
                            navigator.navigateTo(RootComponent.Configuration.ProductShippingRoute)
                        }
                    }
                    ProductSellingShipping(state, theme)
                }
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }
                if (isAllValid) {
                    item {
                        OutlinedButton(
                            modifier = Modifier.fillMaxWidth().height(50.dp).padding(horizontal = 5.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                containerColor = theme.primary,
                                contentColor = theme.textForPrimaryColor,
                            ),
                            border = BorderStroke(
                                width = 0.dp,
                                color = theme.primary,
                            ),
                            onClick = {
                                if (state.product.id == 0L) {
                                    viewModel.addNewProduct(isAdmin, {
                                        viewModel.clear()
                                        scope.launch {
                                            navigator.goBack()
                                        }
                                    }) {
                                        viewModel.setIsProcess(false)
                                    }
                                } else {
                                    viewModel.editProduct(isAdmin, {
                                        viewModel.clear()
                                        scope.launch {
                                            navigator.goBack()
                                        }
                                    }) {
                                        viewModel.setIsProcess(false)
                                    }
                                }
                            },
                        ) {
                            Text(
                                text = "List your item",
                                color = theme.textForPrimaryColor,
                                fontSize = 18.sp,
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }
        /*
        MultipleFilePicker(state.isShowPicker, fileExtensions = listOf("jpg", "png", "webp", "mpeg", "heic", "heif", "hevc")) { files ->
            files?.also {
                viewModel.appendImageUrl(it)
            } ?: viewModel.setIsShowPicker(it = false)

        }*/
        LoadingScreen(state.isProcess, theme)
    }

}

@Composable
fun ProductSellingHeadBar(
    theme: Theme,
    onBack: () -> Unit,
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 5.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .background(color = theme.backDark, shape = CircleShape)
                .clickable(onClick = onBack)
                .padding(8.dp),
            imageVector = rememberClose(theme.textColor),
            contentScale = ContentScale.Fit,
            contentDescription = null,
        )
        Text(
            text = "Selling",
            color = theme.textColor,
            fontSize = 20.sp,
        )
        Image(
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .background(color = theme.backDark, shape = CircleShape)
                .padding(8.dp),
            imageVector = rememberHelp(theme.textColor),
            contentScale = ContentScale.Fit,
            contentDescription = null,
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
}

fun LazyListScope.ProductSellingPhotos(
    state: StateProductSelling,
    theme: Theme,
    onDeleteCloud: (Int) -> Unit,
    onDeletePicker: (Int) -> Unit,
    onPicker: () -> Unit,
) = item {
    LazyRow {
        itemsIndexed(state.product.imageUris) { i, imageUrl ->
            ProductImageItem(theme, i, {
                onDeleteCloud(i)
            }) {
                val painter = rememberImagePainter(url = imageUrl)
                Image(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .padding(5.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(color = theme.backDark),
                    painter = painter,
                    contentScale = ContentScale.Fit,
                    contentDescription = "Product  ",
                )
            }
        }
        itemsIndexed(state.images) { i, image ->
            ProductImageItem(theme, i, {
                onDeletePicker(i)
            }) {
                Image(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .padding(5.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(color = theme.backDark),
                    bitmap = image.toImageBitmap(),
                    contentScale = ContentScale.Fit,
                    contentDescription = "Product  ",
                )
            }
        }
        item {
            Column {
                Surface(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .clickable(onClick = onPicker)
                        .padding(start = 5.dp, end = 5.dp, top = 5.dp, bottom = 5.dp),
                    color = Color.Transparent,
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(0.5.dp, color = theme.textHintColor)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                    ) {
                        Image(
                            modifier = Modifier
                                .size(30.dp),
                            imageVector = rememberAdd(color = theme.primary),
                            contentScale = ContentScale.Fit,
                            contentDescription = "Product Image",
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(40.dp)
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun ProductImageItem(theme: Theme, pos: Int, onDeleteCloud: (Int) -> Unit, content: @Composable ColumnScope.() -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        content()
        Image(
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .background(color = theme.backDark, shape = CircleShape)
                .clickable {
                    onDeleteCloud(pos)
                }
                .padding(8.dp),
            imageVector = rememberDeleteForever(theme.textGrayColor),
            contentScale = ContentScale.Fit,
            contentDescription = null,
        )
    }
}


fun LazyListScope.ProductSellingSpecs(state: StateProductSelling, theme: Theme) {
    item {
        ProductSellingSpecItem("Condition", state.product.condition, theme)
        ProductSellingSpecItem("Made in", state.productSpecs.countryProductStr, theme)
        ProductSellingSpecItem("Platform", state.productSpecs.platform, theme)
        ProductSellingSpecItem("Rating", state.product.ageRateStr, theme)
        ProductSellingSpecItem("Release Year", state.productSpecs.releaseYearOnly, theme)
        ProductSellingSpecItem("MPN", state.productSpecs.mpn, theme)
        ProductSellingSpecItem("UPC", state.product.productCode, theme)
    }
    items(state.productSpecs.specs) {
        ProductSellingSpecItem(it.label, it.spec, theme)
    }
}


fun LazyListScope.ProductSellingSpecsExtra(state: StateProductSelling, theme: Theme) {
    items(state.productSpecs.specsExtra) {
        ProductSellingSpecItem(it.labelExtra, it.specExtra.joinToString(separator = "\n") { it1 -> it1.labelSpec }, theme)
    }
    if (state.productSpecs.specsExtra.isEmpty()) {
        item {
            Spacer(Modifier.height(100.dp))
        }
    }
}

fun LazyListScope.ProductSellingCato(state: StateProductSelling, theme: Theme) = item {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        text = state.product.parentCategory.firstOrNull() ?: "", color = theme.textColor
    )
    Text(modifier = Modifier.padding(start = 15.dp, end = 10.dp), text = state.product.parentCatoRest, color = theme.textGrayColor)
    Spacer(modifier = Modifier.height(10.dp))
}

fun LazyListScope.ProductSellingDiscount(state: StateProductSelling, theme: Theme) = item {
    val days = state.product.timeGap?.days
    if (!state.product.offerValid || days == null) {
        return@item
    }
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        text = "Auction", color = theme.textColor
    )
    ProductSellingSpecItem("Start bid", "$ " + state.product.offer, theme)
    ProductSellingSpecItem("Duration", "$days days", theme)
    Spacer(modifier = Modifier.height(10.dp))
}

fun LazyListScope.ProductSellingPrice(state: StateProductSelling, theme: Theme) = item {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        text = "Buy It Now", color = theme.textColor
    )
    ProductSellingSpecItem("Price", state.product.priceStr, theme)
    ProductSellingSpecItem("Minimum offer amount", state.product.offerStr, theme)
    Spacer(modifier = Modifier.height(10.dp))
}

fun LazyListScope.ProductSellingShipping(state: StateProductSelling, theme: Theme) = item {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        text = "Ship in ${state.user.businessCountryStr}", color = theme.textColor
    )
    ProductSellingSpecItem("Package Details", state.deliveryProcess.sizePhys, theme)
    ProductSellingSpecItemWithSub("Service", state.deliveryProcess.shippingService, state.deliveryProcess.durationStr, theme)
    ProductSellingSpecItem("Shipping Cost", state.deliveryProcess.deliveryCostStr, theme)
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun ProductSellingSpecItem(specTitle: String, spec: String, theme: Theme) {
    if (spec.isEmpty()) {
        return
    }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Text(modifier = Modifier.width(130.dp), text = specTitle, color = theme.textGrayColor)
        Text(spec, color = theme.textColor)
    }
}

@Composable
fun ProductSellingSpecItemWithSub(specTitle: String, spec: String, subSpec: String, theme: Theme) {
    if (spec.isEmpty()) {
        return
    }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Text(modifier = Modifier.width(130.dp), text = specTitle, color = theme.textGrayColor)
        Column {
            Text(spec, color = theme.textColor)
            Text(subSpec, color = theme.textGrayColor, fontSize = 14.sp)
        }
    }
}

fun LazyListScope.ProductSellingHeadItem(text: String, theme: Theme) = item {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            color = theme.textColor,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Image(
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .clip(CircleShape)
                .padding(8.dp),
            imageVector = rememberEdit(theme.textHintColor),
            contentScale = ContentScale.Fit,
            contentDescription = null,
        )
    }
    Spacer(modifier = Modifier.height(5.dp))
}

fun LazyListScope.ProductSellingHeadItemCorrectable(isDone: Boolean, text: String, theme: Theme, onClick: () -> Unit) = item {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp),
                imageVector = if (isDone) rememberCorrect() else rememberWrong(),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
            Text(
                text = text,
                modifier = Modifier.padding(horizontal = 5.dp),
                color = theme.textColor,
                fontSize = 25.sp,
            )
        }
        Image(
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .clickable(onClick = onClick)
                .padding(8.dp),
            imageVector = rememberEdit(theme.textHintColor),
            contentScale = ContentScale.Fit,
            contentDescription = null,
        )
    }
    Spacer(modifier = Modifier.height(5.dp))
}
