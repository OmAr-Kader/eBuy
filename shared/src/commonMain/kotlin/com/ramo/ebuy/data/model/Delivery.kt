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
    @SerialName("from")
    val fromDate: Int,
    @SerialName("up_to")
    val upToDate: Int,
    @SerialName("size_phys")
    val size: String,
    @SerialName("delivery_cost")
    val deliveryCost: Float,
    @SerialName("pub_country")
    val publisher: String,
    @SerialName("location")
    val location: List<String>,
    @SerialName("returns")
    val returns: Int,
    @SerialName("payments")
    val payments: List<Int>,
    @SerialName("service")
    val service: Int,
    @SerialName("import_charges")
    val importCharges: Int,
) {

    @Transient
    val serviceStr = when(service) {
        0 -> "USPS"
        else -> "FEDEX"
    }

    @Transient
    val durationStr = "$fromDate - $upToDate business days"

    @Transient
    val deliveryCostValid: Boolean = deliveryCost != -1F

    @Transient
    val deliveryStr: String = if (deliveryCostValid) "$ $deliveryCost" else " "

    constructor(productID: Long) : this(
        productID = productID,
        0L,
        3,
        5,
        "",
        -1F,
        "",
        emptyList(),
        -1,
        emptyList(),
        0,
        -1,
    )
}

