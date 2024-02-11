package com.ramo.ebuy.data.model

import com.ramo.ebuy.data.util.BaseObject
import com.ramo.ebuy.global.util.TimeGap
import com.ramo.ebuy.global.util.countries
import com.ramo.ebuy.global.util.fetchTimeGap
import com.ramo.ebuy.global.util.ratings
import com.ramo.ebuy.global.util.splitTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

@Serializable
data class Product(
    @SerialName("id")
    val id: Long = 0,
    @SerialName("product_code")
    val productCode: String = "",
    @SerialName("title")
    val title: String = "",
    @SerialName("image_uris")
    val imageUris: List<String> = emptyList(),
    @SerialName("price")
    val price: Float = -1F,
    @SerialName("offer")
    val offer: Float = -1F,
    @SerialName("auction")
    val auction: Float = -1F,
    @SerialName("auction_start")
    val auctionStart: Long = 0,
    @SerialName("auction_end")
    val auctionEnd: Long = 0,
    @SerialName("parent_cato_id")
    val parentCato: Long = -1,
    @SerialName("parent_categories")
    val parentCategories: List<String> = emptyList(),
    @SerialName("condition")
    val condition: String = "",
    @SerialName("scheduled")
    val scheduled: Long = -1L,
    @SerialName("currency")
    val currency: Int = 0,
    @SerialName("age_rating")
    val ageRate: Int = -1,
    @SerialName("item_status")
    val status: Int = 2, // underReview = 1 - rejected = -1  - accepted = 2 - asReference = 0
    @Transient
    val priceEditStr: String = if (price != -1F) price.toString() else "",
    @Transient
    val offerEditStr: String = if (offer != -1F) offer.toString() else "",
): BaseObject() {
    override fun json(): JsonObject {
        return kotlinx.serialization.json.Json.encodeToJsonElement(this).jsonObject.toMutableMap().apply {
            remove("id")
        }.let(::JsonObject)
    }

    @Transient
    val timeGap: TimeGap? = fetchTimeGap(auctionEnd)

    @Transient
    val parentCatoRest: String = parentCategories.toMutableList().filterIndexed { i, _ ->
        i != 0
    }.joinToString(" > ")

    @Transient
    val parentCatoFull: String = parentCategories.toMutableList().joinToString(" > ")

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

}

@Serializable
data class ProductBaseSpecs(
    @SerialName("id")
    val id: Long = 0,
    @SerialName("product_id")
    val productId: Long = 0,
    @SerialName("sub_title")
    val subTitle: String = "",
    @SerialName("publisher_id")
    val publisherId: Long = 0L,
    @SerialName("condition_details")
    val conditionDetails: String = "",
    @SerialName("country_product")
    val countryProduct: Int = 0,
    @SerialName("platform")
    val platform: String = "",
    @SerialName("description_url")
    val descriptionUrl: String = "",
    @SerialName("release_year")
    val releaseYear: Long = 0L,
    @SerialName("mpn")
    val mpn: String = "",
    @SerialName("product_spec")
    val specs: List<ProductSpecs> = emptyList(),
    @SerialName("extra_product_spec")
    val specsExtra: List<ProductSpecsExtra> = emptyList(),
    @SerialName("quantity")
    val quantity: Int = 0,
    @SerialName("quantity_available")
    val quantityAvailable: Int = 0,
    @Transient
    val quantityEditStr: String = if (quantity != -1) quantity.toString() else "",
): BaseObject() {

    @Transient
    val countryProductStr = countries().find { it.id == countryProduct }?.display ?: "US"

    val releaseYearOnly: String = if (releaseYear != 0L) splitTime(releaseYear).year.toString() else ""

    override fun json(): JsonObject {
        return kotlinx.serialization.json.Json.encodeToJsonElement(this).jsonObject.toMutableMap().apply {
            remove("id")
        }.let(::JsonObject)
    }
}

/**
 * Embedded For [ProductBaseSpecs]
 */
@Serializable
data class ProductSpecs(
    @SerialName("label")
    val label: String = "",
    @SerialName("spec")
    val spec: String = "",
)

/**
 * Embedded For [ProductBaseSpecs]
 */
@Serializable
data class ProductSpecsExtra(
    @SerialName("label_extra")
    val labelExtra: String = "",
    @SerialName("specs_extra")
    val specExtra: List<SpecExtra> = emptyList(),
    @Transient
    val dummy: Int = 0,
)

/**
 * Embedded For [ProductSpecsExtra]
 */
@Serializable
data class SpecExtra(
    @SerialName("spec_label")
    var labelSpec: String,
    @SerialName("spec_price")
    var plusPriceSpec: Float,
    @SerialName("spec_quantity")
    var quantity: Int = 0,
    @SerialName("spec_quantity_available")
    val quantityAvailable: Int = 0,
    @Transient
    var priceSpecEditStr: String = if (plusPriceSpec != -1F) plusPriceSpec.toString() else "",
    @Transient
    var quantityEditStr: String = if (quantity != 0) quantity.toString() else "",
)
/*
@Serializable
data class ProductAvailability(
    @SerialName("id")
    val id: Long = 0,
    @SerialName("product_id")
    val productID: Long = 0,
    @SerialName("product_ava_code")
    val productAvaCode: ProductAvaCode = ProductAvaCode(),
): BaseObject() {
    override fun json(): JsonObject {
        return kotlinx.serialization.json.Json.encodeToJsonElement(this).jsonObject.toMutableMap().apply {
            remove("id")
        }.let(::JsonObject)
    }
}

/**
 * Embedded For [ProductAvailability]
 */
@Serializable
data class ProductAvaCode(
    @SerialName("spec_code")
    val specCode: String = "",
    @SerialName("quantity")
    val quantity: Int = 0,
    @SerialName("quantity_available")
    val quantityAvailable: Int = 0,
)
*/