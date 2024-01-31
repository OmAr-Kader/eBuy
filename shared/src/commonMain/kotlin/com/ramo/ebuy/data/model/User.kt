package com.ramo.ebuy.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("id")
    val id: Long,
    @SerialName("name")
    val name: String,
    @SerialName("email")
    val email: String,
    @SerialName("business_name")
    val businessName: String,
    @SerialName("location_country")
    val businessCountry: Int,
    @SerialName("loc_latitude")
    val locLat: Double,
    @SerialName("loc_longitude")
    val locLong: Double,
    @SerialName("zip")
    val zip: Int,
) {

    @kotlinx.serialization.Transient
    val businessCountryStr =  when(businessCountry) {
        0 -> "US"
        else -> "Egypt"
    }

    constructor() : this(
        id = 0,
        name = "",
        email = "",
        businessName = "",
        businessCountry = 0,
        locLat = 0.0,
        locLong = 0.0,
        zip = 0,
    )

    constructor(id: Long, name: String, email: String, businessCountry: Int = 0) : this(
        id = id,
        name = name,
        email = email,
        businessName = "",
        businessCountry = businessCountry,
        locLat = 0.0,
        locLong = 0.0,
        zip = 0,
    )
}