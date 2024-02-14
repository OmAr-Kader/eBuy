package com.ramo.ebuy.ui.product

import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.data.model.DeliveryProcess
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.model.ProductBaseSpecs
import com.ramo.ebuy.data.model.ProductSpecs
import com.ramo.ebuy.data.model.ProductSpecsExtra
import com.ramo.ebuy.data.model.User
import com.ramo.ebuy.data.supaBase.deleteFile
import com.ramo.ebuy.data.supaBase.uploadListFile
import com.ramo.ebuy.data.util.rearrange
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.base.SUPA_STORAGE_PRODUCT
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
                            state.copy(
                                product = product,
                                productGet = product,
                                productSpecs = productSpecs,
                                productSpecsGet = productSpecs,
                                deliveryProcess = delivery,
                                deliveryProcessGet = delivery,
                                isProcess = false
                            ).paste()
                        }
                    }
                } ?: setIsProcess(false)
            }
        }
    }

    fun loadCategories() {
        launchBack {
            project.categoryData.getCategories().rearrange().let { listCategory ->
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
            state.copy(product = state.product.copy(ageRating = it)).paste()
        }
    }

    fun addOrEditCustomSpec(it: ProductSpecs, customSpecIndex: Int) {
        _uiState.update { state ->
            state.productSpecs.specs.toMutableList().apply {
                if (customSpecIndex == -1) {
                    this@apply.add(it)
                } else {
                    runCatching {
                        this@apply[customSpecIndex] = it
                    }
                }
            }.let { newList ->
                state.copy(productSpecs = state.productSpecs.copy(specs = newList.toTypedArray())).paste()
            }
        }
    }

    fun setDeleteCustomSpec(it: Int) {
        _uiState.update { state ->
            state.productSpecs.specs.toMutableList().apply { this@apply.removeAt(it) }.let { newList ->
                state.copy(productSpecs = state.productSpecs.copy(specs = newList.toTypedArray())).paste()
            }
        }
    }

    fun addOrEditCustomSpecExtra(it: ProductSpecsExtra, customSpecExtraIndex: Int) {
        _uiState.update { state ->
            state.productSpecs.specsExtra.toMutableList().apply {
                if (customSpecExtraIndex == -1) {
                    this@apply.add(it)
                } else {
                    runCatching {
                        this@apply[customSpecExtraIndex] = it
                    }
                }
            }.let { newList ->
                state.copy(productSpecs = state.productSpecs.copy(specsExtra = newList.toTypedArray())).paste()
            }
        }
    }

    fun setDeleteCustomSpecExtra(it: Int) {
        _uiState.update { state ->
            state.productSpecs.specsExtra.toMutableList().apply { this@apply.removeAt(it) }.let { newList ->
                state.copy(productSpecs = state.productSpecs.copy(specsExtra = newList.toTypedArray())).paste()
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
            state.copy(
                deliveryProcess = state.deliveryProcess.copy(
                    deliveryCostEditStr = it,
                    deliveryCost = it.toFloatOrNull() ?: state.deliveryProcess.deliveryCost
                )
            )
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
        mutableListOf<Category>(it).also { catoList ->
            uiState.value.listCategory.toMutableList().reversed().map { cato ->
                val e = cato.id == it.id || catoList.find { c -> c.parentCato == cato.id } != null
                if (e) {
                    catoList.add(cato)
                }
                e
            }
        }.distinct().let { catosList ->
            _uiState.update { state ->
                state.copy(
                    product = state.product.copy(
                        parentCatoId = catosList.first().id,
                        parentCategory = catosList.map { it.name }.toTypedArray(),
                        categoriesSearch = catosList.joinToString(" ")
                    )
                )
            }
        }
    }

    fun addNewProduct(isAdmin: Boolean, invoke: () -> Unit, failed: () -> Unit) {
        setIsProcess(true)
        _uiState.value.apply {
            launchBack {
                userInfo()?.let { user ->
                    project.supaBase.uploadListFile(SUPA_STORAGE_PRODUCT, user.id, images) { imagesUrls ->
                        doAddProduct(imagesUrls, isAdmin, invoke, failed)
                    }
                } ?: failed()
            }
        }
    }

    private fun StateProductSelling.doAddProduct(imagesUrls: List<String>, isAdmin: Boolean, invoke: () -> Unit, failed: () -> Unit) {
        publisherId { publisherId ->
            launchBack {
                project.productData.addNewProduct(
                    product.copy(itemStatus = if (isAdmin) 0 else product.itemStatus, imageUris = imagesUrls.toTypedArray())
                )?.let { pro ->
                    project.productSpecsData.addNewProductSpecs(productSpecs.copy(productId = pro.id, publisherId = publisherId))?.let { _ ->
                        if (isAdmin) {
                            invoke()
                        } else {
                            project.deliveryData.addNewDelivery(deliveryProcess.copy(productId = pro.id))?.let {
                                invoke()
                            } ?: failed()
                        }
                    } ?: failed()
                } ?: failed()
            }
        }
    }

    private fun publisherId(invoke: (String) -> Unit) {
        launchBack {
            userInfo().let { it?.id ?: "" }.apply(invoke)
        }
    }

    fun editProduct(isAdmin: Boolean, invoke: () -> Unit, failed: () -> Unit) {
        _uiState.value.apply {
            checkValidObjects({ oriProduct, oriProductSpecs ->
                setIsProcess(true)
                editProductImages(product.imageUris, { newUrls ->
                    launchBack {
                        editProductObject(product.copy(imageUris = newUrls), oriProduct, {
                            editProductSpecsObject(productSpecs, oriProductSpecs, {
                                editDeliveryObject(isAdmin, deliveryProcess, deliveryProcessGet, {
                                    invoke()
                                }, failed)
                            }, failed)
                        }, failed)
                    }
                }, failed)
            }, failed)
        }
    }

    private fun StateProductSelling.checkValidObjects(invoke: (Product, ProductBaseSpecs) -> Unit, failed: () -> Unit) {
        productGet?.also { oriProduct ->
            productSpecsGet?.also { oriProductSpecs ->
                invoke(oriProduct, oriProductSpecs)
            } ?: failed()
        } ?: failed()
    }

    private fun StateProductSelling.editProductImages(currentImages: Array<String>, invoke: (Array<String>) -> Unit, failed: () -> Unit) {
        if (images.isNotEmpty()) {
            launchBack {
                userInfo()?.let { user ->
                    project.supaBase.uploadListFile(SUPA_STORAGE_PRODUCT, user.id, images) {
                        currentImages.toMutableList().apply {
                            addAll(it)
                        }.let { newImages ->
                            deleteImages(imagesUrlToDelete) {
                                invoke(newImages.toTypedArray())
                            }
                        }
                    }
                } ?: failed()
            }
        } else {
            deleteImages(imagesUrlToDelete) {
                invoke(currentImages)
            }
        }
    }

    private suspend fun editProductObject(newProduct: Product, oriProduct: Product, invoke: suspend (Product) -> Unit, failed: () -> Unit) {
        if (oriProduct != newProduct) {
            project.productData.editProduct(
                newProduct
            )?.apply {
                invoke(this)
            } ?: failed()
        } else {
            invoke(newProduct)
        }
    }

    private suspend fun editProductSpecsObject(
        newProductSpecs: ProductBaseSpecs,
        oriProductSpecs: ProductBaseSpecs,
        invoke: suspend (ProductBaseSpecs) -> Unit,
        failed: () -> Unit
    ) {
        if (oriProductSpecs != newProductSpecs) {
            project.productSpecsData.editProductSpecs(
                newProductSpecs
            )?.apply {
                invoke(this)
            } ?: failed()
        } else {
            invoke(newProductSpecs)
        }
    }

    private suspend fun editDeliveryObject(
        isAdmin: Boolean,
        newDelivery: DeliveryProcess,
        oriDelivery: DeliveryProcess?,
        invoke: suspend (DeliveryProcess?) -> Unit,
        failed: () -> Unit
    ) {
        if (isAdmin || oriDelivery == null) {
            invoke(null)
        } else {
            if (oriDelivery != newDelivery) {
                project.deliveryData.editDelivery(
                    newDelivery
                )?.apply {
                    invoke(this)
                } ?: failed()
            } else {
                invoke(newDelivery)
            }
        }
    }

    private fun deleteImages(imagesUrlToDelete: List<String>, invoke: (Unit?) -> Unit) {
        if (imagesUrlToDelete.isNotEmpty()) {
            launchBack {
                project.supaBase.deleteFile(SUPA_STORAGE_PRODUCT, imagesUrlToDelete) {
                    invoke(it)
                }
            }
        } else {
            invoke(Unit)
        }
    }

    fun setIsProcess(it: Boolean) {
        _uiState.update { state ->
            state.copy(isProcess = it)
        }
    }

    fun clear() {
        _uiState.update { state ->
            state.copy(listCategory = listOf(), images = listOf(), countrySearch = "")
        }
    }

    fun appendImageUrl(byteArrays: List<ByteArray>) {
        _uiState.update { state ->
            state.images.toMutableList().apply {
                addAll(byteArrays)
            }.let { newImages ->
                state.copy(images = newImages).paste()
            }
        }
    }

    fun removeImageUrl(pos: Int) {
        _uiState.update { state ->
            state.product.imageUris.getOrNull(pos).let { urlToDelete ->
                state.product.imageUris.toMutableList().apply {
                    removeAt(pos)
                }.let { urls ->
                    state.imagesUrlToDelete.toMutableList().apply {
                        urlToDelete?.let(::add)
                    }.let { urlsToDelete ->
                        state.copy(
                            product = state.product.copy(imageUris = urls.toTypedArray()),
                            imagesUrlToDelete = urlsToDelete,
                            dummy = state.dummy + 1
                        ).paste()
                    }
                }
            }
        }
    }

    fun removeImageByte(pos: Int) {
        _uiState.update { state ->
            state.images.toMutableList().apply {
                removeAt(pos)
            }.let {
                state.copy(images = it, dummy = state.dummy + 1).paste()
            }
        }
    }

    fun donePressed() {
        _uiState.value.copy(listCategory = listOf(), countrySearch = "").paste()
    }

}

data class StateProductSelling(
    val isProcess: Boolean = true,
    val product: Product = Product(),
    val productSpecs: ProductBaseSpecs = ProductBaseSpecs(),
    val deliveryProcess: DeliveryProcess = DeliveryProcess(shippingService = "USPS"),//.copy(shippingService = "USPS")
    val images: List<ByteArray> = listOf(),
    val imagesUrlToDelete: List<String> = listOf(),
    val listCategory: List<Category> = listOf(),
    val user: User = User(),
    val isErrorPressed: Boolean = false,
    val countrySearch: String = "",
    val countryList: List<Country> = countries(),
    val dummy: Int = 0,
    val productGet: Product? = null,
    val productSpecsGet: ProductBaseSpecs? = null,
    val deliveryProcessGet: DeliveryProcess? = null,
)
