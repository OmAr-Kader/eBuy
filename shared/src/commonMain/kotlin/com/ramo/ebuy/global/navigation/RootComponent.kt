package com.ramo.ebuy.global.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceAll
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

    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Screen {
        val newNav = Navigator(
            componentContext = context,
            onNavigateToScreen = { route ->
                navigation.pushNew(route)
            },
            onDisplayScreen = { route ->
                navigation.replaceAll(route)
            },
            onGoBack = {
                navigation.pop()
            }
        )
        return when (config) {
            is Configuration.SplashRoute -> Screen.SplashRoute(newNav)
            is Configuration.LogInRoute -> Screen.LogInRoute(newNav)
            is Configuration.LogInEmailRoute -> Screen.LogInEmailRoute(newNav)
            is Configuration.HomeUserRoute -> Screen.HomeUserRoute(newNav)
        }
    }

    sealed class Screen {
        data class SplashRoute(val component: Navigator) : Screen()
        data class LogInRoute(val component: Navigator) : Screen()
        data class LogInEmailRoute(val component: Navigator) : Screen()
        data class HomeUserRoute(val component: Navigator) : Screen()
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
    }
}