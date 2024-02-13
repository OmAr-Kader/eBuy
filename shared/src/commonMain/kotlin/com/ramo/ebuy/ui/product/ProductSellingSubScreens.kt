package com.ramo.ebuy.ui.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramo.ebuy.data.model.ProductSpecs
import com.ramo.ebuy.data.model.ProductSpecsExtra
import com.ramo.ebuy.data.model.SpecExtra
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.di.Stater
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.base.outlinedTextFieldStyle
import com.ramo.ebuy.global.navigation.MokoModel
import com.ramo.ebuy.global.navigation.Navigator
import com.ramo.ebuy.global.navigation.RootComponent
import com.ramo.ebuy.global.ui.CalendarYearView
import com.ramo.ebuy.global.ui.LoadingScreen
import com.ramo.ebuy.global.ui.OnLaunchScreenScope
import com.ramo.ebuy.global.ui.rememberArrowBack
import com.ramo.ebuy.global.ui.rememberDeleteForever
import com.ramo.ebuy.global.ui.rememberEdit
import com.ramo.ebuy.global.ui.rememberHelp
import com.ramo.ebuy.global.util.conditions
import com.ramo.ebuy.global.util.currentTime
import com.ramo.ebuy.global.util.margeYear
import com.ramo.ebuy.global.util.offerSubTitle
import com.ramo.ebuy.global.util.ratings
import com.ramo.ebuy.global.util.splitTime
import com.ramo.ebuy.ui.common.ExpandableCato
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun ProductConditionMainScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.stateProductSellingModel.copy()) {
            apply {
                stater.stateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    val scaffoldState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(scaffoldState) {
                Snackbar(it, containerColor = theme.backDarkSec, contentColor = theme.textColor)
            }
        },
    ) { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBarBack("Add more details", theme) {
                scope.launch {
                    navigator.goBack()
                }
            }
            Text(
                modifier = Modifier.padding(5.dp),
                text = "Select Condition of your Item",
                color = theme.textColor,
                fontSize = 24.sp,
            )
            Column {
                conditions.forEach {
                    ProductSpecItemRadio(it, it == state.product.condition, theme) {
                        viewModel.setConditionMain(it)
                        scope.launch {
                            navigator.navigateToReplace(RootComponent.Configuration.ProductSellingRoute(-1, false))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProductSellingPriceScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.stateProductSellingModel.copy()) {
            apply {
                stater.stateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    val scaffoldState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(scaffoldState) {
                Snackbar(it, containerColor = theme.backDarkSec, contentColor = theme.textColor)
            }
        },
    ) { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBar("Pricing", theme) {
                viewModel.donePressed()
                scope.launch {
                    navigator.goBack()
                }
            }
            ProductSellingSpecEditItem(
                "Price",
                state.product.priceEditStr,
                KeyboardType.Number, theme
            ) {
                viewModel.setPrice(it)
            }
            ProductSellingSpecCheckableTitle("Offer", offerSubTitle, state.product.offerValid, state.product.priceValid, theme) {
                viewModel.isOffer(it)
            }
            if (state.product.offerValid) {
                ProductSellingSpecEditItem("Minimum offer amount", state.product.offer.toString(), KeyboardType.Number, theme) {
                    viewModel.setOffer(it)
                }
            }
        }
    }
}

@Composable
fun ProductSellingTitleScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.stateProductSellingModel.copy()) {
            apply {
                stater.stateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    val scaffoldState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(scaffoldState) {
                Snackbar(it, containerColor = theme.backDarkSec, contentColor = theme.textColor)
            }
        },
    ) { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBar("Title", theme) {
                if (state.product.productCode.length > 80) {
                    return@ProductSellingSpecsHeadBar
                }
                viewModel.donePressed()
                scope.launch {
                    navigator.goBack()
                }
            }
            ProductSellingSpecEditItemFull(
                "Title",
                state.product.title,
                KeyboardType.Text,
                80,
                theme
            ) {
                viewModel.setTitle(it)
            }
            ProductSellingSpecEditItemFull(
                "Sub Title (Optional)",
                state.productSpecs.subTitle,
                KeyboardType.Text,
                55,
                theme
            ) {
                viewModel.setSubTitle(it)
            }
        }
    }
}

@Composable
fun ProductSellingCategoryScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.stateProductSellingModel.copy()) {
            apply {
                stater.stateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    OnLaunchScreenScope {
        viewModel.loadCategories()
    }
    Scaffold { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBar("Category", theme) {
                viewModel.donePressed()
                scope.launch {
                    navigator.goBack()
                }
            }
            Row(
                Modifier
                    .defaultMinSize(minHeight = 70.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 5.dp),
            ) {
                Text(modifier = Modifier.width(130.dp), text = "Product Category", color = theme.textGrayColor)
                Text(state.product.parentCatoFull, color = theme.textColor)
            }
            ExpandableCato(-1, state.listCategory, state.product.parentCategory) {
                viewModel.setCategory(it)
            }
        }
        LoadingScreen(state.isProcess, theme)
    }
}

@Composable
fun ProductSellingSpecsScreen(
    navigator: Navigator,
    isAdmin: Boolean,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.subStateProductSellingModel.copy()) {
            apply {
                stater.stateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    Scaffold { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBar("Item Specifics", theme) {
                scope.launch {
                    viewModel.donePressed()
                    navigator.goBack()
                }
            }
            LazyColumn {
                if (!isAdmin) {
                    ProductSellingSpecForEditItem("Condition", state.product.condition, theme) {
                        scope.launch {
                            navigator.navigateTo(RootComponent.Configuration.ProductSellingConditionRoute)
                        }
                    }
                    ProductSellingSpecForEditItem("Quantities", state.productSpecs.quantityEditStr, theme) {
                        scope.launch {
                            navigator.navigateTo(RootComponent.Configuration.ProductSellingQuantityRoute)
                        }
                    }
                }
                ProductSellingSpecForEditItem("Made in", state.productSpecs.countryProductStr, theme) {
                    scope.launch {
                        navigator.navigateTo(RootComponent.Configuration.ProductSellingMadeInRoute)
                    }
                }
                ProductSellingSpecForEditItem("Platform", state.productSpecs.platform, theme) {
                    scope.launch {
                        navigator.navigateTo(RootComponent.Configuration.ProductSellingPlatformRoute)
                    }
                }
                ProductSellingSpecForEditItem("Rating", state.product.ageRateStr, theme) {
                    scope.launch {
                        navigator.navigateTo(RootComponent.Configuration.ProductSellingRatingRoute)
                    }
                }
                ProductSellingSpecForEditItem("Release Year", state.productSpecs.releaseYearOnly, theme) {
                    scope.launch {
                        navigator.navigateTo(RootComponent.Configuration.ProductSellingReleaseYearRoute)
                    }
                }
                ProductSellingSpecForEditItem("MPN", state.productSpecs.mpn, theme) {
                    scope.launch {
                        navigator.navigateTo(RootComponent.Configuration.ProductSellingMPNRoute)
                    }
                }
                ProductSellingSpecForEditItem("UPC", state.product.productCode, theme) {
                    scope.launch {
                        navigator.navigateTo(RootComponent.Configuration.ProductSellingUPCRoute)
                    }
                }
                itemsIndexed(state.productSpecs.specs) { i, it ->
                    ProductSellingSpecForEdit(it.label, it.spec, theme) {
                        scope.launch {
                            navigator.navigateTo(RootComponent.Configuration.ProductSellingCustomSpecRoute(i))
                        }
                    }
                }
                item {
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(modifier = Modifier.clickable {
                            scope.launch {
                                navigator.navigateTo(RootComponent.Configuration.ProductSellingCustomSpecRoute(-1))
                            }
                        }.padding(15.dp), text = "ADD CUSTOM SPECIFIC", color = theme.primary)
                    }
                }
            }
        }
    }
}

@Composable
fun ProductSellingConditionScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.subStateProductSellingModel.copy()) {
            apply {
                stater.subStateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    Scaffold { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBarBackHelp("Condition", theme) {
                scope.launch {
                    navigator.goBack()
                }
            }
            Text(
                modifier = Modifier.padding(5.dp),
                text = "Select Condition of your Item",
                color = theme.textColor,
                fontSize = 24.sp,
            )
            Column {
                conditions.forEach {
                    ProductSpecItemRadio(it, it == state.product.condition, theme) {
                        viewModel.setCondition(it)
                        scope.launch {
                            navigator.goBack()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProductSellingMadeInScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.subStateProductSellingModel.copy()) {
            apply {
                stater.subStateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    Scaffold { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBarBackHelp("Made In", theme) {
                scope.launch {
                    navigator.goBack()
                }
            }
            /** Try That Later
             *https://github.com/philipplackner/SearchFieldCompose/blob/master/app/src/main/java/com/plcoding/searchfieldcompose/MainViewModel.kt
             */
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                value = state.countrySearch,
                onValueChange = { change ->
                    viewModel.setCountrySearch(change)
                },
                shape = RoundedCornerShape(25.dp),
                placeholder = { Text(text = "Search For Product Country", fontSize = 14.sp) },
                label = { Text(text = "Product Country", fontSize = 14.sp) },
                maxLines = 1,
                colors = theme.outlinedTextFieldStyle(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            )
            LazyColumn(Modifier.fillMaxWidth().padding(horizontal = 15.dp)) {
                items(state.countryList) {
                    val isSelect = it.id == state.productSpecs.countryProduct
                    Row(Modifier.clickable {
                        viewModel.setMadeIn(it.id)
                        scope.launch {
                            navigator.goBack()
                        }
                    }.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = it.display,
                            color = if (isSelect) theme.primary else theme.textColor,
                            fontSize = 20.sp,
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun ProductSellingPlatformScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.subStateProductSellingModel.copy()) {
            apply {
                stater.subStateProductSelling = this@apply
            }
        }
    }
) {

    val scope = rememberCoroutineScope()
    @Suppress("UNUSED_VARIABLE") val state by viewModel.uiState.collectAsState()
    Scaffold { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBarBackHelp("Platform", theme) {
                scope.launch {
                    navigator.goBack()
                }
            }
        }
    }
}

@Composable
fun ProductSellingRatingScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.subStateProductSellingModel.copy()) {
            apply {
                stater.subStateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    Scaffold { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBarBackHelp("Product Age Rating", theme) {
                scope.launch {
                    navigator.goBack()
                }
            }
            Text(
                modifier = Modifier.padding(5.dp),
                text = "Select Product Rating",
                color = theme.textColor,
                fontSize = 24.sp,
            )
            Column {
                ratings.forEach { rate ->
                    ProductSpecItemRadio(rate.display, state.product.ageRating == rate.id, theme) {
                        scope.launch {
                            viewModel.setAgeRate(rate.id)
                            navigator.goBack()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProductSellingReleaseYearScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.subStateProductSellingModel.copy()) {
            apply {
                stater.subStateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    val maxYear = currentTime.year
    val year = if (state.productSpecs.releaseYear == 0L) maxYear else splitTime(state.productSpecs.releaseYear).year
    Scaffold { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBarBackHelp("Release Year", theme) {
                scope.launch {
                    navigator.goBack()
                }
            }
            Text(
                modifier = Modifier.padding(5.dp),
                text = "Select Product Release Year",
                color = theme.textColor,
                fontSize = 24.sp,
            )
            CalendarYearView(selectedYear = year, maxYear = maxYear, minYear = 1970, theme = theme) {
                viewModel.setReleaseYear(margeYear(it))
                scope.launch {
                    navigator.goBack()
                }
            }
        }
    }
}

@Composable
fun ProductSellingCustomSpecScreen(
    navigator: Navigator,
    customSpecIndex: Int,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.subStateProductSellingModel.copy()) {
            apply {
                stater.subStateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    val customSpec = remember {
        mutableStateOf(
            if (customSpecIndex == -1) {
                ProductSpecs()
            } else {
                state.productSpecs.specs.getOrElse(customSpecIndex) {
                    ProductSpecs()
                }
            }
        )
    }
    Scaffold { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBar("Custom Specific", theme) {
                viewModel.addOrEditCustomSpec(customSpec.value, customSpecIndex)
                scope.launch {
                    navigator.goBack()
                }
            }
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                value = customSpec.value.label,
                onValueChange = { change ->
                    customSpec.value = customSpec.value.copy(label = change)
                },
                shape = RoundedCornerShape(12.dp),
                placeholder = { Text(text = "Enter Spec Title", fontSize = 14.sp) },
                label = { Text(text = "Spec Title", fontSize = 14.sp) },
                isError = customSpec.value.label.length > 40,
                supportingText = {
                    Text(
                        text = "${customSpec.value.label.length} / 40",
                        modifier = Modifier.fillMaxWidth(),
                        color = theme.textHintColor,
                        textAlign = TextAlign.End,
                    )
                },
                colors = theme.outlinedTextFieldStyle(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            )
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                value = customSpec.value.spec,
                onValueChange = { change ->
                    customSpec.value = customSpec.value.copy(spec = change)
                },
                shape = RoundedCornerShape(12.dp),
                placeholder = { Text(text = "Enter Spec", fontSize = 14.sp) },
                label = { Text(text = "Spec", fontSize = 14.sp) },
                isError = customSpec.value.spec.length > 40,
                supportingText = {
                    Text(
                        text = "${customSpec.value.spec.length} / 40",
                        modifier = Modifier.fillMaxWidth(),
                        color = theme.textHintColor,
                        textAlign = TextAlign.End,
                    )
                },
                maxLines = 1,
                colors = theme.outlinedTextFieldStyle(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            )
            Spacer(Modifier.height(10.dp))
            if (customSpecIndex != -1) {
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(modifier = Modifier.clickable {
                        viewModel.setDeleteCustomSpec(customSpecIndex)
                        scope.launch {
                            navigator.goBack()
                        }
                    }.padding(15.dp), text = "DELETE", color = theme.error)
                }
            }
        }
    }
}

@Composable
fun ProductSellingCustomSpecExtraScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.subStateProductSellingModel.copy()) {
            apply {
                stater.stateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    Scaffold { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBar("Listed Specs", theme) {
                scope.launch {
                    viewModel.donePressed()
                    navigator.goBack()
                }
            }
            Spacer(Modifier.height(10.dp))
            LazyColumn(Modifier.fillMaxWidth().padding(horizontal = 15.dp)) {
                itemsIndexed(state.productSpecs.specsExtra) { i, it ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        Text(modifier = Modifier.width(130.dp), text = it.labelExtra, color = theme.textGrayColor)
                        Text(modifier = Modifier.weight(1F), text = it.specExtra.joinToString("\n"){ it1 -> it1.labelSpec }, color = theme.textColor)
                        Image(
                            modifier = Modifier
                                .width(40.dp)
                                .height(40.dp)
                                .clickable {
                                    scope.launch {
                                        navigator.navigateTo(RootComponent.Configuration.ProductSellingCustomSpecExtraListRoute(i))
                                    }
                                }
                                .padding(8.dp),
                            imageVector = rememberEdit(theme.textHintColor),
                            contentScale = ContentScale.Fit,
                            contentDescription = null,
                        )
                        Spacer(Modifier.height(10.dp))
                    }
                }
                item {
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(modifier = Modifier.clickable {
                            scope.launch {
                                navigator.navigateTo(RootComponent.Configuration.ProductSellingCustomSpecExtraListRoute(-1))
                            }
                        }.padding(15.dp), text = "ADD LISTED SPECIFIC", color = theme.primary)
                    }
                }
            }

        }
    }
}

@Composable
fun ProductSellingCustomSpecExtraListScreen(
    navigator: Navigator,
    customSpecExtraIndex: Int,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.subStateProductSellingModel.copy()) {
            apply {
                stater.subStateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    val customSpecExtra = remember {
        mutableStateOf(
            if (customSpecExtraIndex == -1) {
                ProductSpecsExtra("", listOf(SpecExtra("", -1F,1, 1, "")))
            } else {
                state.productSpecs.specsExtra.getOrElse(customSpecExtraIndex) {
                    ProductSpecsExtra("", listOf(SpecExtra("", -1F,1, 1,"")))
                }
            }
        )
    }
    Scaffold { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBar("Custom Listed Specific", theme) {
                viewModel.addOrEditCustomSpecExtra(customSpecExtra.value, customSpecExtraIndex)
                scope.launch {
                    navigator.goBack()
                }
            }
            ProductSellingSpecItem("Price", state.product.priceStr, theme)
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                value = customSpecExtra.value.labelExtra,
                onValueChange = { change ->
                    customSpecExtra.value = customSpecExtra.value.copy(labelExtra = change)
                },
                shape = RoundedCornerShape(12.dp),
                //placeholder = { Text(text = "Enter Spec Title", fontSize = 14.sp) },
                label = { Text(text = "Spec Title", fontSize = 14.sp) },
                isError = customSpecExtra.value.labelExtra.length > 40,
                supportingText = {
                    Text(
                        text = "${customSpecExtra.value.labelExtra.length} / 40",
                        modifier = Modifier.fillMaxWidth(),
                        color = theme.textHintColor,
                        textAlign = TextAlign.End,
                    )
                },
                colors = theme.outlinedTextFieldStyle(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            )
            Spacer(Modifier.height(20.dp))
            LazyColumn {
                itemsIndexed(customSpecExtra.value.specExtra) { i, spec ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column {
                            OutlinedTextField(
                                modifier = Modifier.fillMaxWidth(1F).padding(horizontal = 5.dp),
                                value = spec.labelSpec,
                                onValueChange = { change ->
                                    customSpecExtra.value.specExtra.toMutableList().apply {
                                        getOrNull(i)?.labelSpec = change
                                    }.also {
                                        customSpecExtra.value = customSpecExtra.value.copy(specExtra = it, dummy = customSpecExtra.value.dummy + 1)
                                    }
                                },
                                shape = RoundedCornerShape(12.dp),
                                //placeholder = { Text(text = "Spec Section Label", fontSize = 14.sp) },
                                label = { Text(text = "Spec Section Label", fontSize = 14.sp) },
                                isError = spec.labelSpec.length > 40,
                                supportingText = {
                                    Text(
                                        text = "${spec.labelSpec.length} / 40",
                                        modifier = Modifier.fillMaxWidth(),
                                        color = theme.textHintColor,
                                        textAlign = TextAlign.End,
                                    )
                                },
                                maxLines = 1,
                                colors = theme.outlinedTextFieldStyle(),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            )
                            Row {
                                OutlinedTextField(
                                    modifier = Modifier.weight(1F).padding(horizontal = 5.dp),
                                    value = spec.priceSpecEditStr,
                                    onValueChange = { change ->
                                        customSpecExtra.value.specExtra.toMutableList().apply {
                                            getOrNull(i)?.apply f@{
                                                change.toFloatOrNull()?.let { it1 ->
                                                    plusPriceSpec = it1
                                                }
                                                priceSpecEditStr = change
                                            }
                                        }.also {
                                            customSpecExtra.value = customSpecExtra.value.copy(specExtra = it, dummy = customSpecExtra.value.dummy + 1)
                                        }
                                    },
                                    shape = RoundedCornerShape(12.dp),
                                    //placeholder = { Text(text = "Spec Additional Price", fontSize = 14.sp) },
                                    label = { Text(text = "Spec Additional Price", fontSize = 14.sp) },
                                    isError = spec.priceSpecEditStr.length > 12,
                                    supportingText = {
                                        Text(
                                            text = "${spec.priceSpecEditStr.length} / 12",
                                            modifier = Modifier.fillMaxWidth(),
                                            color = theme.textHintColor,
                                            textAlign = TextAlign.End,
                                        )
                                    },
                                    maxLines = 1,
                                    colors = theme.outlinedTextFieldStyle(),
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                )
                                OutlinedTextField(
                                    modifier = Modifier.weight(1F).padding(horizontal = 5.dp),
                                    value = spec.quantityEditStr,
                                    onValueChange = { change ->
                                        customSpecExtra.value.specExtra.toMutableList().apply {
                                            getOrNull(i)?.apply f@{
                                                change.toIntOrNull()?.let { it1 ->
                                                    quantity = it1
                                                }
                                                quantityEditStr = change
                                            }
                                        }.also {
                                            customSpecExtra.value = customSpecExtra.value.copy(specExtra = it, dummy = customSpecExtra.value.dummy + 1)
                                        }
                                    },
                                    shape = RoundedCornerShape(12.dp),
                                    //placeholder = { Text(text = "Spec Quantity", fontSize = 14.sp) },
                                    label = { Text(text = "Spec Quantity", fontSize = 14.sp) },
                                    isError = spec.quantityEditStr.length > 12,
                                    supportingText = {
                                        Text(
                                            text = "${spec.quantityEditStr.length} / 12",
                                            modifier = Modifier.fillMaxWidth(),
                                            color = theme.textHintColor,
                                            textAlign = TextAlign.End,
                                        )
                                    },
                                    maxLines = 1,
                                    colors = theme.outlinedTextFieldStyle(),
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                )
                            }
                        }
                        Box(contentAlignment = Alignment.Center) {
                            Image(
                                modifier = Modifier
                                    .width(40.dp)
                                    .height(40.dp).clickable {
                                        customSpecExtra.value.specExtra.toMutableList().apply {
                                            removeAt(i)
                                        }.also {
                                            customSpecExtra.value = customSpecExtra.value.copy(specExtra = it)
                                        }
                                    }
                                    .background(color = theme.backDark, shape = CircleShape)
                                    .padding(8.dp),
                                imageVector = rememberDeleteForever(theme.textColor),
                                contentScale = ContentScale.Fit,
                                contentDescription = null,
                            )
                        }
                    }
                }
                item {
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(modifier = Modifier.clickable {
                            customSpecExtra.value.specExtra.toMutableList().apply {
                                add(SpecExtra("", -1F))
                            }.also {
                                customSpecExtra.value = customSpecExtra.value.copy(specExtra = it)
                            }
                        }.padding(15.dp), text = "ADD SECTION", color = theme.primary)
                    }
                    Spacer(Modifier.height(20.dp))
                }
            }
            Spacer(Modifier.height(10.dp))
            if (customSpecExtraIndex != -1) {
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(modifier = Modifier.clickable {
                        viewModel.setDeleteCustomSpecExtra(customSpecExtraIndex)
                        scope.launch {
                            navigator.goBack()
                        }
                    }.padding(15.dp), text = "DELETE", color = theme.error)
                }
            }
        }
    }
}

@Composable
fun ProductSellingMPNScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.subStateProductSellingModel.copy()) {
            apply {
                stater.subStateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    Scaffold { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBar("MPN", theme) {
                if (state.product.productCode.length > 65) {
                    return@ProductSellingSpecsHeadBar
                }
                viewModel.donePressed()
                scope.launch {
                    navigator.goBack()
                }
            }
            ProductSellingSpecEditItemFull(
                "Manufacturer Part Number",
                state.productSpecs.mpn,
                KeyboardType.Text,
                65,
                theme
            ) {
                viewModel.setMPN(it)
            }
        }
    }
}


@Composable
fun ProductSellingUPCScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.subStateProductSellingModel.copy()) {
            apply {
                stater.subStateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    Scaffold { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBar("UPC", theme) {
                if (state.product.productCode.length > 12) {
                    return@ProductSellingSpecsHeadBar
                }
                viewModel.donePressed()
                scope.launch {
                    navigator.goBack()
                }
            }
            ProductSellingSpecEditItemFull(
                "Universal Product Codes ",
                state.product.productCode,
                KeyboardType.Text,
                12,
                theme
            ) {
                viewModel.setUPC(it)
            }
        }
    }
}

@Composable
fun ProductSellingQuantityScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.subStateProductSellingModel.copy()) {
            apply {
                stater.subStateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    Scaffold { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBar("Quantity", theme) {
                if (state.product.productCode.length > 12) {
                    return@ProductSellingSpecsHeadBar
                }
                viewModel.donePressed()
                scope.launch {
                    navigator.goBack()
                }
            }
            ProductSellingSpecEditItemFull(
                "Product Quantities",
                state.productSpecs.quantityEditStr,
                KeyboardType.Text,
                12,
                theme
            ) {
                viewModel.setQuantity(it)
            }
            Text("Tip: If Item Listed Specifics quantities added, this value will be ignored", color = theme.textHintColor)
        }
    }
}

@Composable
fun ProductSpecItemRadio(text: String, isSelect: Boolean, theme: Theme, onClick: () -> Unit) {
    Row(Modifier.clickable { onClick() }.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = isSelect, onClick = null)
        Spacer(Modifier.width(10.dp))
        Text(
            text = text,
            color = theme.textColor,
            fontSize = 20.sp,
        )
    }
}

@Composable
fun ProductShippingScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.subStateProductSellingModel.copy()) {
            apply {
                stater.stateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    Scaffold { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBar("Item Specifics", theme) {
                viewModel.donePressed()
                scope.launch {
                    navigator.goBack()
                }
            }
            LazyColumn {
                ProductSellingSpecForEditItem("Package Details", state.deliveryProcess.size, theme) {

                }
                ProductSellingSpecForSubEditItem("Shipping Service", state.deliveryProcess.shippingService, state.deliveryProcess.durationStr, theme) {

                }
                ProductSellingSpecForEditItem("Shipping Coast", state.deliveryProcess.deliveryCostStr, theme) {
                    scope.launch {
                        navigator.navigateTo(RootComponent.Configuration.ProductShippingCostRoute)
                    }
                }
                ProductSellingSpecForEditItem("Delivery Location", state.deliveryProcess.location, theme) {

                }
            }
        }
    }
}

@Composable
fun ProductShippingCostScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    stater: Stater = koinInject(),
    viewModel: ProductSellingViewModel = MokoModel {
        ProductSellingViewModel(project, stater.subStateProductSellingModel.copy()) {
            apply {
                stater.subStateProductSelling = this@apply
            }
        }
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    val scaffoldState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(scaffoldState) {
                Snackbar(it, containerColor = theme.backDarkSec, contentColor = theme.textColor)
            }
        },
    ) { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBar("Shipping Cost", theme) {
                viewModel.donePressed()
                scope.launch {
                    navigator.goBack()
                }
            }
            ProductSellingSpecEditItem(
                "Cost",
                state.deliveryProcess.deliveryCostEditStr,
                KeyboardType.Number, theme
            ) {
                viewModel.setDeliveryCost(it)
            }
        }
    }
}

fun LazyListScope.ProductSellingSpecForEditItem(specTitle: String, spec: String, theme: Theme, onClick: () -> Unit) = item {
    /*if (spec.isEmpty()) {
        return
    }*/
    Column(
        Modifier
            .clickable {
                onClick()
            }
            .padding(horizontal = 10.dp, vertical = 15.dp)
    ) {
        Text(text = specTitle, color = theme.textColor)
        Text(spec, color = theme.primary)
    }
}
fun LazyListScope.ProductSellingSpecForSubEditItem(specTitle: String, spec: String, specSub: String, theme: Theme, onClick: () -> Unit) = item {
    /*if (spec.isEmpty()) {
        return
    }*/
    Column(
        Modifier
            .clickable {
                onClick()
            }
            .padding(horizontal = 10.dp, vertical = 15.dp)
    ) {
        Text(modifier = Modifier.width(130.dp), text = specTitle, color = theme.textColor)
        Text(spec, color = theme.primary)
        Text(specSub, color = theme.textGrayColor)
    }
}


@Composable
fun ProductSellingSpecForEdit(specTitle: String, spec: String, theme: Theme, onClick: () -> Unit) {
    /*if (spec.isEmpty()) {
        return
    }*/
    Column(
        Modifier
            .clickable {
                onClick()
            }
            .padding(horizontal = 10.dp, vertical = 15.dp)
    ) {
        Text(modifier = Modifier.width(130.dp), text = specTitle, color = theme.textColor)
        Text(spec, color = theme.primary)
    }
}

@Composable
fun ProductSellingSpecCheckableTitle(spec: String, subSpec: String, checked: Boolean, enabled: Boolean, theme: Theme, onChange: (Boolean) -> Unit) {
    Row(modifier = Modifier.padding(10.dp)) {
        Column(modifier = Modifier.weight(1F)) {
            Text(spec, color = theme.textColor)
            Text(subSpec, color = theme.textGrayColor, fontSize = 14.sp)
        }
        Column(
            modifier = Modifier
                .width(70.dp)
                .padding(10.dp)
        ) {
            Switch(enabled = enabled, checked = checked, onCheckedChange = onChange)
        }
    }
}


@Composable
fun ProductSellingSpecEditItem(specTitle: String, spec: String, keyType: KeyboardType, theme: Theme, onChange: (String) -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(modifier = Modifier.width(130.dp), text = specTitle, color = theme.textGrayColor)
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = spec,
            onValueChange = { change ->
                onChange(change)
            },
            shape = RoundedCornerShape(12.dp),
            placeholder = { Text(text = "Enter $specTitle", fontSize = 14.sp) },
            //label = { Text(text = specTitle, fontSize = 14.sp) },
            maxLines = 1,
            colors = theme.outlinedTextFieldStyle(),
            keyboardOptions = KeyboardOptions(keyboardType = keyType),
        )
    }
}


@Composable
fun ProductSellingSpecEditItemFull(specTitle: String, spec: String, keyType: KeyboardType, error: Int, theme: Theme, onChange: (String) -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = spec,
            onValueChange = { change ->
                onChange(change)
            },
            shape = RoundedCornerShape(12.dp),
            placeholder = { Text(text = "Enter $specTitle", fontSize = 14.sp) },
            label = { Text(text = specTitle, fontSize = 14.sp) },
            isError = spec.length > error,
            supportingText = {
                Text(
                    text = "${spec.length} / $error",
                    modifier = Modifier.fillMaxWidth(),
                    color = theme.textHintColor,
                    textAlign = TextAlign.End,
                )
            },
            colors = theme.outlinedTextFieldStyle(),
            keyboardOptions = KeyboardOptions(keyboardType = keyType),
        )
    }
}


@Composable
fun ProductSellingSpecsHeadBar(
    //navigator: Navigator,
    text: String,
    theme: Theme,
    onClick: () -> Unit,
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
                .padding(8.dp),
            imageVector = rememberHelp(theme.textColor),
            contentScale = ContentScale.Fit,
            contentDescription = null,
        )
        Text(
            modifier = Modifier.padding(horizontal = 5.dp),
            text = text,
            color = theme.textColor,
            fontSize = 20.sp,
        )
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(50.dp)
                .clickable {
                    onClick()
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Done",
                color = theme.primary,
                fontSize = 20.sp,
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}


@Composable
fun ProductSellingSpecsHeadBarBack(
    text: String,
    theme: Theme,
    onClick: () -> Unit,
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
                .background(color = theme.background, shape = CircleShape)
                .clickable {
                    onClick()
                }
                .padding(8.dp),
            imageVector = rememberArrowBack(theme.textColor),
            contentScale = ContentScale.Fit,
            contentDescription = null,
        )
        Text(
            text = text,
            color = theme.textColor,
            fontSize = 20.sp,
        )
        Spacer(
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun ProductSellingSpecsHeadBarBackHelp(
    text: String,
    theme: Theme,
    onBackClick: () -> Unit,
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 5.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .background(color = theme.background, shape = CircleShape)
                .clickable {
                    onBackClick()
                }
                .padding(8.dp),
            imageVector = rememberArrowBack(theme.textColor),
            contentScale = ContentScale.Fit,
            contentDescription = null,
        )
        Spacer(Modifier.width(15.dp))
        Text(
            modifier = Modifier.weight(1F),
            text = text,
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