package com.ramo.ebuy.ui.user

import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.di.Stater
import com.ramo.ebuy.global.navigation.BaseViewModel
import com.ramo.ebuy.global.util.cato
import com.ramo.ebuy.global.util.item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel(project: Project, private val stater: Stater) : BaseViewModel(project) {

    private val _uiState = MutableStateFlow(stater.stateHomeModel.copy())
    val uiState = _uiState.asStateFlow()

    fun loadUserData() {
        fetchUserData {
            _uiState.update { state ->
                state.copy(userBase = it).apply { stater.stateHomeModel.paste(userBase = it) }
            }
        }
    }

    fun setSelectedPage(it: Int) {
        _uiState.update { state ->
            state.copy(selectedPage = it).apply { stater.stateHomeModel.paste(selectedPage = it) }
        }
    }

    inline val repeatableCategory: Int
        get() {
            val state = uiState.value
            return if (state.repeatableCato == 0) {
                0
            } else {
                state.circleCato.size / state.repeatableCato
            }
        }

    fun setRepeatableCato(width: Int) {
        if (uiState.value.repeatableCato == width / 220) {
            return
        }
        _uiState.update { state ->
            state.copy(repeatableCato = width / 220)
        }
    }

}

data class StateHomeViewModel(
    var circleCato: List<Category> = cato(),
    var productVer: List<Product> = item(),
    var userBase: BaseViewModel.UserBase? = null,
    var selectedPage: Int = 0,
    var repeatableCato: Int = 0,
) {
    fun paste(
        circleCato: List<Category>? = null,
        productVer: List<Product>? = null,
        userBase: BaseViewModel.UserBase? = null,
        selectedPage: Int? = null,
        repeatableCato: Int? = null
    ) {
        this@StateHomeViewModel.circleCato = circleCato ?: this@StateHomeViewModel.circleCato
        this@StateHomeViewModel.productVer = productVer ?: this@StateHomeViewModel.productVer
        this@StateHomeViewModel.userBase = userBase ?: this@StateHomeViewModel.userBase
        this@StateHomeViewModel.selectedPage = selectedPage ?: this@StateHomeViewModel.selectedPage
        this@StateHomeViewModel.repeatableCato = repeatableCato ?: this@StateHomeViewModel.repeatableCato
    }
}