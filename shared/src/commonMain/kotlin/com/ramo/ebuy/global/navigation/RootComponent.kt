package com.ramo.ebuy.global.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.router.stack.replaceCurrent
import kotlinx.serialization.SerialName
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
                is Configuration.LogInEmailRoute -> Screen.LogInEmailRoute(newNav, config.isRegister)
                is Configuration.HomeUserRoute -> Screen.HomeUserRoute(newNav)
                is Configuration.ProductDetailsRoute -> Screen.ProductDetailsRoute(newNav, config.productId)
                is Configuration.ProductSellingRoute -> Screen.ProductSellingRoute(newNav, config.productId, config.isAdmin)
                is Configuration.ProductSellingPriceRoute -> Screen.ProductSellingPriceRoute(newNav)
                is Configuration.ProductSellingTitleRoute -> Screen.ProductSellingTitleRoute(newNav)
                is Configuration.ProductSellingSpecRoute -> Screen.ProductSellingSpecRoute(newNav, config.isAdmin)
                is Configuration.ProductSellingCategoryRoute -> Screen.ProductSellingCategoryRoute(newNav)
                is Configuration.ProductConditionMainRoute -> Screen.ProductConditionMainRoute(newNav)
                is Configuration.ProductSellingConditionRoute -> Screen.ProductSellingConditionRoute(newNav)
                is Configuration.ProductSellingMadeInRoute -> Screen.ProductSellingMadeInRoute(newNav)
                is Configuration.ProductSellingPlatformRoute -> Screen.ProductSellingPlatformRoute(newNav)
                is Configuration.ProductSellingRatingRoute -> Screen.ProductSellingRatingRoute(newNav)
                is Configuration.ProductSellingReleaseYearRoute -> Screen.ProductSellingReleaseYearRoute(newNav)
                is Configuration.ProductSellingCustomSpecRoute -> Screen.ProductSellingCustomSpecRoute(newNav, config.index)
                is Configuration.ProductSellingMPNRoute -> Screen.ProductSellingMPNRoute(newNav)
                is Configuration.ProductSellingUPCRoute -> Screen.ProductSellingUPCRoute(newNav)
                is Configuration.ProductSellingQuantityRoute -> Screen.ProductSellingQuantityRoute(newNav)
                is Configuration.ProductSellingCustomSpecExtraRoute -> Screen.ProductSellingCustomSpecExtraRoute(newNav)
                is Configuration.ProductSellingCustomSpecExtraListRoute -> Screen.ProductSellingCustomSpecExtraListRoute(newNav, config.index)
                is Configuration.ProductShippingRoute -> Screen.ProductShippingRoute(newNav)
                is Configuration.ProductShippingCostRoute -> Screen.ProductShippingCostRoute(newNav)
                is Configuration.CategoryCreatingRoute -> Screen.CategoryCreatingRoute(newNav)
                is Configuration.AdminHomeRoute -> Screen.AdminHomeRoute(newNav)
                is Configuration.SearchProcessRoute -> Screen.SearchProcessRoute(newNav, config.searchText)
            }
        }
    }

    sealed class Screen {
        data class SplashRoute(val component: Navigator) : Screen()
        data class LogInRoute(val component: Navigator) : Screen()
        data class LogInEmailRoute(val component: Navigator, val isRegister: Boolean) : Screen()
        data class HomeUserRoute(val component: Navigator) : Screen()
        data class ProductDetailsRoute(val component: Navigator, val productId: Long) : Screen()
        data class ProductSellingRoute(val component: Navigator, val productId: Long, val isAdmin: Boolean) : Screen()
        data class ProductConditionMainRoute(val component: Navigator) : Screen()
        data class ProductSellingPriceRoute(val component: Navigator) : Screen()
        data class ProductSellingTitleRoute(val component: Navigator) : Screen()
        data class ProductSellingSpecRoute(val component: Navigator, val isAdmin: Boolean) : Screen()
        data class ProductSellingCategoryRoute(val component: Navigator) : Screen()
        data class ProductSellingConditionRoute(val component: Navigator) : Screen()
        data class ProductSellingMadeInRoute(val component: Navigator) : Screen()
        data class ProductSellingPlatformRoute(val component: Navigator) : Screen()
        data class ProductSellingRatingRoute(val component: Navigator) : Screen()
        data class ProductSellingReleaseYearRoute(val component: Navigator) : Screen()
        data class ProductSellingCustomSpecRoute(val component: Navigator, val index: Int) : Screen()
        data class ProductSellingCustomSpecExtraRoute(val component: Navigator) : Screen()
        data class ProductSellingCustomSpecExtraListRoute(val component: Navigator, val index: Int) : Screen()
        data class ProductSellingMPNRoute(val component: Navigator) : Screen()
        data class ProductSellingUPCRoute(val component: Navigator) : Screen()
        data class ProductSellingQuantityRoute(val component: Navigator) : Screen()
        data class ProductShippingRoute(val component: Navigator) : Screen()
        data class ProductShippingCostRoute(val component: Navigator) : Screen()
        data class CategoryCreatingRoute(val component: Navigator) : Screen()
        data class AdminHomeRoute(val component: Navigator) : Screen()
        data class SearchProcessRoute(val component: Navigator, val searchText: String) : Screen()
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object SplashRoute : Configuration()
        @Serializable
        data object LogInRoute : Configuration()
        @Serializable
        data class LogInEmailRoute(@SerialName("log_in") val isRegister: Boolean) : Configuration()
        @Serializable
        data object HomeUserRoute : Configuration()
        @Serializable
        data class ProductDetailsRoute(@SerialName("product_id_details") val productId: Long, @SerialName("count_screen") val countS: Int) : Configuration()
        @Serializable
        data class ProductSellingRoute(@SerialName("product_id") val productId: Long, @SerialName("is_admin") val isAdmin: Boolean) : Configuration()
        @Serializable
        data object ProductConditionMainRoute : Configuration()
        @Serializable
        data object ProductSellingPriceRoute : Configuration()
        @Serializable
        data object ProductSellingTitleRoute : Configuration()
        @Serializable
        data class ProductSellingSpecRoute(@SerialName("is_admin_spec") val isAdmin: Boolean) : Configuration()
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
        data class ProductSellingCustomSpecRoute(@SerialName("index_spec") val index: Int) : Configuration()
        @Serializable
        data object ProductSellingCustomSpecExtraRoute : Configuration()
        @Serializable
        data class ProductSellingCustomSpecExtraListRoute(@SerialName("index_spec_extra") val index: Int) : Configuration()
        @Serializable
        data object ProductSellingMPNRoute : Configuration()
        @Serializable
        data object ProductSellingUPCRoute : Configuration()
        @Serializable
        data object ProductSellingQuantityRoute : Configuration()
        @Serializable
        data object ProductShippingRoute : Configuration()
        @Serializable
        data object ProductShippingCostRoute : Configuration()
        @Serializable
        data object AdminHomeRoute : Configuration()
        @Serializable
        data object CategoryCreatingRoute : Configuration()
        @Serializable
        data class SearchProcessRoute(@SerialName("search_text") val searchText: String) : Configuration()

    }
}