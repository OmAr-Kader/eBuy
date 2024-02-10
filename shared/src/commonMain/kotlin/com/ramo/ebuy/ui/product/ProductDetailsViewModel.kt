package com.ramo.ebuy.ui.product

import com.ramo.ebuy.data.model.DeliveryProcess
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.model.ProductAvailability
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

    data class State(
        val product: Product = Product(
            id = 6330,
            productCode = "molestiae",
            title = "Wilson Pro Staff Classic 6.1 Si Tennis Racquet 95 sq in 4 5/8\" Grip",
            imageUris = listOf(
                "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/40/357284/1.jpg?5906",
                "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/359744/1.jpg?4978",
                "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/359744/1.jpg?4978"
            ),
            price = 48.49f,
            auction = -1f,
            offer = 31f,
            auctionStart = 9625,
            auctionEnd = 2549,
            parentCato = 5189,
            parentCategories = listOf("Video Game", "Sigma", "Figma"),
            condition = "New",
            scheduled = -1L,
            ageRate = 0,
            status = 1,
        ),
        val productSpecs: ProductBaseSpecs = ProductBaseSpecs(
            productID = product.id,
            subTitle = "",
            publisherId = 7407,
            conditionDetails = "",
            countryProduct = 6413,
            platform = "LG",
            descriptionUrl = "",
            releaseYear = 1705769091483,
            mpn = "vestibulum",
            specs = listOf(),
            specsExtra = listOf(ProductSpecsExtra("Tints", listOf(SpecExtra("Red", 0F), SpecExtra("Blue", 0F), SpecExtra("Black", 0F), SpecExtra("Gray", 0F))))
        ),
        val productAva: ProductAvailability = ProductAvailability(product.id),
        val deliveryProcess: DeliveryProcess = DeliveryProcess(product.id),
        val specChosen: List<SpecChosen> = emptyList(),
        val productVer: List<Product> = item(),
        val droppedIndex: Int = -1,
        val user: User? = null,
        val isModalBottom: Boolean = false,
        val dummy: Int = 0,
    )
    data class SpecChosen(
        val index: Int,
        val userSpecIndex: Int,
    )
}
