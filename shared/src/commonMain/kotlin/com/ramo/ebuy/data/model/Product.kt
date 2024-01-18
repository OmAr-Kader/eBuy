package com.ramo.ebuy.data.model

import com.ramo.ebuy.global.util.TimeGap
import com.ramo.ebuy.global.util.fetchTimeGap
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Long,
    @SerialName("name")
    val name: String,
    @SerialName("imageUri")
    val imageUri: String,
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
    @SerialName("sold")
    val sold: Int,
    @SerialName("country")
    val country: Int,
    @SerialName("size")
    val size: String,
    @SerialName("condition")
    val condition: String,
    @SerialName("quantity")
    val quantity: Int,
    @SerialName("quantity_available")
    val quantityAvailable: Int,
    @SerialName("tint")
    val tint: String,
    @SerialName("category")
    val category: Int,
    @SerialName("product_spec")
    val specs: List<ProductSpecs>,
    @SerialName("returns")
    val returns: Int,
    @SerialName("payments")
    val payments: List<Int>,
    @SerialName("import_charges")
    val importCharges: Int,
) {
    @kotlinx.serialization.Transient
    val timeGap: TimeGap? = fetchTimeGap(discountEnd)

    @kotlinx.serialization.Transient
    val discountPer: Int = (((price - discount) / ((price + discount) / 2)) * 100).toInt()
    var isFavorite: Boolean = false

    constructor() : this(
        0L,
        "",
        "",
        0F,
        0F,
        0L,
        0L,
        -1,
        "",
        0,
        0,
        "",
        "",
        0,
        0,
        "",
        0,
        emptyList<ProductSpecs>(),
        -1,
        emptyList(),
        -1
    )
}

@Serializable
data class ProductSpecs(
    @SerialName("label")
    val label: String,
    @SerialName("spec")
    val spec: List<String>,
)

@Serializable
data class DeliveryProcess(
    @SerialName("from")
    val from: String,
    @SerialName("up_to")
    val upTo: String,
    @SerialName("specProcess")
    val location: List<String>,
)