package com.ramo.ebuy

import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.model.User
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.di.Stater
import com.ramo.ebuy.global.navigation.BaseViewModel
import io.github.jan.supabase.gotrue.SessionStatus
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.user.UserSession
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement

class AppViewModel(
    project: Project,
    private val stater: Stater,
) : BaseViewModel(project) {
    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    private var job: kotlinx.coroutines.Job? = null

    fun init() {
        job = launchBack {
            project.supaBase.auth.sessionStatus.onEach {
                _uiState.update { state ->
                    state.copy(sessionStatus = it)
                }
            }.cancellable().collect {

            }
        }
    }

    fun cancelSession() {
        job?.cancel().apply {
            job = null
        }
    }

    fun fetchUser(session: UserSession): User? {
        return session.user?.let {
            it.userMetadata?.let { it1 -> Json.decodeFromJsonElement<User>(it1) }?.copy(id = it.id)
        }
    }

    fun preLoadMainData(invoke: (catos: List<Category>, products: List<Product>) -> Unit) {
        launchBack {
            project.categoryData.getMainCategories().let { catos ->
                project.productData.getProductsOnIds(listOf(17, 16)).let { products ->
                    invoke(catos, products)
                }
            }
        }
    }

    override fun onCleared() {
        stater.onCleared()
        super.onCleared()
    }

    data class State(
        val sessionStatus: SessionStatus = SessionStatus.LoadingFromStorage,
    )

}