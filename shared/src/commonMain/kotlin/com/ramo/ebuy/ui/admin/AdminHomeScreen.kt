package com.ramo.ebuy.ui.admin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.ramo.ebuy.di.Stater
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.navigation.Navigator
import com.ramo.ebuy.global.navigation.RootComponent
import com.ramo.ebuy.global.ui.FabItem
import com.ramo.ebuy.global.ui.MultiFloatingActionButton
import com.ramo.ebuy.ui.product.StateProductSelling
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun AdminHomeScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    stater: Stater = koinInject()
) {
    val scope = rememberCoroutineScope()
    Scaffold(
        floatingActionButton = {
            MultiFloatingActionButton(
                items = remember {
                    listOf(FabItem(Icons.Default.Add, "Category", theme.secondary), FabItem(Icons.Default.Add, "Reference Product", theme.primary))
                },
                theme = theme,
            ) {
                if (it == 0) {
                    scope.launch {
                        navigator.navigateTo(RootComponent.Configuration.CategoryCreatingRoute)
                    }
                } else {
                    scope.launch {
                        stater.stateProductSelling = StateProductSelling()
                        navigator.navigateTo(RootComponent.Configuration.ProductSellingRoute(-1, true))
                    }
                }
            }
        },
    ) {
        Box(Modifier.padding(it)) {

        }
    }
}