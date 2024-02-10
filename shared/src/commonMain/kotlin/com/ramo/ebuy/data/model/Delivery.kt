package com.ramo.ebuy.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class DeliveryProcess(
    @SerialName("product_id")
    val productID: Long,
    @SerialName("shipping_id")
    val shippingID: Long,
    @SerialName("service")
    val shippingService: String,
    @SerialName("from")
    val fromDate: Int,
    @SerialName("up_to")
    val upToDate: Int,
    @SerialName("size_phys")
    val size: String,
    @SerialName("delivery_cost")
    val deliveryCost: Float,
    @SerialName("delivery_type")
    val deliveryType: Int,
    @SerialName("publisher")
    val publisher: String,
    @SerialName("location")
    val location: String,
    @SerialName("loc_latitude")
    val locLat: Double,
    @SerialName("loc_longitude")
    val locLong: Double,
    @SerialName("returns")
    val returns: Int,
    @SerialName("import_charges")
    val importCharges: Int,
    @Transient
    val deliveryCostEditStr: String = if (deliveryCost != -1F) deliveryCost.toString() else "",
) {

    @Transient
    val durationStr = "$fromDate - $upToDate business days"

    @Transient
    val deliveryCostValid: Boolean = deliveryCost != -1F

    @Transient
    val deliveryCostStr: String = if (deliveryCostValid) "$ $deliveryCost" else " "

    constructor(productID: Long) : this(
        productID = productID,
        0L,
        "",
        3,
        5,
        "",
        -1F,
        -1,
        "",
        "",
        0.0,
        0.0,
        -1,
        -1,
    )
}

