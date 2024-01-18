package com.ramo.ebuy.ui.user

import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.navigation.BaseViewModel
import com.ramo.ebuy.global.util.HotBarData
import com.ramo.ebuy.global.util.cato
import com.ramo.ebuy.global.util.item
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeUserViewModel(project: Project) : BaseViewModel(project) {

    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    fun loadUserData() {
        fetchUserData {
            _uiState.update { state ->
                state.copy(userBase = it)
            }
        }
    }

    fun setSelectedPage(it: Int) {
        _uiState.update { state ->
            state.copy(selectedPage = it)
        }
    }

    data class State(
        val circleCato: List<Category> = cato(),
        val productVer: List<Product> = item(),
        val userBase: UserBase? = null,
        val selectedPage: Int = 0,
    )
}