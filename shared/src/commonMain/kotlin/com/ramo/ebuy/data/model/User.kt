package com.ramo.ebuy.data.model

import com.ramo.ebuy.data.util.BaseObject
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

@Serializable
data class User(
    @SerialName("id")
    val id: String = "",
    @SerialName("name")
    val name: String = "",
    @SerialName("email")
    val email: String = "",
    @SerialName("phone")
    val phone: String = "",
    @SerialName("image")
    val image: String = "",
    @SerialName("business_name")
    val businessName: String = "",
    @SerialName("location_country")
    val businessCountry: Int = 0,
    @SerialName("loc_latitude")
    val locLat: Double = 0.0,
    @SerialName("loc_longitude")
    val locLong: Double = 0.0,
    @SerialName("zip")
    val zip: Int = 0,
    @SerialName("is_verified")
    val isVerified: Boolean = true,
    @SerialName("user_type")
    val userType: Int = 0, //USER = 0, ADMIN = 1
) : BaseObject() {

    @kotlinx.serialization.Transient
    val businessCountryStr = when(businessCountry) {
        0 -> "US"
        else -> "Egypt"
    }

    override fun json(): JsonObject {
        return kotlinx.serialization.json.Json.encodeToJsonElement(this).jsonObject.toMutableMap().apply {
            remove("id")
        }.let(::JsonObject)
    }

}
