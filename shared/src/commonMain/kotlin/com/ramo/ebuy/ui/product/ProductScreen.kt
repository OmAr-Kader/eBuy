package com.ramo.ebuy.ui.product

import androidx.compose.runtime.Composable
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.navigation.MokoModel
import com.ramo.ebuy.global.navigation.Navigator
import org.koin.compose.koinInject

@Composable
fun ProductScreen(
    navigator: Navigator,
    project: Project = koinInject(),
    theme: Theme = koinInject(),
    viewModel: ProductViewModel = MokoModel { ProductViewModel(project) }
) {

}