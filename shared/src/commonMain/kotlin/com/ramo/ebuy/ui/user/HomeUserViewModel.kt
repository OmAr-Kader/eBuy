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

class HomeUserViewModel(
    private val project: Project
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    fun setSelectedPage(it: Int) {
        _uiState.update { state ->
            state.copy(selectedPage = it)
        }
    }

    data class State(
        val circleCato: List<Category> = cato(),
        val productVer: List<Product> = item(),
        val selectedPage: Int = 0,
    )
}