package com.ramo.ebuy.ui.user

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.ramo.ebuy.AppViewModel
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.di.Stater
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.navigation.MokoModel
import com.ramo.ebuy.global.navigation.Navigator
import com.ramo.ebuy.global.ui.AddItem
import com.ramo.ebuy.global.ui.LoadingScreen
import com.ramo.ebuy.global.ui.OnLaunchScreen
import com.ramo.ebuy.global.util.bottomBarData
import org.koin.compose.koinInject

@Composable
fun HomeUserScreen(
    navigator: Navigator,
    appViewModel: AppViewModel,
    project: Project = koinInject(),
    theme: Theme = koinInject(),
    stater: Stater = koinInject(),
    viewModel: HomeViewModel = MokoModel {
        HomeViewModel(project, stater.stateHomeModel.copy()) {
            apply {
                stater.stateHomeViewModel = this@apply
            }
        }
    }
) {
    val state by viewModel.uiState.collectAsState()
    val stateApp by appViewModel.uiState.collectAsState()
    val scaffoldState = remember { SnackbarHostState() }
    OnLaunchScreen {
        viewModel.initHome()
    }
    Scaffold(
        snackbarHost = {
            SnackbarHost(scaffoldState) {
                Snackbar(it, containerColor = theme.backDarkSec, contentColor = theme.textColor)
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = theme.backDark,
                contentColor = theme.textGrayColor
            ) {
                bottomBarData.forEachIndexed { i, item ->
                    AddItem(
                        screen = item,
                        i,
                        state.selectedPage == i,
                    ) {
                        viewModel.setSelectedPage(it)
                    }
                }
            }
        }
    ) {
        Box(Modifier.padding(it)) {
            when (state.selectedPage) {
                0 -> HomeSubScreen(navigator, viewModel, stateApp.cartList.size)
                1 -> ProfileSubScreen(navigator, viewModel, stateApp.cartList.size)
                2 -> SearchSubScreen(navigator, viewModel)
                4 -> SellingSubScreen(navigator, viewModel)
            }
        }
        LoadingScreen(state.isProcess, theme)
    }
}

