package com.ramo.ebuy.ui.product

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramo.ebuy.AppViewModel
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.di.Stater
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.navigation.MokoModel
import com.ramo.ebuy.global.navigation.Navigator
import com.ramo.ebuy.global.navigation.RootComponent
import com.ramo.ebuy.global.ui.ImagesPageView
import com.ramo.ebuy.global.ui.LoadingScreen
import com.ramo.ebuy.global.ui.OnLaunchScreen
import com.ramo.ebuy.global.ui.SheetBottomTitle
import com.ramo.ebuy.global.ui.rememberArrowDropDown
import com.ramo.ebuy.ui.common.BarProductScreen
import com.ramo.ebuy.ui.common.ProductList
import com.skydoves.flexible.bottomsheet.material3.FlexibleBottomSheet
import com.skydoves.flexible.core.FlexibleSheetSize
import com.skydoves.flexible.core.rememberFlexibleBottomSheetState
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun ProductDetailsScreen(
    navigator: Navigator,
    appModel: AppViewModel,
    productId: Long,
    project: Project = koinInject(),
    theme: Theme = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductDetailsViewModel = MokoModel {
        ProductDetailsViewModel(
            appModel.watchlist,
            appModel.pasteWatchlist,
            appModel.cartList,
            appModel.pasteCart,
            project
        )
    }
) {
    val state by viewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()
    OnLaunchScreen {
        viewModel.loadProDetails(productId)
    }
    Scaffold { pad ->
        Column(Modifier.padding(pad)) {
            BarProductScreen(appModel.uiState.collectAsState().value.cartList.size) {
                when (it) {
                    0 -> scope.launch {
                        navigator.goBack()
                    }

                    2 -> {
                        stater.getScreenCount(RootComponent.Configuration.CartRoute::class.java).let { count ->
                            RootComponent.Configuration.CartRoute(count + 1).also { route ->
                                scope.launch {
                                    stater.writeArguments(route = route, screenCount = count + 1)
                                    navigator.navigateTo(route)
                                }
                            }
                        }
                    }
                }
            }
            LazyColumn {
                item {
                    ImagesPageView(state.product.imageUris, DpSize(0.dp, 300.dp), state.product, {

                    }) {

                    }
                }
                ProductDetailsTitle(state, theme)
                ProductDetailsExtraSpecs(viewModel, state, theme)
                ProductDetailsActions(state, theme) {
                    when (it) {
                        1 -> viewModel.addToCart()
                        2 -> {
                            stater.getScreenCount(RootComponent.Configuration.CartRoute::class.java).let { count ->
                                RootComponent.Configuration.CartRoute(count + 1).also { route ->
                                    scope.launch {
                                        stater.writeArguments(route = route, screenCount = count + 1)
                                        navigator.navigateTo(route)
                                    }
                                }
                            }
                        }

                        3 -> {
                            state.product.apply {
                                if (id == 0L) {
                                    return@apply
                                }
                                viewModel.changeWatchList(isWatchlist, id)
                            }
                        }
                    }
                }
                item {
                    Spacer(Modifier.height(5.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(7.dp),
                        text = "About this Item",
                        color = theme.textColor,
                        fontSize = 22.sp,
                    )
                    Spacer(Modifier.height(5.dp))
                }
                ProductDetailsSpecs(state, theme) {
                    scope.launch {
                        viewModel.setModelBottom(true)
                    }
                }
                item {
                    Spacer(Modifier.height(20.dp))
                }
                ProductList(list = state.productVer) {
                    stater.getScreenCount(RootComponent.Configuration.ProductDetailsRoute::class.java).let { count ->
                        RootComponent.Configuration.ProductDetailsRoute(it.id, count + 1).also { route ->
                            scope.launch {
                                stater.writeArguments(route = route, screenCount = count + 1)
                                navigator.navigateTo(route)
                            }
                        }
                    }
                }
            }
        }
        ProductDetailsBottomSheet(state, theme) {
            viewModel.setModelBottom(false)
        }
        LoadingScreen(state.isProcess, theme)
    }
}

@Composable
fun ProductDetailsBottomSheet(state: ProductDetailsViewModel.State, theme: Theme, hide: () -> Unit) {
    if (state.isModalBottom) {
        FlexibleBottomSheet(
            onDismissRequest = {
                hide()
            },
            sheetState = rememberFlexibleBottomSheetState(
                skipIntermediatelyExpanded = true,
                flexibleSheetSize = FlexibleSheetSize(
                    fullyExpanded = 0.7F,
                    intermediatelyExpanded = 0.5F,
                    slightlyExpanded = 0.0F,
                ),
                allowNestedScroll = true,
                isModal = true,
                skipSlightlyExpanded = false,
            ),
            dragHandle = {
                SheetBottomTitle("About this Item", theme)
            },
            containerColor = theme.backDark,
            contentColor = theme.textColor,
        ) {
            LazyColumn(modifier = Modifier.background(theme.backDark)) {
                item {
                    ProductSellingSpecItem("Condition", state.product.condition, theme)
                    ProductSellingSpecItem("Condition", state.productSpecs.conditionDetails, theme)
                    ProductSellingSpecItem("Made in", state.productSpecs.countryProductStr, theme)
                    ProductSellingSpecItem("Platform", state.productSpecs.platform, theme)
                    ProductSellingSpecItem("Rating", state.product.ageRateStr, theme)
                    ProductSellingSpecItem("Release Year", state.productSpecs.releaseYearOnly, theme)
                    ProductSellingSpecItem("MPN", state.productSpecs.mpn, theme)
                    ProductSellingSpecItem("UPC", state.product.productCode, theme)
                }
                items(state.productSpecs.specs) {
                    Column(Modifier.fillMaxWidth()) {
                        ProductSellingSpecItem(it.label, it.spec, theme)
                    }
                }
                item {
                    Spacer(Modifier.height(20.dp))
                }
            }
        }
    } else return
}

fun LazyListScope.ProductDetailsTitle(
    state: ProductDetailsViewModel.State,
    theme: Theme,
) = item {
    Column(Modifier.fillMaxWidth().padding(7.dp).clickable {

    }) {
        Spacer(Modifier.height(10.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = state.product.title,
            color = theme.textColor,
            fontSize = 22.sp,
        )
        if (state.productSpecs.subTitle.isNotEmpty()) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = state.productSpecs.subTitle,
                color = theme.textGrayColor,
                fontSize = 20.sp,
            )
        }
    }
}

fun LazyListScope.ProductDetailsExtraSpecs(viewModel: ProductDetailsViewModel, state: ProductDetailsViewModel.State, theme: Theme) {
    itemsIndexed(state.productSpecs.specsExtra) { i, extra ->
        Box(Modifier.padding(15.dp)) {
            DropdownMenu(
                expanded = state.droppedIndex == i,
                modifier = Modifier.background(theme.backDark),
                onDismissRequest = {
                    viewModel.setDroppedIndex(-1)
                }
            ) {
                Text(modifier = Modifier.defaultMinSize(minWidth = 150.dp).clickable {
                    viewModel.setSpecChosen(i, -1)
                }.padding(vertical = 20.dp, horizontal = 10.dp), text = "No Selection", color = theme.textColor)
                extra.specExtra.forEachIndexed { ii, e ->
                    Text(modifier = Modifier.defaultMinSize(minWidth = 150.dp).clickable {
                        viewModel.setSpecChosen(i, ii)
                    }.padding(vertical = 20.dp, horizontal = 10.dp), text = e.labelSpec, color = theme.textColor)
                }
            }
            OutlinedButton(
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = theme.background,
                    contentColor = theme.textColor,
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = theme.textGrayColor,
                ),
                onClick = {
                    viewModel.setDroppedIndex(i)
                },
            ) {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = theme.textGrayColor)) {
                                append(extra.labelExtra + ": ")
                            }
                            withStyle(style = SpanStyle(color = theme.textColor)) {
                                state.specChosen.find { it.index == i }?.let { c ->
                                    append(extra.specExtra.getOrNull(c.userSpecIndex)?.labelSpec ?: " Select")
                                } ?: run {
                                    append("Select")
                                }
                            }
                        },
                        color = theme.textColor,
                        fontSize = 18.sp,
                    )
                    Image(
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                            .align(Alignment.CenterVertically)
                            .padding(5.dp),
                        imageVector = rememberArrowDropDown(theme.textColor),
                        contentDescription = "",
                    )
                }
            }
        }
    }
}

fun LazyListScope.ProductDetailsActions(state: ProductDetailsViewModel.State, theme: Theme, onClick: (Int) -> Unit) = item {
    Column(Modifier.fillMaxWidth().padding(horizontal = 15.dp)) {
        OutlinedButton(
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = theme.primary,
                contentColor = theme.textForPrimaryColor,
            ),
            border = BorderStroke(
                width = 0.dp,
                color = theme.primary,
            ),
            onClick = {

            },
        ) {
            Text(
                text = "Buy it Now",
                color = theme.textForPrimaryColor,
                fontSize = 18.sp,
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = theme.primary,
            ),
            border = BorderStroke(
                width = 1.5.dp,
                color = theme.primary,
            ),
            onClick = {
                if (state.userCart == null) {
                    onClick(1)
                } else {
                    onClick(2)
                }
            },
        ) {
            Row {
                Text(
                    text = if (state.userCart == null) "Add to cart" else "View In Cart",
                    color = theme.primary,
                    fontSize = 18.sp,
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = theme.primary,
            ),
            border = BorderStroke(
                width = 1.5.dp,
                color = theme.primary,
            ),
            onClick = {
                onClick(3)
            },
        ) {
            Row {
                Image(if (state.product.isWatchlist) Icons.Default.Favorite else Icons.Default.FavoriteBorder, null, colorFilter = ColorFilter.tint(theme.primary), modifier = Modifier.width(20.dp).height(20.dp))
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = if (state.product.isWatchlist) "Remove from watchlist" else "Add to watchlist",
                    color = theme.primary,
                    fontSize = 18.sp,
                )
            }
        }
    }
}

fun LazyListScope.ProductDetailsSpecs(state: ProductDetailsViewModel.State, theme: Theme, onClick: () -> Unit) {
    item {
        Column(Modifier.fillMaxWidth().clickable(onClick = onClick).padding(horizontal = 15.dp)) {
            ProductSellingSpecItem("Condition", state.product.condition, theme)
            ProductSellingSpecItem("Made in", state.productSpecs.countryProductStr, theme)
            ProductSellingSpecItem("Platform", state.productSpecs.platform, theme)
            ProductSellingSpecItem("Rating", state.product.ageRateStr, theme)
            ProductSellingSpecItem("Release Year", state.productSpecs.releaseYearOnly, theme)
        }
    }
}
