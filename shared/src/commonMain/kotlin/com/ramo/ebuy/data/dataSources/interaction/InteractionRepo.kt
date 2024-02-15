package com.ramo.ebuy.data.dataSources.interaction

import com.ramo.ebuy.data.model.UserBuyItems
import com.ramo.ebuy.data.model.UserRecentViewed
import com.ramo.ebuy.data.model.UserSearch
import com.ramo.ebuy.data.model.UserWatchlist

interface UserSearchRepo {
    suspend fun getUserSearches(userId: String): List<UserSearch>
    suspend fun addEditUserSearch(item: UserSearch): UserSearch?
    suspend fun deleteUserSearch(userId: String): Int
}

interface UserWatchlistRepo {
    suspend fun getUserWatchlist(id: String): UserWatchlist?
    suspend fun addNewUserWatchlist(item: UserWatchlist): UserWatchlist?
    suspend fun editUserWatchlist(item: UserWatchlist): UserWatchlist?
    suspend fun deleteUserWatchlist(id: Long): Int
}

interface UserBuyItemsRepo {
    suspend fun getUserBuyItems(): List<UserBuyItems>
    suspend fun addNewUserBuyItems(item: UserBuyItems): UserBuyItems?
    suspend fun editUserBuyItems(item: UserBuyItems): UserBuyItems?
    suspend fun deleteUserBuyItems(id: Long): Int
}

interface UserRecentViewedRepo {
    suspend fun getUserRecentViewed(): List<UserRecentViewed>
    suspend fun addNewUserRecentViewed(item: UserRecentViewed): UserRecentViewed?
    suspend fun editUserRecentViewed(item: UserRecentViewed): UserRecentViewed?
    suspend fun deleteUserRecentViewed(id: Long): Int
}