package com.ramo.ebuy.ui.product

import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.data.model.DeliveryProcess
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.model.ProductBaseSpecs
import com.ramo.ebuy.data.model.ProductSpecs
import com.ramo.ebuy.data.model.ProductSpecsExtra
import com.ramo.ebuy.data.model.User
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.navigation.BaseViewModel
import com.ramo.ebuy.global.util.Country
import com.ramo.ebuy.global.util.countries
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProductSellingViewModel(
    project: Project,
    state: StateProductSelling,
    private val paste: StateProductSelling.() -> StateProductSelling
) : BaseViewModel(project) {
    private val _uiState = MutableStateFlow(state)
    val uiState = _uiState.asStateFlow()
    fun loadProduct(productId: Long) {
        if (productId == -1L) {
            setIsProcess(false)
            return
        }
        setIsProcess(true)
        launchBack {
            project.productData.getProductOnId(productId)?.let { product ->
                project.productSpecsData.getProductSpecsOnId(productId)?.let { productSpecs ->
                    project.deliveryData.getDeliveryOnId(productId)?.let { delivery ->
                        _uiState.update { state ->
                            state.copy(product = product, productSpecs = productSpecs, deliveryProcess = delivery, isProcess = false).paste()
                        }
                    }
                } ?: setIsProcess(false)
            }
        }
    }

    fun loadCategories() {
        launchBack {
            project.categoryData.getCategories().let { listCategory ->
                _uiState.update { state ->
                    state.copy(listCategory = listCategory, isProcess = false)
                }
            }
        }
    }

    fun setConditionMain(it: String) {
        _uiState.update { state ->
            state.copy(product = state.product.copy(condition = it)).paste()
        }
    }

    fun setCondition(it: String) {
        _uiState.update { state ->
            state.copy(product = state.product.copy(condition = it)).paste()
        }
    }

    fun setReleaseYear(it: Long) {
        _uiState.update { state ->
            state.copy(productSpecs = state.productSpecs.copy(releaseYear = it)).paste()
        }
    }

    fun setMadeIn(it: Int) {
        _uiState.update { state ->
            state.copy(productSpecs = state.productSpecs.copy(countryProduct = it)).paste()
        }
    }

    fun setAgeRate(it: Int) {
        _uiState.update { state ->
            state.copy(product = state.product.copy(ageRate = it)).paste()
        }
    }

    fun setCustomSpecIndex(it: Int) {
        _uiState.update { state ->
            state.copy(customSpecIndex = it).paste()
        }
    }

    fun setCustomSpecExtraIndex(it: Int) {
        _uiState.update { state ->
            state.copy(customSpecExtraIndex = it).paste()
        }
    }

    fun addOrEditCustomSpec(it: ProductSpecs) {
        _uiState.update { state ->
            state.productSpecs.specs.toMutableList().apply {
                if (state.customSpecIndex == -1) {
                    this@apply.add(it)
                } else {
                    runCatching {
                        this@apply[state.customSpecIndex] = it
                    }
                }
            }.let { newList ->
                state.copy(productSpecs = state.productSpecs.copy(specs = newList)).paste()
            }
        }
    }

    fun setDeleteCustomSpec(it: Int) {
        _uiState.update { state ->
            state.productSpecs.specs.toMutableList().apply { this@apply.removeAt(it) }.let { newList ->
                state.copy(productSpecs = state.productSpecs.copy(specs = newList)).paste()
            }
        }
    }

    fun addOrEditCustomSpecExtra(it: ProductSpecsExtra) {
        _uiState.update { state ->
            state.productSpecs.specsExtra.toMutableList().apply {
                if (state.customSpecExtraIndex == -1) {
                    this@apply.add(it)
                } else {
                    runCatching {
                        this@apply[state.customSpecExtraIndex] = it
                    }
                }
            }.let { newList ->
                state.copy(productSpecs = state.productSpecs.copy(specsExtra = newList)).paste()
            }
        }
    }

    fun setDeleteCustomSpecExtra(it: Int) {
        _uiState.update { state ->
            state.productSpecs.specsExtra.toMutableList().apply { this@apply.removeAt(it) }.let { newList ->
                state.copy(productSpecs = state.productSpecs.copy(specsExtra = newList)).paste()
            }
        }
    }

    fun setOffer(it: String) {
        _uiState.update { state ->
            state.copy(product = state.product.copy(offerEditStr = it, offer = it.toFloatOrNull() ?: state.product.offer))
        }
    }

    fun setCountrySearch(it: String) {
        launchBack {
            countries().filter { c ->
                c.searchable.contains(it, true)
            }.let { list ->
                _uiState.update { state ->
                    state.copy(countrySearch = it, countryList = list)
                }
            }
        }
    }

    fun isOffer(it: Boolean) {
        if (it) {
            _uiState.update { state ->
                state.copy(product = state.product.copy(offer = state.product.price * 0.75F))
            }
        } else {
            _uiState.update { state ->
                state.copy(product = state.product.copy(offer = -1F))
            }
        }
    }

    fun setPrice(it: String) {
        _uiState.update { state ->
            state.copy(product = state.product.copy(priceEditStr = it, price = it.toFloatOrNull() ?: state.product.price))
        }
    }

    fun setDeliveryCost(it: String) {
        _uiState.update { state ->
            state.copy(deliveryProcess = state.deliveryProcess.copy(deliveryCostEditStr = it, deliveryCost = it.toFloatOrNull() ?: state.deliveryProcess.deliveryCost))
        }
    }

    fun setTitle(it: String) {
        _uiState.update { state ->
            state.copy(product = state.product.copy(title = it))
        }
    }

    fun setSubTitle(it: String) {
        _uiState.update { state ->
            state.copy(productSpecs = state.productSpecs.copy(subTitle = it))
        }
    }

    fun setMPN(it: String) {
        _uiState.update { state ->
            state.copy(productSpecs = state.productSpecs.copy(mpn = it))
        }
    }

    fun setUPC(it: String) {
        _uiState.update { state ->
            state.copy(product = state.product.copy(productCode = it))
        }
    }
    fun setQuantity(it: String) {
        _uiState.update { state ->
            state.copy(productSpecs = state.productSpecs.copy(quantityEditStr = it, quantity = it.toIntOrNull() ?: state.productSpecs.quantity))
        }
    }

    fun setCategory(it: Category) {
        val catoList = mutableListOf(it)
        uiState.value.listCategory.toMutableList().reversed().map { cato ->
            val e = cato.id == it.id || catoList.find { c -> c.parentId == cato.id } != null
            if (e) {
                catoList.add(cato)
            }
            e
        }
        _uiState.update { state ->
            state.copy(product = state.product.copy(parentCategories = catoList.distinct().map { it.name }))
        }
    }

    fun addNewProduct(isAdmin: Boolean, invoke: () -> Unit, failed: () -> Unit) {
        launchBack {
            project.productData.addNewProduct(
                uiState.value.product.copy(status = if (isAdmin) 0 else uiState.value.product.status)
            )?.let { pro ->
                project.productSpecsData.addNewProductSpecs(uiState.value.productSpecs.copy(productId = pro.id))?.let { _ ->
                    project.deliveryData.addNewDelivery(uiState.value.deliveryProcess.copy(productId = pro.id))?.let {
                        invoke()
                    } ?: failed()
                } ?: failed()
            } ?: failed()
        }
    }

    fun editProduct(isAdmin: Boolean, invoke: () -> Unit, failed: () -> Unit) {
        launchBack {
            project.productData.editProduct(
                uiState.value.product.copy(status = if (isAdmin) 0 else uiState.value.product.status)
            )?.let {
                project.productSpecsData.editProductSpecs(uiState.value.productSpecs)?.let {
                    project.deliveryData.editDelivery(uiState.value.deliveryProcess)?.let {
                        invoke()
                    } ?: failed()
                } ?: failed()
            } ?: failed()
        }
    }

    private fun setIsProcess(it: Boolean) {
        _uiState.update { state ->
            state.copy(isProcess = it)
        }
    }

    fun donePressed() {
        _uiState.value.copy(listCategory = emptyList(), countrySearch = "", customSpecIndex = -1, customSpecExtraIndex = -1).paste()
    }

}

data class StateProductSelling(
    val isProcess: Boolean = true,
    val product: Product = Product(),
    val productSpecs: ProductBaseSpecs = ProductBaseSpecs(),
    val deliveryProcess: DeliveryProcess = DeliveryProcess(shippingService = "USPS"),//.copy(shippingService = "USPS")
    val listCategory: List<Category> = emptyList(),
    val user: User = User(),
    val isErrorPressed: Boolean = false,
    val customSpecIndex: Int = -1,
    val customSpecExtraIndex: Int = -1,
    val countrySearch: String = "",
    val countryList: List<Country> = countries()
)
