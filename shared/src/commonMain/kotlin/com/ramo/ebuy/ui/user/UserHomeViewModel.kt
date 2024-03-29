package com.ramo.ebuy.ui.user

import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.model.User
import com.ramo.ebuy.data.model.UserSearch
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.navigation.BaseViewModel
import io.github.jan.supabase.gotrue.SessionStatus
import io.github.jan.supabase.gotrue.auth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement

class HomeViewModel(
    project: Project,
    state: StateHomeViewModel,
    private val paste: StateHomeViewModel.() -> StateHomeViewModel
) : BaseViewModel(project) {

    private val _uiState = MutableStateFlow(state)
    val uiState = _uiState.asStateFlow()

    inline val repeatableCategory: Int
        get() {
            val state = uiState.value
            return if (state.repeatableCato == 0) {
                0
            } else {
                state.circleCato.size / state.repeatableCato
            }
        }


    val onSearch: (String) -> Unit
        get() = {
            _uiState.update { state ->
                state.copy(search = it).paste()
            }
        }

    fun initHome() {
        launchBack {
            doLoadMainData { catos, products ->
                doLoadUserData { user ->
                    doLoadSearchHistory(user.id) { userSearchList, userSearchSavedList ->
                        _uiState.update { state ->
                            state.copy(
                                circleCato = catos,
                                productVer = products,
                                user = user,
                                userSearchList = userSearchList,
                                userSearchSavedList = userSearchSavedList,
                                isProcess = false,
                            ).paste()
                        }
                    }
                }
            }
        }
    }

    fun loadMainData() {
        uiState.value.apply {
            if (isProcess || (circleCato.isNotEmpty() && productVer.isNotEmpty())) {
                return
            }
        }
        setIsProcess(true)
        launchBack {
            doLoadMainData { catos, products ->
                _uiState.update { state ->
                    state.copy(circleCato = catos, productVer = products, isProcess = false).paste()
                }
            }
        }
    }

    private suspend fun doLoadMainData(invoke: suspend (List<Category>, List<Product>) -> Unit) {
        uiState.value.apply {
            if (circleCato.isNotEmpty() && productVer.isNotEmpty()) {
                invoke(circleCato, productVer)
                return
            }
        }
        project.categoryData.getMainCategories().let { catos ->
            project.productData.getProductsOnIds(listOf(15, 17, 18)).let { products ->
                invoke(catos, products)
            }
        }
    }

    private suspend fun doLoadUserData(invoke: suspend (User) -> Unit) {
        userInfo()?.also {
            invoke(it)
        }
    }

    fun loadSearchHistory(invoke: () -> Unit) {
        launchBack {
            userInfo()?.also { user ->
                doLoadSearchHistory(user.id) { userSearchList, userSearchSavedList ->
                    _uiState.update { state ->
                        state.copy(
                            userSearchList = userSearchList,
                            userSearchSavedList = userSearchSavedList,
                            isSearchNeedRefresh = false,
                            isProcess = false,
                        ).paste().apply {
                            invoke()
                        }
                    }
                }
            }
        }
    }

    private suspend fun doLoadSearchHistory(userId: String, invoke: suspend (List<UserSearch>, List<UserSearch>) -> Unit) {
        project.userSearchData.getUserSearches(userId).toMutableList().also { searchList ->
            invoke(
                searchList.toMutableList().filter { it.typeSearch == 0 },
                searchList.toMutableList().filter { it.typeSearch == 1 },
            )
        }
    }

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
                    }

                    else -> {}
                }
            }.launchIn(this)
        }
    }

    private fun setUser(us: User?) {
        _uiState.update { state ->
            state.copy(user = us, isProcess = false).paste()
        }
    }

    fun setSelectedPage(it: Int) {
        _uiState.update { state ->
            state.copy(selectedPage = it).paste()
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

    fun makeIsSearchNeedRefresh() {
        _uiState.update { state ->
            state.copy(isSearchNeedRefresh = true).paste()
        }
    }

    fun setIsProcess(it: Boolean) {
        _uiState.update { state ->
            state.copy(isProcess = it)
        }
    }

}

data class StateHomeViewModel(
    val isProcess: Boolean = false,
    val circleCato: List<Category> = listOf(),
    val productVer: List<Product> = listOf(),
    val userSearchList: List<UserSearch> = listOf(),
    val userSearchSavedList: List<UserSearch> = listOf(),
    val isSearchNeedRefresh: Boolean = false,
    val user: User? = null,
    val search: String = "",
    val selectedPage: Int = 0,
    val repeatableCato: Int = 0,
)
