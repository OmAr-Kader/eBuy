package com.ramo.ebuy.data.dataSources.interaction

import com.ramo.ebuy.data.model.UserBuyItems
import com.ramo.ebuy.data.model.UserCart
import com.ramo.ebuy.data.model.UserRecentViewed
import com.ramo.ebuy.data.model.UserSearch
import com.ramo.ebuy.data.model.UserWatchlist
import com.ramo.ebuy.data.util.BaseRepoImp
import com.ramo.ebuy.global.base.SUPA_RECENT_VIEWED
import com.ramo.ebuy.global.base.SUPA_USER_BUY_ITEMS
import com.ramo.ebuy.global.base.SUPA_USER_CART
import com.ramo.ebuy.global.base.SUPA_USER_SEARCH
import com.ramo.ebuy.global.base.SUPA_USER_WATCHLIST
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.query.Order

class UserSearchRepoImp(supabase: SupabaseClient) : BaseRepoImp(supabase), UserSearchRepo {

    override suspend fun getUserSearches(userId: String): List<UserSearch> = queryAllOrder(SUPA_USER_SEARCH) {
        order("last_use", order = Order.DESCENDING)
        filter {
            UserSearch::userId eq userId
        }
    }

    override suspend fun addEditUserSearch(item: UserSearch): UserSearch? = upsert(
        SUPA_USER_SEARCH,
        "id_user_search",
        item
    )

    override suspend fun deleteUserSearch(userId: String): Int = deleteFilter(
        SUPA_USER_SEARCH,
    ) {
        UserSearch::userId eq userId
    }

}

class UserWatchlistRepoImp(supabase: SupabaseClient) : BaseRepoImp(supabase), UserWatchlistRepo {

    override suspend fun getUserWatchlist(id: String): UserWatchlist? = querySingle<UserWatchlist>(SUPA_USER_WATCHLIST) {
        UserWatchlist::userId eq id
    }

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

    override suspend fun getUserBuyItems(id: String): UserBuyItems? = querySingle(SUPA_USER_BUY_ITEMS) {
        UserBuyItems::userId eq id
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
    override suspend fun getUserRecentViewed(id: String): UserRecentViewed? = querySingle(SUPA_RECENT_VIEWED) {
        UserRecentViewed::userId eq id
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


class UserCartRepoImp(supabase: SupabaseClient) : BaseRepoImp(supabase), UserCartRepo {

    override suspend fun getUserCart(id: String): List<UserCart> {
        return query(SUPA_USER_CART) {
            UserCart::userId eq id
        }
    }

    override suspend fun addNewUserCart(item: UserCart): UserCart? {
        return insert(SUPA_USER_CART, item)
    }

    override suspend fun editUserCart(item: UserCart): UserCart? {
        return edit(SUPA_USER_CART, item.id, item)
    }

    override suspend fun deleteUserCart(userId: String): Int {
        return deleteFilter(
            SUPA_USER_CART,
        ) {
            UserCart::userId eq userId
        }
    }
}