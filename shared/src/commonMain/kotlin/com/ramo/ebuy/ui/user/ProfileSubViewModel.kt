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
    private val userCartList: List<UserCart>,
    private val pastCartList: List<UserCart>.() -> List<UserCart>,
    private val watchlist: UserWatchlist?
) : BaseViewModel(project) {

    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    fun displayWatchList() {
        if (watchlist == null) {
            _uiState.update { state ->
                state.copy(isProcess = false)
            }
            return
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


    fun loadCartProducts() {
        launchBack {
            project.productData.getProductsOnIds(
                userCartList.map { it.productId }
            ).rewriteQuantity(userCartList).let {
                _uiState.update { state ->
                    state.copy(cartProducts = it, isProcess = false)
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
            userCartList.indexOfFirst {
                it.productId == item.id
            }.let { i ->
                if (i != -1) {
                    project.userCartData.editUserCart(userCartList[i].copy(quantity = new))?.also { us ->
                        userCartList.toMutableList().apply {
                            this[i] = us
                        }.let(pastCartList).also { newList ->
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

    private fun setIsProcess(it: Boolean) {
        _uiState.update { state ->
            state.copy(isProcess = it)
        }
    }


    data class State(
        val isProcess: Boolean = true,
        val productsWatchList: List<Product> = emptyList(),
        val cartProducts: List<Product> = emptyList(),
        val dummy: Int = 0,
    )

}