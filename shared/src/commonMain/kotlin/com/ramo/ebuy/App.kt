package com.ramo.ebuy

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.di.Stater
import com.ramo.ebuy.di.initApp
import com.ramo.ebuy.global.base.MyApplicationTheme
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.navigation.MokoModel
import com.ramo.ebuy.global.navigation.Navigator
import com.ramo.ebuy.global.navigation.RootComponent
import com.ramo.ebuy.global.navigation.RootComponent.Screen
import com.ramo.ebuy.global.ui.OnLaunchScreen
import com.ramo.ebuy.global.ui.OnLaunchScreenScope
import com.ramo.ebuy.global.ui.rememberEbuy
import com.ramo.ebuy.global.ui.rememberWifiOff
import com.ramo.ebuy.ui.admin.AdminHomeScreen
import com.ramo.ebuy.ui.admin.CategoryCreatingScreen
import com.ramo.ebuy.ui.product.ProductConditionMainScreen
import com.ramo.ebuy.ui.product.ProductDetailsScreen
import com.ramo.ebuy.ui.product.ProductSellingCategoryScreen
import com.ramo.ebuy.ui.product.ProductSellingConditionScreen
import com.ramo.ebuy.ui.product.ProductSellingCustomSpecExtraScreen
import com.ramo.ebuy.ui.product.ProductSellingCustomSpecListScreen
import com.ramo.ebuy.ui.product.ProductSellingCustomSpecScreen
import com.ramo.ebuy.ui.product.ProductSellingMPNScreen
import com.ramo.ebuy.ui.product.ProductSellingMadeInScreen
import com.ramo.ebuy.ui.product.ProductSellingPlatformScreen
import com.ramo.ebuy.ui.product.ProductSellingPriceScreen
import com.ramo.ebuy.ui.product.ProductSellingQuantityScreen
import com.ramo.ebuy.ui.product.ProductSellingRatingScreen
import com.ramo.ebuy.ui.product.ProductSellingReleaseYearScreen
import com.ramo.ebuy.ui.product.ProductSellingScreen
import com.ramo.ebuy.ui.product.ProductSellingSpecsScreen
import com.ramo.ebuy.ui.product.ProductSellingTitleScreen
import com.ramo.ebuy.ui.product.ProductSellingUPCScreen
import com.ramo.ebuy.ui.product.ProductShippingCostScreen
import com.ramo.ebuy.ui.product.ProductShippingScreen
import com.ramo.ebuy.ui.sign.LogInEmailScreen
import com.ramo.ebuy.ui.sign.LogInScreen
import com.ramo.ebuy.ui.user.CartScreen
import com.ramo.ebuy.ui.user.HomeUserScreen
import com.ramo.ebuy.ui.user.SearchProcessScreen
import com.ramo.ebuy.ui.user.WatchlistScreen
import io.github.jan.supabase.gotrue.SessionStatus
import kotlinx.coroutines.launch
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject

@Composable
fun Main(root: RootComponent) {
    KoinApplication(
        application = initApp(isDarkMode = isSystemInDarkTheme())
    ) {
        val theme: Theme = koinInject()
        val project: Project = koinInject()
        val stater: Stater = koinInject()
        val appViewModel: AppViewModel = MokoModel {
            AppViewModel(project)
        }
        DisposableEffect(Unit) {
            onDispose {
                stater.onCleared()
            }
        }
        val childStack by root.childStack.subscribeAsState()
        MyApplicationTheme(theme = theme) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = theme.background
            ) {
                Children(
                    stack = childStack,
                    animation = stackAnimation(slide())
                ) { child ->
                    when (val instance = child.instance) {
                        is Screen.SplashRoute -> SplashScreen(instance.component, appViewModel = appViewModel)
                        is Screen.LogInRoute -> LogInScreen(instance.component)
                        is Screen.LogInEmailRoute -> LogInEmailScreen(instance.component, instance.isRegister)
                        is Screen.HomeUserRoute -> HomeUserScreen(instance.component, appViewModel)
                        is Screen.ProductDetailsRoute -> ProductDetailsScreen(instance.component, appViewModel, instance.productId)
                        is Screen.ProductSellingRoute -> ProductSellingScreen(instance.component, instance.productId, instance.isAdmin)
                        is Screen.ProductConditionMainRoute -> ProductConditionMainScreen(instance.component)
                        is Screen.ProductSellingPriceRoute -> ProductSellingPriceScreen(instance.component)
                        is Screen.ProductSellingTitleRoute -> ProductSellingTitleScreen(instance.component)
                        is Screen.ProductSellingSpecRoute -> ProductSellingSpecsScreen(instance.component, instance.isAdmin)
                        is Screen.ProductSellingCategoryRoute -> ProductSellingCategoryScreen(instance.component)
                        is Screen.ProductSellingConditionRoute -> ProductSellingConditionScreen(instance.component)
                        is Screen.ProductSellingMadeInRoute -> ProductSellingMadeInScreen(instance.component)
                        is Screen.ProductSellingPlatformRoute -> ProductSellingPlatformScreen(instance.component)
                        is Screen.ProductSellingRatingRoute -> ProductSellingRatingScreen(instance.component)
                        is Screen.ProductSellingReleaseYearRoute -> ProductSellingReleaseYearScreen(instance.component)
                        is Screen.ProductSellingCustomSpecRoute -> ProductSellingCustomSpecScreen(instance.component, instance.index)
                        is Screen.ProductSellingMPNRoute -> ProductSellingMPNScreen(instance.component)
                        is Screen.ProductSellingUPCRoute -> ProductSellingUPCScreen(instance.component)
                        is Screen.ProductSellingQuantityRoute -> ProductSellingQuantityScreen(instance.component)
                        is Screen.ProductSellingCustomSpecExtraRoute -> ProductSellingCustomSpecExtraScreen(instance.component)
                        is Screen.ProductSellingCustomSpecExtraListRoute -> ProductSellingCustomSpecListScreen(instance.component, instance.index)
                        is Screen.ProductShippingRoute -> ProductShippingScreen(instance.component)
                        is Screen.ProductShippingCostRoute -> ProductShippingCostScreen(instance.component)
                        is Screen.CategoryCreatingRoute -> CategoryCreatingScreen(instance.component)
                        is Screen.AdminHomeRoute -> AdminHomeScreen(instance.component)
                        is Screen.SearchProcessRoute -> SearchProcessScreen(instance.component, appViewModel, instance.searchText, instance.typeSearch)
                        is Screen.WatchListRoute -> WatchlistScreen(instance.component, appViewModel)
                        is Screen.CartRoute -> CartScreen(instance.component, appViewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun SplashScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    stater: Stater = koinInject(),
    appViewModel: AppViewModel
) {
    val scope = rememberCoroutineScope()
    val state by appViewModel.uiState.collectAsState()
    OnLaunchScreenScope {
        appViewModel.init()
    }
    when (val sessionStatus = state.sessionStatus) {
        is SessionStatus.Authenticated -> {
            appViewModel.fetchUser(sessionStatus.session).let { user ->
                if (user != null) {
                    if (user.userType == 1) {
                        scope.launch {
                            navigator.navigateHome(RootComponent.Configuration.AdminHomeRoute)
                        }
                    } else {
                        appViewModel.preLoadMainData { cato, products ->
                            scope.launch {
                                stater.stateHomeViewModel = stater.stateHomeModel.copy(circleCato = cato, productVer = products)
                                navigator.navigateHome(RootComponent.Configuration.HomeUserRoute)
                            }
                        }
                    }
                } else {
                    scope.launch {
                        navigator.navigateHome(RootComponent.Configuration.LogInRoute)
                    }
                }
            }
            Scaffold { pad ->
                Surface(
                    modifier = Modifier.fillMaxSize().padding(pad),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Image(
                            modifier = Modifier.width(100.dp),
                            imageVector = rememberEbuy(),
                            contentDescription = ""
                        )
                    }
                }
            }
        }

        is SessionStatus.NotAuthenticated -> {
            OnLaunchScreen {
                scope.launch {
                    navigator.navigateHome(RootComponent.Configuration.LogInRoute)
                }
            }
            Scaffold { pad ->
                Surface(
                    modifier = Modifier.fillMaxSize().padding(pad),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Image(
                            modifier = Modifier.width(100.dp),
                            imageVector = rememberEbuy(),
                            contentDescription = ""
                        )
                    }
                }
            }
        }

        is SessionStatus.NetworkError -> {
            Scaffold { pad ->
                Surface(
                    modifier = Modifier.fillMaxSize().padding(pad),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Column {
                            Image(
                                modifier = Modifier.width(100.dp),
                                imageVector = rememberEbuy(),
                                contentDescription = ""
                            )
                            Spacer(Modifier.height(15.dp))
                            Image(
                                modifier = Modifier.width(50.dp),
                                imageVector = rememberWifiOff(theme.textGrayColor),
                                contentDescription = ""
                            )
                        }
                    }
                }
            }
        }

        is SessionStatus.LoadingFromStorage -> {
            Scaffold { pad ->
                Surface(
                    modifier = Modifier.fillMaxSize().padding(pad),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Image(
                            modifier = Modifier.width(100.dp),
                            imageVector = rememberEbuy(),
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}
