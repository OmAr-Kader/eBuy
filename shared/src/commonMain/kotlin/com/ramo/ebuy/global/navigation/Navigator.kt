package com.ramo.ebuy.global.navigation

import com.arkivanov.decompose.ComponentContext

class Navigator(
    componentContext: ComponentContext,
    private val onNavigateToScreen: (RootComponent.Configuration) -> Unit,
    private val onDisplayScreen:  (RootComponent.Configuration) -> Unit,
    private val onGoBack: () -> Unit

): ComponentContext by componentContext {

    /*private var _text = MutableValue("")
    val text: Value<String> = _text
    _text.value = event.text*/

    fun navigateHome(route: RootComponent.Configuration) {
        onDisplayScreen(route)
    }

    fun navigateTo(route: RootComponent.Configuration) {
        onNavigateToScreen(route)
    }

    fun goBack() {
        onGoBack()
    }
}