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
    val specs: Array<ProductSpecs>,
) {
    @kotlinx.serialization.Transient
    val timeGap: TimeGap? = fetchTimeGap(discountEnd)

    @kotlinx.serialization.Transient
    val discountPer: Int = (((price - discount) / ((price + discount) / 2)) * 100).toInt()
    var isFavorite: Boolean = false
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (id != other.id) return false
        if (name != other.name) return false
        if (imageUri != other.imageUri) return false
        if (price != other.price) return false
        if (discount != other.discount) return false
        if (discountStart != other.discountStart) return false
        if (discountEnd != other.discountEnd) return false
        if (parentCato != other.parentCato) return false
        if (parentCatoName != other.parentCatoName) return false
        if (sold != other.sold) return false
        if (country != other.country) return false
        if (size != other.size) return false
        if (condition != other.condition) return false
        if (quantity != other.quantity) return false
        if (quantityAvailable != other.quantityAvailable) return false
        if (tint != other.tint) return false
        if (category != other.category) return false
        if (!specs.contentEquals(other.specs)) return false
        if (timeGap != other.timeGap) return false
        return discountPer == other.discountPer
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + imageUri.hashCode()
        result = 31 * result + price.hashCode()
        result = 31 * result + discount.hashCode()
        result = 31 * result + discountStart.hashCode()
        result = 31 * result + discountEnd.hashCode()
        result = 31 * result + parentCato
        result = 31 * result + parentCatoName.hashCode()
        result = 31 * result + sold
        result = 31 * result + country
        result = 31 * result + size.hashCode()
        result = 31 * result + condition.hashCode()
        result = 31 * result + quantity
        result = 31 * result + quantityAvailable
        result = 31 * result + tint.hashCode()
        result = 31 * result + category
        result = 31 * result + specs.contentHashCode()
        result = 31 * result + (timeGap?.hashCode() ?: 0)
        result = 31 * result + discountPer
        return result
    }
}

@Serializable
data class ProductSpecs(
    @SerialName("label")
    val label: String,
    @SerialName("spec")
    val spec: String,
)