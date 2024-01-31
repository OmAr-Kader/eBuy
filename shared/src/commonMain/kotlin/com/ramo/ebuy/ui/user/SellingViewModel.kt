package com.ramo.ebuy.ui.user

import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.navigation.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SellingViewModel(project: Project) : BaseViewModel(project) {

    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    data class State(
        val isErrorPressed: Boolean = false,
    )

}