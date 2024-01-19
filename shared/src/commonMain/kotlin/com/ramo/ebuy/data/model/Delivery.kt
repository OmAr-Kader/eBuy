package com.ramo.ebuy.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DeliveryProcess(
    @SerialName("product_id")
    val productID: Long,
    @SerialName("shipping_id")
    val shippingID: Long,
    @SerialName("from")
    val fromDate: String,
    @SerialName("up_to")
    val upToDate: String,
    @SerialName("size_phys")
    val size: String,
    @SerialName("delivery_cost")
    val deliveryCost: Int,
    @SerialName("pub_country")
    val publisher: String,
    @SerialName("specProcess")
    val location: List<String>,
    @SerialName("returns")
    val returns: Int,
    @SerialName("payments")
    val payments: List<Int>,
    @SerialName("import_charges")
    val importCharges: Int,
) {
    constructor() : this(
        0L,
        0L,
        "",
        "",
        "",
        0,
        "",
        emptyList(),
        -1,
        emptyList(),
        -1,
    )
}
