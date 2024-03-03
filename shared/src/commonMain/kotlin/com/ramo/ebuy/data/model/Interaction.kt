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
    @SerialName("type_search")
    val typeSearch: Int = 0, // Normal = 0 , Saved = 1
    @SerialName("last_use")
    val lastUse: Long = 0L,
    @SerialName("id_user_search")
    val idUserSearch: String = "",
    @SerialName("user_id")
    val userId: String = "",
    @SerialName("search")
    val search: String = "",
) : BaseObject() {
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
    val userId: String = "",
    @SerialName("watchlist")
    val watchlist: Array<Long> = arrayOf(),
) : BaseObject() {
    override fun json(): JsonObject {
        return kotlinx.serialization.json.Json.encodeToJsonElement(this).jsonObject.toMutableMap().apply {
            remove("id")
        }.let(::JsonObject)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as UserWatchlist

        if (id != other.id) return false
        if (userId != other.userId) return false
        if (!watchlist.contentEquals(other.watchlist)) return false

        return true
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
    val userId: String = "",
    @SerialName("product_id")
    val productId: Long = -1L,
    @SerialName("product_title")
    val productTitle: String = "",
    @SerialName("last_purchase")
    val lastPurchase: Long = 0L,
) : BaseObject() {
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
    val userId: String = "",
    @SerialName("user_recent")
    val userRecent: Array<UserRecent> = emptyArray()
) : BaseObject() {
    override fun json(): JsonObject {
        return kotlinx.serialization.json.Json.encodeToJsonElement(this).jsonObject.toMutableMap().apply {
            remove("id")
        }.let(::JsonObject)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as UserRecentViewed

        if (id != other.id) return false
        if (userId != other.userId) return false
        return userRecent.contentEquals(other.userRecent)
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + userId.hashCode()
        result = 31 * result + userRecent.contentHashCode()
        return result
    }
}

/**
 * Embedded For [UserRecentViewed]
 */
@Serializable
data class UserRecent(
    @SerialName("product_id")
    val productId: Long,
    @SerialName("last_use")
    val lastUse: Long,
)

@Serializable
data class UserCart(
    @SerialName("id")
    val id: Long = 0,
    @SerialName("user_id")
    val userId: String,
    @SerialName("product_id")
    val productId: Long,
    @SerialName("quantity")
    val quantity: Int
) : BaseObject() {
    override fun json(): JsonObject {
        return kotlinx.serialization.json.Json.encodeToJsonElement(this).jsonObject.toMutableMap().apply {
            remove("id")
        }.let(::JsonObject)
    }
}

