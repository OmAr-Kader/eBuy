package com.ramo.ebuy.data.util

import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.model.UserWatchlist

fun List<com.ramo.ebuy.data.model.Category>.rearrange(): List<com.ramo.ebuy.data.model.Category> {
    return onEach { cato ->
        cato.haveChildren = this@rearrange.find {
            cato.id == it.parentCato
        } != null
    }
}

fun MutableList<Product>.refreshFavorites(watchlist: UserWatchlist) {
    this@refreshFavorites.onEach {
        watchlist.watchlist.contains(it.id).also { a ->
            it.isWatchlist = a
        }
    }
}