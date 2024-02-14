package com.ramo.ebuy.data.dataSources.interaction

import com.ramo.ebuy.data.model.UserBuyItems
import com.ramo.ebuy.data.model.UserRecentViewed
import com.ramo.ebuy.data.model.UserSearch
import com.ramo.ebuy.data.model.UserWatchlist
import com.ramo.ebuy.data.util.BaseRepoImp
import com.ramo.ebuy.global.base.SUPA_RECENT_VIEWED
import com.ramo.ebuy.global.base.SUPA_USER_BUY_ITEMS
import com.ramo.ebuy.global.base.SUPA_USER_SEARCH
import com.ramo.ebuy.global.base.SUPA_USER_WATCHLIST
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.query.Order

class UserSearchRepoImp(supabase: SupabaseClient) : BaseRepoImp(supabase), UserSearchRepo {

    override suspend fun getUserSearches(): List<UserSearch> = queryAllOrder(SUPA_USER_SEARCH) {
        order("lastUse", order = Order.DESCENDING)
    }

    override suspend fun addNewUserSearch(item: UserSearch): UserSearch? = insert(
        SUPA_USER_SEARCH,
        item
    )

    override suspend fun editUserSearch(item: UserSearch): UserSearch? = edit(
        SUPA_USER_SEARCH,
        item.id,
        item,
    )

    override suspend fun deleteUserSearch(id: Long): Int = delete(
        SUPA_USER_SEARCH,
        id
    )

}

class UserWatchlistRepoImp(supabase: SupabaseClient) : BaseRepoImp(supabase), UserWatchlistRepo {

    override suspend fun getUserWatchlist(): List<UserWatchlist> = queryAll(SUPA_USER_WATCHLIST)

    override suspend fun addNewUserWatchlist(item: UserWatchlist): UserWatchlist? = insert(
        SUPA_USER_WATCHLIST,
        item
    )

    override suspend fun editUserWatchlist(item: UserWatchlist): UserWatchlist? = edit(
        SUPA_USER_WATCHLIST,
        item.id,
        item,
    )

    override suspend fun deleteUserWatchlist(id: Long): Int = delete(
        SUPA_USER_WATCHLIST,
        id
    )

}

class UserBuyItemsRepoImp(supabase: SupabaseClient) : BaseRepoImp(supabase), UserBuyItemsRepo {

    override suspend fun getUserBuyItems(): List<UserBuyItems> = queryAllOrder(SUPA_USER_BUY_ITEMS) {
        order("last_purchase", order = Order.DESCENDING)
    }

    override suspend fun addNewUserBuyItems(item: UserBuyItems): UserBuyItems? = insert(
        SUPA_USER_BUY_ITEMS,
        item
    )

    override suspend fun editUserBuyItems(item: UserBuyItems): UserBuyItems? = edit(
        SUPA_USER_BUY_ITEMS,
        item.id,
        item,
    )

    override suspend fun deleteUserBuyItems(id: Long): Int = delete(
        SUPA_USER_BUY_ITEMS,
        id
    )

}

class UserRecentViewedRepoImp(supabase: SupabaseClient) : BaseRepoImp(supabase), UserRecentViewedRepo {
    override suspend fun getUserRecentViewed(): List<UserRecentViewed> = queryAllOrder(SUPA_RECENT_VIEWED) {
        order("last_use", order = Order.DESCENDING)
    }

    override suspend fun addNewUserRecentViewed(item: UserRecentViewed): UserRecentViewed? = insert(
        SUPA_RECENT_VIEWED,
        item
    )

    override suspend fun editUserRecentViewed(item: UserRecentViewed): UserRecentViewed? = edit(
        SUPA_RECENT_VIEWED,
        item.id,
        item,
    )

    override suspend fun deleteUserRecentViewed(id: Long): Int = delete(
        SUPA_RECENT_VIEWED,
        id
    )
}