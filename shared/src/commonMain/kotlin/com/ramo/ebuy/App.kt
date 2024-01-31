package com.ramo.ebuy

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.ramo.ebuy.global.ui.OnLaunchScreenScope
import com.ramo.ebuy.global.ui.rememberEbuy
import com.ramo.ebuy.ui.product.ProductConditionMainScreen
import com.ramo.ebuy.ui.product.ProductDetailsScreen
import com.ramo.ebuy.ui.product.ProductSellingCategoryScreen
import com.ramo.ebuy.ui.product.ProductSellingConditionScreen
import com.ramo.ebuy.ui.product.ProductSellingCustomSpecScreen
import com.ramo.ebuy.ui.product.ProductSellingMPNScreen
import com.ramo.ebuy.ui.product.ProductSellingMadeInScreen
import com.ramo.ebuy.ui.product.ProductSellingPlatformScreen
import com.ramo.ebuy.ui.product.ProductSellingPriceScreen
import com.ramo.ebuy.ui.product.ProductSellingRatingScreen
import com.ramo.ebuy.ui.product.ProductSellingReleaseYearScreen
import com.ramo.ebuy.ui.product.ProductSellingScreen
import com.ramo.ebuy.ui.product.ProductSellingSpecsScreen
import com.ramo.ebuy.ui.product.ProductSellingTitleScreen
import com.ramo.ebuy.ui.product.ProductSellingUPCScreen
import com.ramo.ebuy.ui.sign.LogInEmailScreen
import com.ramo.ebuy.ui.sign.LogInScreen
import com.ramo.ebuy.ui.user.HomeUserScreen
import com.ramo.ebuy.ui.user.HomeViewModel
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
                        is RootComponent.Screen.LogInEmailRoute -> LogInEmailScreen(instance.component)
                        is RootComponent.Screen.HomeUserRoute -> HomeUserScreen(instance.component)
                        is RootComponent.Screen.ProductDetailsRoute -> ProductDetailsScreen(instance.component)
                        is RootComponent.Screen.ProductSellingRoute -> ProductSellingScreen(instance.component)
                        is RootComponent.Screen.ProductConditionMainRoute -> ProductConditionMainScreen(instance.component)
                        is RootComponent.Screen.ProductSellingPriceRoute -> ProductSellingPriceScreen(instance.component)
                        is RootComponent.Screen.ProductSellingTitleRoute -> ProductSellingTitleScreen(instance.component)
                        is RootComponent.Screen.ProductSellingSpecRoute -> ProductSellingSpecsScreen(instance.component)
                        is RootComponent.Screen.ProductSellingCategoryRoute -> ProductSellingCategoryScreen(instance.component)
                        is RootComponent.Screen.ProductSellingConditionRoute -> ProductSellingConditionScreen(instance.component)
                        is RootComponent.Screen.ProductSellingMadeInRoute -> ProductSellingMadeInScreen(instance.component)
                        is RootComponent.Screen.ProductSellingPlatformRoute -> ProductSellingPlatformScreen(instance.component)
                        is RootComponent.Screen.ProductSellingRatingRoute -> ProductSellingRatingScreen(instance.component)
                        is RootComponent.Screen.ProductSellingReleaseYearRoute -> ProductSellingReleaseYearScreen(instance.component)
                        is RootComponent.Screen.ProductSellingCustomSpecRoute -> ProductSellingCustomSpecScreen(instance.component)
                        is RootComponent.Screen.ProductSellingMPNRoute -> ProductSellingMPNScreen(instance.component)
                        is RootComponent.Screen.ProductSellingUPCRoute -> ProductSellingUPCScreen(instance.component)
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
    koinState: Stater = koinInject(),
    @Suppress("UNUSED_PARAMETER") viewModel: HomeViewModel = MokoModel { HomeViewModel(project, koinState) },
) {
    OnLaunchScreenScope {
        kotlinx.coroutines.delay(1000L)
        kotlinx.coroutines.coroutineScope {
            navigator.navigateHome(RootComponent.Configuration.HomeUserRoute)
        }
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
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
