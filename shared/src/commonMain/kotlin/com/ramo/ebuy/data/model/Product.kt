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
    val imageUris: Array<String> = arrayOf(),
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
    val parentCatoId: Long = -1,
    @SerialName("condition")
    val condition: String = "",
    @SerialName("scheduled")
    val scheduled: Long = -1L,
    @SerialName("currency")
    val currency: Int = 0,
    @SerialName("age_rating")
    val ageRating: Int = -1,
    @SerialName("item_status")
    val itemStatus: Int = 2, // underReview = 1 - rejected = -1  - accepted = 2 - asReference = 0
    @SerialName("parent_category")
    val parentCategory: Array<String> = arrayOf(),
    @SerialName("categories_search")
    val categoriesSearch: String = "",
    @Transient
    var isWatchlist: Boolean = false,
    @Transient
    val priceEditStr: String = if (price != -1F) price.toString() else "",
    @Transient
    val offerEditStr: String = if (offer != -1F) offer.toString() else "",
): BaseObject() {
    override fun json(): JsonObject {
        return kotlinx.serialization.json.Json.encodeToJsonElement(this.copy()).jsonObject.toMutableMap().apply {
            remove("id")
        }.let(::JsonObject)
    }

    @Transient
    val timeGap: TimeGap? = fetchTimeGap(auctionEnd)

    @Transient
    val parentCatoRest: String = parentCategory.toMutableList().filterIndexed { i, _ ->
        i != 0
    }.joinToString(" > ")

    @Transient
    val parentCatoFull: String = parentCategory.toMutableList().joinToString(" > ")

    @Transient
    val discountPer: Int = (((price - offer) / ((price + offer) / 2)) * 100).toInt()

    @Transient
    val ageRateStr: String = ratings.find { it.id == ageRating }?.display ?: ""

    @Transient
    val priceValid: Boolean = price != -1F

    @Transient
    val offerValid: Boolean = offer != -1F

    @Transient
    val priceStr: String = if (priceValid) "$ $price" else " "

    @Transient
    val offerStr: String = if (offerValid) "$ $offer" else ""


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (id != other.id) return false
        if (productCode != other.productCode) return false
        if (title != other.title) return false
        if (!imageUris.contentEquals(other.imageUris)) return false
        if (price != other.price) return false
        if (offer != other.offer) return false
        if (auction != other.auction) return false
        if (auctionStart != other.auctionStart) return false
        if (auctionEnd != other.auctionEnd) return false
        if (parentCatoId != other.parentCatoId) return false
        if (condition != other.condition) return false
        if (scheduled != other.scheduled) return false
        if (currency != other.currency) return false
        if (ageRating != other.ageRating) return false
        if (itemStatus != other.itemStatus) return false
        if (!parentCategory.contentEquals(other.parentCategory)) return false
        if (priceEditStr != other.priceEditStr) return false
        if (offerEditStr != other.offerEditStr) return false
        if (timeGap != other.timeGap) return false
        if (parentCatoRest != other.parentCatoRest) return false
        if (parentCatoFull != other.parentCatoFull) return false
        if (discountPer != other.discountPer) return false
        if (ageRateStr != other.ageRateStr) return false
        if (priceValid != other.priceValid) return false
        if (offerValid != other.offerValid) return false
        if (priceStr != other.priceStr) return false
        return offerStr == other.offerStr
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + productCode.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + imageUris.contentHashCode()
        result = 31 * result + price.hashCode()
        result = 31 * result + offer.hashCode()
        result = 31 * result + auction.hashCode()
        result = 31 * result + auctionStart.hashCode()
        result = 31 * result + auctionEnd.hashCode()
        result = 31 * result + parentCatoId.hashCode()
        result = 31 * result + condition.hashCode()
        result = 31 * result + scheduled.hashCode()
        result = 31 * result + currency
        result = 31 * result + ageRating
        result = 31 * result + itemStatus
        result = 31 * result + parentCategory.contentHashCode()
        result = 31 * result + priceEditStr.hashCode()
        result = 31 * result + offerEditStr.hashCode()
        result = 31 * result + (timeGap?.hashCode() ?: 0)
        result = 31 * result + parentCatoRest.hashCode()
        result = 31 * result + parentCatoFull.hashCode()
        result = 31 * result + discountPer
        result = 31 * result + ageRateStr.hashCode()
        result = 31 * result + priceValid.hashCode()
        result = 31 * result + offerValid.hashCode()
        result = 31 * result + priceStr.hashCode()
        result = 31 * result + offerStr.hashCode()
        return result
    }
}

@Serializable
data class ProductBaseSpecs(
    @SerialName("id")
    val id: Long = 0,
    @SerialName("product_id")
    val productId: Long = 0,
    @SerialName("sub_title")
    val subTitle: String = "",
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
    @SerialName("quantity")
    val quantity: Int = 0,
    @SerialName("quantity_available")
    val quantityAvailable: Int = 0,
    @SerialName("product_specs")
    val specs: Array<ProductSpecs> = arrayOf(),
    @SerialName("extra_product_specs")
    val specsExtra: Array<ProductSpecsExtra> = arrayOf(),
    @SerialName("id_publisher")
    val publisherId: String = "",
    @SerialName("description")
    val description: String = "",
    @Transient
    val quantityEditStr: String = if (quantity != -1) quantity.toString() else "",
): BaseObject() {

    @Transient
    val countryProductStr = countries().find { it.id == countryProduct }?.display ?: "US"

    val releaseYearOnly: String = if (releaseYear != 0L) splitTime(releaseYear).year.toString() else ""

    override fun json(): JsonObject {
        return kotlinx.serialization.json.Json.encodeToJsonElement(this.copy()).jsonObject.toMutableMap().apply {
            remove("id")
        }.let(::JsonObject)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProductBaseSpecs

        if (id != other.id) return false
        if (productId != other.productId) return false
        if (subTitle != other.subTitle) return false
        if (publisherId != other.publisherId) return false
        if (conditionDetails != other.conditionDetails) return false
        if (countryProduct != other.countryProduct) return false
        if (platform != other.platform) return false
        if (descriptionUrl != other.descriptionUrl) return false
        if (releaseYear != other.releaseYear) return false
        if (mpn != other.mpn) return false
        if (quantity != other.quantity) return false
        if (quantityAvailable != other.quantityAvailable) return false
        if (!specs.contentEquals(other.specs)) return false
        if (!specsExtra.contentEquals(other.specsExtra)) return false
        if (quantityEditStr != other.quantityEditStr) return false
        if (countryProductStr != other.countryProductStr) return false
        return releaseYearOnly == other.releaseYearOnly
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + productId.hashCode()
        result = 31 * result + subTitle.hashCode()
        result = 31 * result + publisherId.hashCode()
        result = 31 * result + conditionDetails.hashCode()
        result = 31 * result + countryProduct
        result = 31 * result + platform.hashCode()
        result = 31 * result + descriptionUrl.hashCode()
        result = 31 * result + releaseYear.hashCode()
        result = 31 * result + mpn.hashCode()
        result = 31 * result + quantity
        result = 31 * result + quantityAvailable
        result = 31 * result + specs.contentHashCode()
        result = 31 * result + specsExtra.contentHashCode()
        result = 31 * result + quantityEditStr.hashCode()
        result = 31 * result + countryProductStr.hashCode()
        result = 31 * result + releaseYearOnly.hashCode()
        return result
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