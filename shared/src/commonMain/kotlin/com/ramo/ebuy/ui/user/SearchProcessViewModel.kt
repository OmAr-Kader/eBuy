package com.ramo.ebuy.ui.user

import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.model.UserSearch
import com.ramo.ebuy.data.model.UserWatchlist
import com.ramo.ebuy.data.util.refreshFavorites
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.navigation.BaseViewModel
import com.ramo.ebuy.global.util.currentMillis
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SearchProcessViewModel(
    project: Project,
    private val watchlist: UserWatchlist?,
    private val pasteWatchlist: UserWatchlist.() -> UserWatchlist,
) : BaseViewModel(project) {
    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    fun loadData(text: String, typeSearch: Int) {
        launchBack {
            userInfo()?.id.also { userId ->
                project.productData.getProductsOnSearch(text).let { products ->
                    products.toMutableList().apply {
                        watchlist?.let { refreshFavorites(it) }
                    }.also { productsList ->
                        _uiState.update { state ->
                            state.copy(
                                products = productsList,
                                userId = userId,
                                isProcess = false
                            )
                        }
                        userId?.let { updateSearchData(typeSearch = typeSearch, userId = it, searchText = text) }
                    }
                }
            }
        }
    }

    private fun updateSearchData(typeSearch: Int, userId: String, searchText: String) {
        launchBack {
            project.userSearchData.addEditUserSearch(
                UserSearch(
                    typeSearch = typeSearch,
                    lastUse = currentMillis,
                    idUserSearch = "$userId|*|$searchText",
                    userId = userId,
                    search = searchText,
                )
            )
        }
    }

    fun changeWatchList(isWatchlist: Boolean, id: Long) {
        watchlist?.also { userWatchList ->
            editChangeList(userWatchList, isWatchlist, id) { newWatchList ->
                launchBack {
                    project.userWatchlistData.editUserWatchlist(newWatchList)
                }
            }
        } ?: uiState.value.userId?.also { userId ->
            setIsProcess(true)
            launchBack {
                project.userWatchlistData.addNewUserWatchlist(
                    UserWatchlist(userId = userId, watchlist = arrayOf(id))
                )?.also { newWatchList ->
                    uiState.value.products.toMutableList().apply {
                        refreshFavorites(newWatchList)
                    }.also { newProducts ->
                        pasteWatchlist(newWatchList).also {
                            _uiState.update { state ->
                                state.copy(products = newProducts, isProcess = false, dummy = state.dummy + 1)
                            }
                        }
                    }
                } ?: setIsProcess(false)
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
                uiState.value.products.toMutableList().apply {
                    refreshFavorites(newWatchList)
                }.also { newProducts ->
                    pasteWatchlist(newWatchList).also {
                        _uiState.update { state ->
                            state.copy(products = newProducts, dummy = state.dummy + 1)
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
        val isProcess: Boolean = true,
        val products: List<Product> = emptyList(),
        val userId: String? = null,
        val dummy: Int = 0,
    )
}
