package com.ramo.ebuy.data.model

import com.ramo.ebuy.data.util.BaseObject
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

@Serializable
data class UserSearch(
    @SerialName("id")
    val id: Long = 0,
    @SerialName("user_id")
    val userId: Long,
    @SerialName("search")
    val search: String,
    @SerialName("type_search")
    val searchType: Int, // Normal = 0 , Saved = 1
    @SerialName("last_use")
    val lastUse: Long,
): BaseObject() {
    override fun json(): JsonObject {
        return kotlinx.serialization.json.Json.encodeToJsonElement(this).jsonObject.toMutableMap().apply {
            remove("id")
        }.let(::JsonObject)
    }
}

@Serializable
data class UserWatchlist(
    @SerialName("id")
    val id: Long = 0,
    @SerialName("user_id")
    val userId: Long,
    @SerialName("product_id")
    val watchlist: Array<Long>,
): BaseObject() {
    override fun json(): JsonObject {
        return kotlinx.serialization.json.Json.encodeToJsonElement(this).jsonObject.toMutableMap().apply {
            remove("id")
        }.let(::JsonObject)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserWatchlist

        if (id != other.id) return false
        if (userId != other.userId) return false
        return watchlist.contentEquals(other.watchlist)
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + userId.hashCode()
        result = 31 * result + watchlist.contentHashCode()
        return result
    }
}

@Serializable
data class UserBuyItems(
    @SerialName("id")
    val id: Long = 0,
    @SerialName("user_id")
    val userId: Long,
    @SerialName("watchlist")
    val productId: Long,
    @SerialName("product_title")
    val productTitle: String,
): BaseObject() {
    override fun json(): JsonObject {
        return kotlinx.serialization.json.Json.encodeToJsonElement(this).jsonObject.toMutableMap().apply {
            remove("id")
        }.let(::JsonObject)
    }
}

@Serializable
data class UserRecentViewed(
    @SerialName("id")
    val id: Long = 0,
    @SerialName("user_id")
    val userId: Long,
    @SerialName("product_id")
    val productId: Long,
    @SerialName("last_use")
    val lastUse: Long,
): BaseObject() {
    override fun json(): JsonObject {
        return kotlinx.serialization.json.Json.encodeToJsonElement(this).jsonObject.toMutableMap().apply {
            remove("id")
        }.let(::JsonObject)
    }
}