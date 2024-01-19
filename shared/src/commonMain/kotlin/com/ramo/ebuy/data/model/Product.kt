package com.ramo.ebuy.data.model

import com.ramo.ebuy.global.util.TimeGap
import com.ramo.ebuy.global.util.fetchTimeGap
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class Product(
    @SerialName("id")
    val id: Long,
    @SerialName("product_code")
    val productCode: String,
    @SerialName("name")
    val name: String,
    @SerialName("image_uris")
    val imageUris: List<String>,
    @SerialName("price")
    val price: Float,
    @SerialName("discount")
    val discount: Float,
    @SerialName("discountStart")
    val discountStart: Long,
    @SerialName("discountEnd")
    val discountEnd: Long,
    @SerialName("parentCato")
    val parentCato: Int,
    @SerialName("parentCatoName")
    val parentCatoName: String,
    @SerialName("condition")
    val condition: String,
) {
    @Transient
    val timeGap: TimeGap? = fetchTimeGap(discountEnd)

    @Transient
    val discountPer: Int = (((price - discount) / ((price + discount) / 2)) * 100).toInt()
    var isFavorite: Boolean = false

    constructor() : this(
        0L,
        "",
        "",
        emptyList<String>(),
        0F,
        0F,
        0L,
        0L,
        -1,
        "",
            "",
    )
}

@Serializable
data class ProductBaseSpecs(
    @SerialName("product_id")
    val productID: Long,
    @SerialName("publisher_id")
    val publisherId: Long,
    @SerialName("country_product")
    val countryProduct: Int,
    @SerialName("platform")
    val platform: String,
    @SerialName("age_rate")
    val ageRate: String,
    @SerialName("release_year")
    val releaseYear: Long,
    @SerialName("mpn")
    val mpn: String,
    @SerialName("tint")
    val tint: List<Int>,
    @SerialName("product_spec")
    val specs: List<ProductSpecs>,
    @SerialName("extra_product_spec")
    val specsExtra: List<ProductSpecs>,
) {
    constructor() : this(
        0L,
        0L,
        0,
        "",
        "",
        0L,
        "",
        emptyList(),
        emptyList<ProductSpecs>(),
        emptyList<ProductSpecs>(),
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
    val spec: List<String>,
)

@Serializable
data class ProductAvailability(
    @SerialName("product_id")
    val productID: Long,
    @SerialName("product_ava_code")
    val productAvaCode: ProductAvaCode,
)

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
)
