package com.ramo.ebuy.ui.product

import com.ramo.ebuy.data.model.DeliveryProcess
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.model.ProductBaseSpecs
import com.ramo.ebuy.data.model.ProductSpecsExtra
import com.ramo.ebuy.data.model.SpecExtra
import com.ramo.ebuy.data.model.User
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.navigation.BaseViewModel
import com.ramo.ebuy.global.util.item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProductDetailsViewModel(project: Project) : BaseViewModel(project) {

    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    fun loadProDetails(productId: Long) {
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
                            state.copy(product = product, productSpecs = productSpecs, deliveryProcess = delivery, isProcess = false)
                        }
                    }
                } ?: setIsProcess(false)
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

    private fun setIsProcess(it: Boolean) {
        _uiState.update { state ->
            state.copy(isProcess = it)
        }
    }

    data class State(
        val product: Product = Product(
            id = 6330,
            productCode = "molestiae",
            title = "Wilson Pro Staff Classic 6.1 Si Tennis Racquet 95 sq in 4 5/8\" Grip",
            imageUris = arrayOf(
                "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/40/357284/1.jpg?5906",
                "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/359744/1.jpg?4978",
                "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/359744/1.jpg?4978"
            ),
            price = 48.49f,
            auction = -1f,
            offer = 31f,
            auctionStart = 9625,
            auctionEnd = 2549,
            parentCatoId = 5189,
            parentCategory = arrayOf("Video Game", "Sigma", "Figma"),
            condition = "New",
            scheduled = -1L,
            ageRating = 0,
            itemStatus = 1,
        ),
        val productSpecs: ProductBaseSpecs = ProductBaseSpecs(
            productId = product.id,
            subTitle = "",
            conditionDetails = "",
            countryProduct = 6413,
            platform = "LG",
            descriptionUrl = "",
            releaseYear = 1705769091483,
            mpn = "vestibulum",
            specs = arrayOf(),
            specsExtra = arrayOf(ProductSpecsExtra("Tints", listOf(SpecExtra("Red", 0F), SpecExtra("Blue", 0F), SpecExtra("Black", 0F), SpecExtra("Gray", 0F)))),
            publisherId = "7407",
        ),
        val deliveryProcess: DeliveryProcess = DeliveryProcess(product.id),
        val specChosen: List<SpecChosen> = listOf(),
        val productVer: List<Product> = item(),
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
