package com.ramo.ebuy.ui.product

import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.navigation.BaseViewModel
import com.ramo.ebuy.global.util.item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDetailsViewModel(project: Project) : BaseViewModel(project) {

    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    data class State(
        val circleCato: Product = Product(),
        val productVer: List<Product> = item(),
        val userBase: UserBase? = null,
        val selectedPage: Int = 0,
    )
}