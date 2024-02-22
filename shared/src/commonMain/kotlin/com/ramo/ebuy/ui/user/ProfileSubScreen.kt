package com.ramo.ebuy.ui.user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramo.ebuy.AppViewModel
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.di.Stater
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.navigation.MokoModel
import com.ramo.ebuy.global.navigation.Navigator
import com.ramo.ebuy.global.navigation.RootComponent
import com.ramo.ebuy.global.ui.LoadingScreen
import com.ramo.ebuy.global.ui.OnLaunchScreenScope
import com.ramo.ebuy.ui.common.BarCartScreen
import com.ramo.ebuy.ui.common.BarWatchListScreen
import com.ramo.ebuy.ui.common.ProductsUserCart
import com.ramo.ebuy.ui.common.ProductsWatchList
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun WatchlistScreen(
    navigator: Navigator,
    appModel: AppViewModel,
    theme: Theme = koinInject(),
    stater: Stater = koinInject(),
    project: Project = koinInject(),
    viewModel: ProfileSubViewModel = MokoModel {
        ProfileSubViewModel(project, appModel.cartList, appModel.pasteCart, appModel.watchlist)
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()

    OnLaunchScreenScope {
        viewModel.displayWatchList()
    }
    Scaffold { pad ->
        Column(Modifier.fillMaxSize().padding(pad)) {
            BarWatchListScreen(appModel.uiState.collectAsState().value.cartList.size, theme) {
                when (it) {
                    0 -> {
                        scope.launch {
                            navigator.goBack()
                        }
                    }
                    1 -> {
                        scope.launch {
                            stater.stateHomeViewModel?.copy(selectedPage = 2)?.apply {
                                stater.stateHomeViewModel = this
                            }
                            navigator.goBack()
                        }
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
            Spacer(modifier = Modifier.height(10.dp))
            ProductsWatchList(state.productsWatchList) {
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
        LoadingScreen(state.isProcess, theme)
    }

}


@Composable
fun CartScreen(
    navigator: Navigator,
    appModel: AppViewModel,
    theme: Theme = koinInject(),
    stater: Stater = koinInject(),
    project: Project = koinInject(),
    viewModel: ProfileSubViewModel = MokoModel {
        ProfileSubViewModel(project, appModel.cartList, appModel.pasteCart, appModel.watchlist)
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()

    OnLaunchScreenScope {
        viewModel.loadCartProducts()
    }
    Scaffold { pad ->
        Column(Modifier.fillMaxSize().padding(pad)) {
            BarCartScreen(theme) {
                scope.launch {
                    navigator.goBack()
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            ProductsUserCart(state.cartProducts, { item, it ->
                viewModel.cartQuantityChanged(item, it)
            }) {
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
        LoadingScreen(state.isProcess, theme)
    }

}