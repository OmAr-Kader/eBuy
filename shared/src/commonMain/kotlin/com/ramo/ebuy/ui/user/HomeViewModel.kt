package com.ramo.ebuy.ui.user

import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.model.User
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.navigation.BaseViewModel
import com.ramo.ebuy.global.util.item
import io.github.jan.supabase.gotrue.SessionStatus
import io.github.jan.supabase.gotrue.auth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement

class HomeViewModel(project: Project, state: StateHomeViewModel, private val paste: StateHomeViewModel.() -> StateHomeViewModel) : BaseViewModel(project) {

    private val _uiState = MutableStateFlow(state)
    val uiState = _uiState.asStateFlow()

    fun loadUserData() {
        if (uiState.value.user != null) {
            return
        }
        project.supaBase.auth.currentSessionOrNull()?.user?.let { user ->
            return@let user.userMetadata?.also {
                setUser(Json.decodeFromJsonElement<User?>(it)?.copy(id = user.id))
            }
        } ?: run {
            project.supaBase.auth.sessionStatus.onEach { session ->
                when (session) {
                    is SessionStatus.Authenticated -> {
                        session.session.user?.let { user ->
                            user.userMetadata?.also {
                                setUser(Json.decodeFromJsonElement<User?>(it)?.copy(id = user.id))
                            }
                        }
                    } else -> {}
                }
            }.launchIn(this)
        }
    }

    private fun setUser(us: User?) {
        _uiState.update { state ->
            state.copy(user = us).paste()
        }
    }

    fun setSelectedPage(it: Int) {
        _uiState.update { state ->
            state.copy(selectedPage = it).paste()
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

    fun loadCategories() {
        launchBack {
            project.categoryData.getMainCategories().let {
                _uiState.update { state ->
                    state.copy(circleCato = it).paste()
                }
            }
        }
    }

    fun setRepeatableCato(width: Int) {
        if (uiState.value.repeatableCato == width / 220) {
            return
        }
        _uiState.update { state ->
            state.copy(repeatableCato = width / 220).paste()
        }
    }

}

data class StateHomeViewModel(
    val circleCato: List<Category> = listOf(),
    val productVer: List<Product> = item(),
    val user: User? = null,
    val selectedPage: Int = 0,
    val repeatableCato: Int = 0,
)
