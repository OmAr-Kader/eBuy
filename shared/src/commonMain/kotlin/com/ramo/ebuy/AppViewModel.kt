package com.ramo.ebuy

import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.model.User
import com.ramo.ebuy.data.model.UserCart
import com.ramo.ebuy.data.model.UserWatchlist
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.navigation.BaseViewModel
import io.github.jan.supabase.gotrue.SessionStatus
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.user.UserSession
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement

class AppViewModel(
    project: Project,
) : BaseViewModel(project) {
    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    private var job: kotlinx.coroutines.Job? = null

    fun init() {
        job = launchBack {
            project.supaBase.auth.sessionStatus.onEach {
                when (val sessionStatus = it) {
                    is SessionStatus.Authenticated -> {
                        cancelSession()
                        loadUserData(sessionStatus)
                    }

                    else -> {
                        _uiState.update { state ->
                            state.copy(sessionStatus = it)
                        }
                    }
                }
            }.cancellable().collect()
        }
    }

    private fun loadUserData(sessionStatus: SessionStatus.Authenticated) {
        fetchUser(sessionStatus.session).let { user ->
            doLoadUserData(user?.id) { cartList, watchList ->
                _uiState.update { state ->
                    state.copy(sessionStatus = sessionStatus, cartList = cartList, watchlist = watchList, user = user)
                }
            }
        }
    }

    fun fetchUser(session: UserSession): User? {
        return uiState.value.user ?: session.user?.let {
            it.userMetadata?.let { it1 -> Json.decodeFromJsonElement<User>(it1) }?.copy(id = it.id)
        }
    }

    fun preLoadMainData(invoke: (catos: List<Category>, products: List<Product>) -> Unit) {
        launchBack {
            project.categoryData.getMainCategories().let { catos ->
                project.productData.getProductsOnIds(listOf(15, 17, 18)).let { products ->
                    invoke(catos, products)
                }
            }
        }
    }

    private fun doLoadUserData(userId: String?, invoke: suspend (List<UserCart>, UserWatchlist?) -> Unit) {
        launchBack {
            if (userId == null) {
                invoke(emptyList(), null)
                return@launchBack
            }
            project.userCartData.getUserCart(userId).also { userCart ->
                project.userWatchlistData.getUserWatchlist(userId).also {
                    invoke(userCart, it)
                }
            }
        }
    }

    val cartList: List<UserCart>
        get() = uiState.value.cartList

    val pasteCart: List<UserCart>.() -> List<UserCart>
        get() = {
            also {
                _uiState.update { state ->
                    state.copy(cartList = it)
                }
            }
        }

    val watchlist: UserWatchlist?
        get() = uiState.value.watchlist
    val pasteWatchlist: UserWatchlist.() -> UserWatchlist
        get() = {
            also {
                _uiState.update { state ->
                    state.copy(watchlist = it)
                }
            }
        }

    private fun cancelSession() {
        job?.cancel().apply {
            job = null
        }
    }

    data class State(
        val sessionStatus: SessionStatus = SessionStatus.LoadingFromStorage,
        val cartList: List<UserCart> = emptyList(),
        val watchlist: UserWatchlist? = null,
        val user: User? = null
    )

}