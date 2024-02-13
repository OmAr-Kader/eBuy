package com.ramo.ebuy.ui.user

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import com.ramo.ebuy.di.Stater
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.navigation.Navigator
import com.ramo.ebuy.global.navigation.RootComponent
import com.ramo.ebuy.global.ui.HotBar
import com.ramo.ebuy.global.ui.LoadingScreen
import com.ramo.ebuy.global.ui.OnLaunchScreen
import com.ramo.ebuy.global.ui.VerticalListSingleTitle
import com.ramo.ebuy.global.ui.VerticalListTitle
import com.ramo.ebuy.global.ui.collapse.CollapsingToolbar
import com.ramo.ebuy.global.ui.collapse.CollapsingToolbarScaffold
import com.ramo.ebuy.global.ui.collapse.ScrollStrategy
import com.ramo.ebuy.global.ui.collapse.rememberCollapsingToolbarScaffoldState
import com.ramo.ebuy.global.ui.collapse.rememberCollapsingToolbarState
import com.ramo.ebuy.global.util.hotBarData
import com.ramo.ebuy.ui.common.BarMainScreen
import com.ramo.ebuy.ui.common.CatoList
import com.ramo.ebuy.ui.common.ProductList
import com.ramo.ebuy.ui.common.SearchBarMainScreen
import kotlinx.coroutines.launch
import org.koin.compose.koinInject


@Composable
fun HomeSubScreen(
    navigator: Navigator,
    viewModel: HomeViewModel,
    theme: Theme = koinInject(),
    stater: Stater = koinInject(),
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    val scrollState = rememberCollapsingToolbarScaffoldState()
    val offsetY = scrollState.offsetY
    val catoList = state.circleCato

    OnLaunchScreen {
        viewModel.loadMainData()
    }
    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier.onSizeChanged { size ->
                viewModel.setRepeatableCato(size.width)
            }
        ) {
            Spacer(Modifier.height(56.dp))
            CollapsingToolbarScaffold(
                modifier = Modifier.fillMaxSize(),
                scrollStrategy = ScrollStrategy.EnterAlways,
                state = scrollState,
                toolbar = {
                    CollapsingToolbar(collapsingToolbarState = rememberCollapsingToolbarState()) {
                        Box(
                            Modifier.parallax().road(
                                whenCollapsed = Alignment.CenterStart,
                                whenExpanded = Alignment.CenterStart
                            )
                        ) {
                            SearchBarMainScreen()
                        }
                    }
                }
            ) {
                LazyColumn {
                    HotBar(hotData = hotBarData, theme) {

                    }
                    VerticalListSingleTitle("Explore Popular Categories", theme) {

                    }
                    CatoList(catoList = catoList, repeatableCategory = viewModel.repeatableCategory, repeatableCato = state.repeatableCato) {

                    }
                    VerticalListTitle("Daily Deals", theme) {

                    }
                    ProductList(list = state.productVer) {
                        stater.getScreenCount(RootComponent.Configuration.ProductDetailsRoute::class.java).let { count ->
                            RootComponent.Configuration.ProductDetailsRoute(-1, count + 1).also { route ->
                                scope.launch {
                                    stater.writeArguments(route = route, one = it.id.toString(), two = it.title, screenCount = count + 1)
                                    navigator.navigateTo(route)
                                }
                            }
                        }
                    }
                }
            }
        }
        BarMainScreen(offsetY)
        LoadingScreen(isLoading = state.isProcess, theme)
    }
}

