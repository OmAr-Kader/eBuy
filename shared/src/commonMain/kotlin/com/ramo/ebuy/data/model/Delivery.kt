package com.ramo.ebuy.data.model

import com.ramo.ebuy.data.util.BaseObject
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

@Serializable
data class DeliveryProcess(
    @SerialName("id")
    val id: Long = 0,
    @SerialName("product_id")
    val productId: Long = 0,
    @SerialName("shipping_id")
    val shippingID: Long = 0L,
    @SerialName("service")
    val shippingService: String = "",
    @SerialName("from")
    val fromDate: Int = 3,
    @SerialName("up_to")
    val upToDate: Int = 5,
    @SerialName("size_phys")
    val size: String = "",
    @SerialName("delivery_cost")
    val deliveryCost: Float = -1F,
    @SerialName("delivery_type")
    val deliveryType: Int = -1,
    @SerialName("publisher")
    val publisher: String = "",
    @SerialName("location")
    val location: String = "",
    @SerialName("loc_latitude")
    val locLat: Double = 0.0,
    @SerialName("loc_longitude")
    val locLong: Double = 0.0,
    @SerialName("returns")
    val returns: Int = -1,
    @SerialName("import_charges")
    val importCharges: Int = -1,
    @Transient
    val deliveryCostEditStr: String = if (deliveryCost != -1F) deliveryCost.toString() else "",
): BaseObject() {

    @Transient
    val durationStr = "$fromDate - $upToDate business days"

    @Transient
    val deliveryCostValid: Boolean = deliveryCost != -1F

    @Transient
    val deliveryCostStr: String = if (deliveryCostValid) "$ $deliveryCost" else " "

    override fun json(): JsonObject {
        return kotlinx.serialization.json.Json.encodeToJsonElement(this).jsonObject.toMutableMap().apply {
            remove("id")
        }.let(::JsonObject)
    }
}

