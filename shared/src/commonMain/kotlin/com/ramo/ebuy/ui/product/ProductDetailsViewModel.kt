package com.ramo.ebuy.ui.product

import com.ramo.ebuy.data.model.DeliveryProcess
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.model.ProductBaseSpecs
import com.ramo.ebuy.data.model.ProductQuantity
import com.ramo.ebuy.data.model.User
import com.ramo.ebuy.data.model.UserCart
import com.ramo.ebuy.data.model.UserWatchlist
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.navigation.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProductDetailsViewModel(
    private val watchlist: UserWatchlist?,
    private val pasteWatchlist: UserWatchlist.() -> UserWatchlist,
    private val userCartList: List<UserCart>,
    private val pastCartList: List<UserCart>.() -> List<UserCart>,
    project: Project
) : BaseViewModel(project) {

    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    fun loadProDetails(productId: Long) {
        if (productId == -1L) {
            setIsProcess(false)
            return
        }
        setIsProcess(true)
        launchBack {
            project.productData.getProductOnIdForeign(productId) { product, productSpecs, productQuantity, delivery ->
                if (product == null || productSpecs == null) {
                    setIsProcess(false)
                    return@getProductOnIdForeign
                }
                userCartList.toMutableList().find {
                    it.productId == productId
                }.also { usProductCart ->
                    product.copy(isWatchlist = watchlist?.watchlist?.find { product.id == it } != null).also { pro ->
                        _uiState.update { state ->
                            state.copy(
                                product = pro,
                                productSpecs = productSpecs,
                                productQuantity = productQuantity ?: ProductQuantity(),
                                deliveryProcess = delivery ?: DeliveryProcess(),
                                userCart = usProductCart,
                                isProcess = false
                            )
                        }
                    }
                }
            }
        }
    }

    fun setDroppedIndex(it: Int) {
        _uiState.update { state ->
            state.copy(droppedIndex = it)
        }
    }

    fun setModelBottom(it: Boolean) {
        _uiState.update { state ->
            state.copy(isModalBottom = it)
        }
    }

    fun setSpecChosen(index: Int, userSpecIndex: Int) {
        _uiState.update { state ->
            state.specChosen.toMutableList().apply {
                if (userSpecIndex == -1) {
                    find { it.index == index }?.let { it1 -> remove(it1) }
                } else {
                    add(SpecChosen(index, userSpecIndex))
                }
            }.let {
                state.copy(specChosen = it, droppedIndex = -1)
            }
        }
    }

    fun addToCart() {
        if (uiState.value.product.id == 0L) {
            return
        }
        setIsProcess(true)
        launchBack {
            userInfo()?.also {
                uiState.value.also { state ->
                    project.userCartData.addNewUserCart(
                        UserCart(userId = it.id, productId = state.product.id, quantity = 1)
                    )?.also { addedCart ->
                        pastCartList(userCartList.toMutableList().apply { add(addedCart) }).also {
                            _uiState.update { newState ->
                                newState.copy(userCart = addedCart, isProcess = false)
                            }
                        }
                    } ?: setIsProcess(false)
                }
            }
        }
    }

    fun changeWatchList(isWatchlist: Boolean, id: Long) {
        watchlist?.also { userWatchList ->
            editChangeList(userWatchList, isWatchlist, id) { newWatchList ->
                launchBack {
                    project.userWatchlistData.editUserWatchlist(newWatchList)
                }
            }
        } ?: run<Unit> {
            launchBack {
                userInfo()?.id?.also { userId ->
                    setIsProcess(true)
                    launchBack {
                        project.userWatchlistData.addNewUserWatchlist(
                            UserWatchlist(userId = userId, watchlist = arrayOf(id))
                        )?.also { newWatchList ->
                            uiState.value.product.apply {
                                this@apply.isWatchlist = true
                            }.also { newProduct ->
                                pasteWatchlist(newWatchList).also {
                                    _uiState.update { state ->
                                        state.copy(product = newProduct, isProcess = false, dummy = state.dummy + 1)
                                    }
                                }
                            }
                        } ?: setIsProcess(false)
                    }
                }
            }
        }
    }

    private fun editChangeList(userWatchList: UserWatchlist, isWatchlist: Boolean, id: Long, invoke: (UserWatchlist) -> Unit) {
        launchBack {
            userWatchList.watchlist.toMutableList().apply {
                if (isWatchlist) {
                    this@apply.remove(id)
                } else {
                    this@apply.add(id)
                }
            }.toTypedArray().let { userWatchList.copy(watchlist = it) }.also { newWatchList ->
                uiState.value.product.apply {
                    this@apply.isWatchlist = true
                }.also { newProduct ->
                    pasteWatchlist(newWatchList).also {
                        _uiState.update { state ->
                            state.copy(product = newProduct, dummy = state.dummy + 1)
                        }
                    }
                }
                invoke(newWatchList)
            }
        }
    }

    private fun setIsProcess(it: Boolean) {
        _uiState.update { state ->
            state.copy(isProcess = it)
        }
    }

    data class State(
        val product: Product = Product(),
        val productSpecs: ProductBaseSpecs = ProductBaseSpecs(),
        val productQuantity: ProductQuantity = ProductQuantity(),
        val deliveryProcess: DeliveryProcess = DeliveryProcess(),
        val userCart: UserCart? = null,
        val specChosen: List<SpecChosen> = listOf(),
        val productVer: List<Product> = listOf(),
        val droppedIndex: Int = -1,
        val user: User? = null,
        val isModalBottom: Boolean = false,
        val isProcess: Boolean = true,
        val dummy: Int = 0,
    )

    data class SpecChosen(
        val index: Int,
        val userSpecIndex: Int,
    )
}
