package com.ramo.ebuy.global.navigation

class Navigator(
    componentContext: com.arkivanov.decompose.ComponentContext,
    private val onNavigateToScreen: suspend (RootComponent.Configuration) -> Unit,
    private val onDisplayScreen: suspend (RootComponent.Configuration) -> Unit,
    private val onReplaceScreen: suspend (RootComponent.Configuration) -> Unit,
    private val onGoBack: suspend () -> Unit
) : com.arkivanov.decompose.ComponentContext by componentContext {
    suspend fun navigateTo(route: RootComponent.Configuration) {
        onNavigateToScreen(route)
    }
    suspend fun navigateHome(route: RootComponent.Configuration) {
        onDisplayScreen(route)
    }
    suspend fun navigateToReplace(route: RootComponent.Configuration) {
        onReplaceScreen(route)
    }

    suspend fun goBack() {
        onGoBack()
    }
}