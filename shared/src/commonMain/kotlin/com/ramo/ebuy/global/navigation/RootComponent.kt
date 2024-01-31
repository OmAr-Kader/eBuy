package com.ramo.ebuy.global.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.router.stack.replaceCurrent
import kotlinx.serialization.Serializable

class RootComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    private val navigation = StackNavigation<Configuration>()
    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.SplashRoute,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Screen {
        return Navigator(
            componentContext = context,
            onNavigateToScreen = { route ->
                navigation.pushNew(route)
            },
            onDisplayScreen = { route ->
                navigation.replaceAll(route)
            },
            onReplaceScreen = { route ->
                navigation.replaceCurrent(route)
            },
            onGoBack = {
                navigation.pop()
            }
        ).let { newNav ->
            return@let when (config) {
                is Configuration.SplashRoute -> Screen.SplashRoute(newNav)
                is Configuration.LogInRoute -> Screen.LogInRoute(newNav)
                is Configuration.LogInEmailRoute -> Screen.LogInEmailRoute(newNav)
                is Configuration.HomeUserRoute -> Screen.HomeUserRoute(newNav)
                is Configuration.ProductDetailsRoute -> Screen.ProductDetailsRoute(newNav)
                is Configuration.ProductSellingRoute -> Screen.ProductSellingRoute(newNav)
                is Configuration.ProductSellingPriceRoute -> Screen.ProductSellingPriceRoute(newNav)
                is Configuration.ProductSellingTitleRoute -> Screen.ProductSellingTitleRoute(newNav)
                is Configuration.ProductSellingSpecRoute -> Screen.ProductSellingSpecRoute(newNav)
                is Configuration.ProductSellingCategoryRoute -> Screen.ProductSellingCategoryRoute(newNav)
                is Configuration.ProductConditionMainRoute -> Screen.ProductConditionMainRoute(newNav)
                is Configuration.ProductSellingConditionRoute -> Screen.ProductSellingConditionRoute(newNav)
                is Configuration.ProductSellingMadeInRoute -> Screen.ProductSellingMadeInRoute(newNav)
                is Configuration.ProductSellingPlatformRoute -> Screen.ProductSellingPlatformRoute(newNav)
                is Configuration.ProductSellingRatingRoute -> Screen.ProductSellingRatingRoute(newNav)
                is Configuration.ProductSellingReleaseYearRoute -> Screen.ProductSellingReleaseYearRoute(newNav)
                is Configuration.ProductSellingCustomSpecRoute -> Screen.ProductSellingCustomSpecRoute(newNav)
                is Configuration.ProductSellingMPNRoute -> Screen.ProductSellingMPNRoute(newNav)
                is Configuration.ProductSellingUPCRoute -> Screen.ProductSellingUPCRoute(newNav)
            }
        }
    }

    sealed class Screen {
        data class SplashRoute(val component: Navigator) : Screen()
        data class LogInRoute(val component: Navigator) : Screen()
        data class LogInEmailRoute(val component: Navigator) : Screen()
        data class HomeUserRoute(val component: Navigator) : Screen()
        data class ProductDetailsRoute(val component: Navigator) : Screen()
        data class ProductSellingRoute(val component: Navigator) : Screen()
        data class ProductConditionMainRoute(val component: Navigator) : Screen()
        data class ProductSellingPriceRoute(val component: Navigator) : Screen()
        data class ProductSellingTitleRoute(val component: Navigator) : Screen()
        data class ProductSellingSpecRoute(val component: Navigator) : Screen()
        data class ProductSellingCategoryRoute(val component: Navigator) : Screen()
        data class ProductSellingConditionRoute(val component: Navigator) : Screen()
        data class ProductSellingMadeInRoute(val component: Navigator) : Screen()
        data class ProductSellingPlatformRoute(val component: Navigator) : Screen()
        data class ProductSellingRatingRoute(val component: Navigator) : Screen()
        data class ProductSellingReleaseYearRoute(val component: Navigator) : Screen()
        data class ProductSellingCustomSpecRoute(val component: Navigator) : Screen()
        data class ProductSellingMPNRoute(val component: Navigator) : Screen()
        data class ProductSellingUPCRoute(val component: Navigator) : Screen()
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object SplashRoute : Configuration()
        @Serializable
        data object LogInRoute : Configuration()
        @Serializable
        data object LogInEmailRoute : Configuration()
        @Serializable
        data object HomeUserRoute : Configuration()
        @Serializable
        data object ProductDetailsRoute : Configuration()
        @Serializable
        data object ProductSellingRoute : Configuration()
        @Serializable
        data object ProductConditionMainRoute : Configuration()
        @Serializable
        data object ProductSellingPriceRoute : Configuration()
        @Serializable
        data object ProductSellingTitleRoute : Configuration()
        @Serializable
        data object ProductSellingSpecRoute : Configuration()
        @Serializable
        data object ProductSellingCategoryRoute : Configuration()
        @Serializable
        data object ProductSellingConditionRoute : Configuration()
        @Serializable
        data object ProductSellingMadeInRoute : Configuration()
        @Serializable
        data object ProductSellingPlatformRoute : Configuration()
        @Serializable
        data object ProductSellingRatingRoute : Configuration()
        @Serializable
        data object ProductSellingReleaseYearRoute : Configuration()
        @Serializable
        data object ProductSellingCustomSpecRoute : Configuration()
        @Serializable
        data object ProductSellingMPNRoute : Configuration()
        @Serializable
        data object ProductSellingUPCRoute : Configuration()

    }
}