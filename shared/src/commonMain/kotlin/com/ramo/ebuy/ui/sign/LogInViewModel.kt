package com.ramo.ebuy.ui.sign

import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.navigation.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LogInViewModel(
    private val project: Project
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    fun setEmail(it: String) {
        _uiState.update { state ->
            state.copy(email = it)
        }
    }

    fun setPassword(it: String) {
        _uiState.update { state ->
            state.copy(password = it)
        }
    }

    data class State(
        val isErrorPressed: Boolean = false,
        val email: String = "",
        val password: String = "",
    )

}