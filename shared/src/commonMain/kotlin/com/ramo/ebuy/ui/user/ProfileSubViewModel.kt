package com.ramo.ebuy.ui.user

import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.model.UserCart
import com.ramo.ebuy.data.model.UserWatchlist
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.navigation.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileSubViewModel(
    project: Project,
) : BaseViewModel(project) {

    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    fun displayWatchList() {
        loadWatchlist { watchlist, _ ->
            if (watchlist == null) {
                _uiState.update { state ->
                    state.copy(isProcess = false)
                }
                return@loadWatchlist
            }
            launchBack {
                project.productData.getProductsOnIds(watchlist.watchlist.toList()).also { productsWatchlist ->
                    _uiState.update { state ->
                        state.copy(
                            productsWatchList = productsWatchlist,
                            isProcess = false
                        )
                    }
                }
            }
        }
    }

    private fun loadWatchlist(invoke: (UserWatchlist?, String?) -> Unit) {
        launchBack {
            userInfo().apply {
                if (this == null) {
                    invoke(null, null)
                    return@launchBack
                }
                project.userWatchlistData.getUserWatchlist(this@apply.id).also {
                    invoke(it, id)
                }
            }
        }
    }


    fun loadCartProducts() {
        loadUserCart { userCart ->
            project.productData.getProductsOnIds(
                userCart.map { it.productId }
            ).rewriteQuantity(userCart).let {
                _uiState.update { state ->
                    state.copy(userCartList = userCart, cartProducts = it)
                }
            }
        }
    }

    private fun List<Product>.rewriteQuantity(userCartList: List<UserCart>): List<Product> {
        return onEach { product ->
            product.cartQuantity = userCartList.find { cart -> cart.productId == product.id }?.quantity ?: 0
        }
    }

    fun cartQuantityChanged(item: Product, new: Int) {
        setIsProcess(true)
        launchBack {
            uiState.value.userCartList.indexOfFirst {
                it.productId == item.id
            }.let { i ->
                if (i != -1) {
                    project.userCartData.editUserCart(uiState.value.userCartList[i].copy(quantity = new))?.also { us ->
                        uiState.value.userCartList.toMutableList().apply {
                            this[i] = us
                        }.also { newList ->
                            uiState.value.cartProducts.rewriteQuantity(newList).also { newProducts ->
                                _uiState.update { state ->
                                    state.copy(cartProducts = newProducts, isProcess = false, dummy = state.dummy + 1)
                                }
                            }
                        }
                    } ?: setIsProcess(false)
                } else {
                    setIsProcess(false)
                }
            }
        }
    }

    private fun loadUserCart(invoke: suspend (List<UserCart>) -> Unit) {
        launchBack {
            userInfo()?.apply {
                project.userCartData.getUserCart(this@apply.id).also {
                    invoke(it)
                }
            }
        }
    }

    private fun setIsProcess(it: Boolean) {
        _uiState.update { state ->
            state.copy(isProcess = it)
        }
    }


    data class State(
        val isProcess: Boolean = true,
        val productsWatchList: List<Product> = emptyList(),
        val userCartList: List<UserCart> = emptyList(),
        val cartProducts: List<Product> = emptyList(),
        val dummy: Int = 0,
    )

}