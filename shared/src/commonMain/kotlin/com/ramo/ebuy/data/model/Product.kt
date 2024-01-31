package com.ramo.ebuy.data.model

import com.ramo.ebuy.global.util.TimeGap
import com.ramo.ebuy.global.util.countries
import com.ramo.ebuy.global.util.fetchTimeGap
import com.ramo.ebuy.global.util.ratings
import com.ramo.ebuy.global.util.splitTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class Product(
    @SerialName("id")
    val id: Long,
    @SerialName("product_code")
    val productCode: String,
    @SerialName("title")
    val title: String,
    @SerialName("image_uris")
    val imageUris: List<String>,
    @SerialName("price")
    val price: Float,
    @SerialName("offer")
    val offer: Float,
    @SerialName("auction")
    val auction: Float,
    @SerialName("auction_start")
    val auctionStart: Long,
    @SerialName("auction_end")
    val auctionEnd: Long,
    @SerialName("parentCato")
    val parentCato: Long,
    @SerialName("parent_categories")
    val parentCategories: List<String>,
    @SerialName("condition")
    val condition: String,
    @SerialName("scheduled")
    val scheduled: Long,
    @SerialName("currency")
    val currency: Int = 0,
    @SerialName("age_rating")
    val ageRate: Int,
    @SerialName("item_status")
    val status: Int, // underReview = 0 - rejected = -1  - accepted = 1
    @Transient
    val priceEditStr: String = if (price != -1F) price.toString() else "",
    @Transient
    val offerEditStr: String = if (offer != -1F) offer.toString() else "",
) {
    @Transient
    val timeGap: TimeGap? = fetchTimeGap(auctionEnd)

    @Transient
    val parentCatoRest: String = parentCategories.toMutableList().filterIndexed { i, _ ->
        i != 0
    }.joinToString(" > ")

    @Transient
    val parentCatoFull: String = parentCategories.toMutableList().joinToString(" > ")

    //@Transient
    val parentCatoLast: String?
        get() = parentCategories.firstOrNull()

    @Transient
    val discountPer: Int = (((price - offer) / ((price + offer) / 2)) * 100).toInt()

    @Transient
    val ageRateStr: String = ratings.find { it.id == ageRate }?.display ?: ""

    @Transient
    val priceValid: Boolean = price != -1F

    @Transient
    val offerValid: Boolean = offer != -1F

    @Transient
    val priceStr: String = if (priceValid) "$ $price" else " "

    @Transient
    val offerStr: String = if (offerValid) "$ $offer" else ""

    constructor() : this(
        0L,
        productCode = "",
        title = "",
        imageUris = emptyList<String>(),
        price = -1F,
        offer = -1F,
        auction = -1F,
        auctionStart = 0L,
        auctionEnd = 0L,
        parentCato = -1,
        parentCategories  = emptyList(),
        condition = "",
        scheduled = -1L,
        ageRate = -1,
        status = 1,
    )

}

@Serializable
data class ProductBaseSpecs(
    @SerialName("product_id")
    val productID: Long,
    @SerialName("sub_title")
    val subTitle: String,
    @SerialName("publisher_id")
    val publisherId: Long,
    @SerialName("country_product")
    val countryProduct: Int,
    @SerialName("platform")
    val platform: String,
    @SerialName("release_year")
    val releaseYear: Long,
    @SerialName("mpn")
    val mpn: String,
    @SerialName("product_spec")
    val specs: List<ProductSpecs>,
    @SerialName("extra_product_spec")
    val specsExtra: List<ProductSpecsExtra>,
) {

    @Transient
    val countryProductStr = countries().find { it.id == countryProduct }?.display ?: "US"

    val releaseYearOnly: String = if (releaseYear != 0L) splitTime(releaseYear).year.toString() else ""

    constructor(productID: Long) : this(
        productID = productID,
        "",
        0L,
        0,
        "",
        0L,
        "",
        emptyList<ProductSpecs>(),
        emptyList<ProductSpecsExtra>(),
    )
}

/**
 * Embedded For [ProductBaseSpecs]
 */
@Serializable
data class ProductSpecs(
    @SerialName("label")
    val label: String,
    @SerialName("spec")
    val spec: String,
) {
    constructor() : this("", "")
}

/**
 * Embedded For [ProductBaseSpecs]
 */
@Serializable
data class ProductSpecsExtra(
    @SerialName("label")
    val labelExtra: String,
    @SerialName("spec")
    val specExtra: List<String>,
)

@Serializable
data class ProductAvailability(
    @SerialName("product_id")
    val productID: Long,
    @SerialName("product_ava_code")
    val productAvaCode: ProductAvaCode,
) {
    constructor(productID: Long) : this(productID, ProductAvaCode())
}

/**
 * Embedded For [ProductAvailability]
 */
@Serializable
data class ProductAvaCode(
    @SerialName("spec_code")
    val specCode: String,
    @SerialName("quantity")
    val quantity: Int,
    @SerialName("quantity_available")
    val quantityAvailable: Int,
) {
    constructor() : this(
        specCode = "",
        quantity = 0,
        quantityAvailable = 0,
    )
}
