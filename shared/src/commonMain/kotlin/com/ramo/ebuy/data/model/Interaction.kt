package com.ramo.ebuy.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserSearch(
    @SerialName("user_id")
    val userId: Long,
    @SerialName("search")
    val search: String,
    @SerialName("type_search")
    val searchType: Int, // Normal = 0 , Saved = 1
    @SerialName("last_use")
    val lastUse: Long,
)

@Serializable
data class UserWatchlist(
    @SerialName("user_id")
    val userId: Long,
    @SerialName("product_id")
    val watchlist: List<Long>,
)

@Serializable
data class UserBuyItems(
    @SerialName("user_id")
    val userId: Long,
    @SerialName("watchlist")
    val productId: Long,
    @SerialName("product_title")
    val productTitle: String,
)

@Serializable
data class UserRecentViewed(
    @SerialName("user_id")
    val userId: Long,
    @SerialName("product_id")
    val productId: Long,
    @SerialName("last_use")
    val lastUse: Long,
)