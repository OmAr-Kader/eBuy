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
import com.ramo.ebuy.ui.product.ProductSellingCustomSpecExtraListScreen
import com.ramo.ebuy.ui.product.ProductSellingCustomSpecExtraScreen
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
import com.ramo.ebuy.ui.user.HomeUserScreen
import com.ramo.ebuy.ui.user.SearchProcessScreen
import io.github.jan.supabase.gotrue.SessionStatus
import kotlinx.coroutines.launch
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject

@Composable
fun Main(root: RootComponent) {
    KoinApplication(
        application = initApp(isDarkMode = isSystemInDarkTheme())
    ) {
        val childStack by root.childStack.subscribeAsState()
        val theme: Theme = koinInject()
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
                        is RootComponent.Screen.SplashRoute -> SplashScreen(instance.component)
                        is RootComponent.Screen.LogInRoute -> LogInScreen(instance.component)
                        is RootComponent.Screen.LogInEmailRoute -> LogInEmailScreen(instance.component, instance.isRegister)
                        is RootComponent.Screen.HomeUserRoute -> HomeUserScreen(instance.component)
                        is RootComponent.Screen.ProductDetailsRoute -> ProductDetailsScreen(instance.component, instance.productId)
                        is RootComponent.Screen.ProductSellingRoute -> ProductSellingScreen(instance.component, instance.productId, instance.isAdmin)
                        is RootComponent.Screen.ProductConditionMainRoute -> ProductConditionMainScreen(instance.component)
                        is RootComponent.Screen.ProductSellingPriceRoute -> ProductSellingPriceScreen(instance.component)
                        is RootComponent.Screen.ProductSellingTitleRoute -> ProductSellingTitleScreen(instance.component)
                        is RootComponent.Screen.ProductSellingSpecRoute -> ProductSellingSpecsScreen(instance.component, instance.isAdmin)
                        is RootComponent.Screen.ProductSellingCategoryRoute -> ProductSellingCategoryScreen(instance.component)
                        is RootComponent.Screen.ProductSellingConditionRoute -> ProductSellingConditionScreen(instance.component)
                        is RootComponent.Screen.ProductSellingMadeInRoute -> ProductSellingMadeInScreen(instance.component)
                        is RootComponent.Screen.ProductSellingPlatformRoute -> ProductSellingPlatformScreen(instance.component)
                        is RootComponent.Screen.ProductSellingRatingRoute -> ProductSellingRatingScreen(instance.component)
                        is RootComponent.Screen.ProductSellingReleaseYearRoute -> ProductSellingReleaseYearScreen(instance.component)
                        is RootComponent.Screen.ProductSellingCustomSpecRoute -> ProductSellingCustomSpecScreen(instance.component, instance.index)
                        is RootComponent.Screen.ProductSellingMPNRoute -> ProductSellingMPNScreen(instance.component)
                        is RootComponent.Screen.ProductSellingUPCRoute -> ProductSellingUPCScreen(instance.component)
                        is RootComponent.Screen.ProductSellingQuantityRoute -> ProductSellingQuantityScreen(instance.component)
                        is RootComponent.Screen.ProductSellingCustomSpecExtraRoute -> ProductSellingCustomSpecExtraScreen(instance.component)
                        is RootComponent.Screen.ProductSellingCustomSpecExtraListRoute -> ProductSellingCustomSpecExtraListScreen(instance.component, instance.index)
                        is RootComponent.Screen.ProductShippingRoute -> ProductShippingScreen(instance.component)
                        is RootComponent.Screen.ProductShippingCostRoute -> ProductShippingCostScreen(instance.component)
                        is RootComponent.Screen.CategoryCreatingRoute -> CategoryCreatingScreen(instance.component)
                        is RootComponent.Screen.AdminHomeRoute -> AdminHomeScreen(instance.component)
                        is RootComponent.Screen.SearchProcessRoute -> SearchProcessScreen(instance.component, instance.searchText, instance.typeSearch)
                    }
                }
            }
        }
    }
}

@Composable
fun SplashScreen(
    navigator: Navigator,
    project: Project = koinInject(),
    theme: Theme = koinInject(),
    stater: Stater = koinInject(),
    viewModel: AppViewModel = MokoModel {
        AppViewModel(project)
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    OnLaunchScreenScope {
        viewModel.init()
    }
    when(val sessionStatus = state.sessionStatus) {
        is SessionStatus.Authenticated -> {
            viewModel.fetchUser(sessionStatus.session).let { user ->
                if (user != null) {
                    stater.user = user
                    if (user.userType == 1) {
                        scope.launch {
                            navigator.navigateHome(RootComponent.Configuration.AdminHomeRoute)
                        }
                    } else {
                        scope.launch {
                            navigator.navigateHome(RootComponent.Configuration.HomeUserRoute)
                        }
                    }
                } else {
                    scope.launch {
                        navigator.navigateHome(RootComponent.Configuration.LogInRoute)
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
