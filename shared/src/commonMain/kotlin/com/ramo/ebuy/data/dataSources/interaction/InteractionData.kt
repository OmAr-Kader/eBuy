package com.ramo.ebuy.data.dataSources.interaction

import com.ramo.ebuy.data.model.UserBuyItems
import com.ramo.ebuy.data.model.UserRecentViewed
import com.ramo.ebuy.data.model.UserSearch
import com.ramo.ebuy.data.model.UserWatchlist

class UserSearchData(
    private val repo: UserSearchRepo,
) {
    suspend fun getUserSearches(userId: String): List<UserSearch> = repo.getUserSearches(userId)
    suspend fun addEditUserSearch(item: UserSearch): UserSearch? = repo.addEditUserSearch(item)
    suspend fun deleteUserSearch(userId: String): Int = repo.deleteUserSearch(userId)
}

class UserBuyItemsData(
    private val repo: UserBuyItemsRepo,
) {
    suspend fun getUserBuyItems(): List<UserBuyItems> = repo.getUserBuyItems()
    suspend fun addNewUserBuyItems(item: UserBuyItems): UserBuyItems? = repo.addNewUserBuyItems(item)
    suspend fun editUserBuyItems(item: UserBuyItems): UserBuyItems? = repo.editUserBuyItems(item)
    suspend fun deleteUserBuyItems(id: Long): Int = repo.deleteUserBuyItems(id)
}

class UserWatchlistData(
    private val repo: UserWatchlistRepo,
) {
    suspend fun getUserWatchlist(id: String): UserWatchlist? = repo.getUserWatchlist(id)
    suspend fun addNewUserWatchlist(item: UserWatchlist): UserWatchlist? = repo.addNewUserWatchlist(item)
    suspend fun editUserWatchlist(item: UserWatchlist): UserWatchlist? = repo.editUserWatchlist(item)
    suspend fun deleteUserWatchlist(id: Long): Int = repo.deleteUserWatchlist(id)
}


class UserRecentViewedData(
    private val repo: UserRecentViewedRepo,
) {
    suspend fun getUserRecentViewed(): List<UserRecentViewed> = repo.getUserRecentViewed()
    suspend fun addNewUserRecentViewed(item: UserRecentViewed): UserRecentViewed? = repo.addNewUserRecentViewed(item)
    suspend fun editUserRecentViewed(item: UserRecentViewed): UserRecentViewed? = repo.editUserRecentViewed(item)
    suspend fun deleteUserRecentViewed(id: Long): Int = repo.deleteUserRecentViewed(id)
}