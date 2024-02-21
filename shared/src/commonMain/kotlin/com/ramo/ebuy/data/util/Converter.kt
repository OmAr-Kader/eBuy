package com.ramo.ebuy.data.util

fun List<com.ramo.ebuy.data.model.Category>.rearrange(): List<com.ramo.ebuy.data.model.Category> {
    return onEach { cato ->
        cato.haveChildren = this@rearrange.find {
            cato.id == it.parentCato
        } != null
    }
}

fun MutableList<com.ramo.ebuy.data.model.Product>.refreshFavorites(watchlist: com.ramo.ebuy.data.model.UserWatchlist) {
    this@refreshFavorites.onEach {
        watchlist.watchlist.contains(it.id).also { a ->
            it.isWatchlist = a
        }
    }
}

fun com.ramo.ebuy.data.model.ProductQuantity.rewriteQuantity(): com.ramo.ebuy.data.model.ProductQuantity {
    var realBaseQuantity = 0
    var realAvaBaseQuantity = 0
    this.specsQuantity.onEachIndexed { i, it ->
        it.specExtraQuantity.onEachIndexed { index, productExtraSpecQuantity ->
            productExtraSpecQuantity.specCode = "$i$index"
            realBaseQuantity += productExtraSpecQuantity.specQuantity
            realAvaBaseQuantity += productExtraSpecQuantity.specQuantityAvailable
        }
    }
    return this.copy(baseQuantity = realBaseQuantity, baseQuantityAvailable = realAvaBaseQuantity)
}

fun com.ramo.ebuy.data.model.ProductBaseSpecs.rewriteExtraSpecs(): com.ramo.ebuy.data.model.ProductBaseSpecs {
    this.specsExtra.onEachIndexed { i, it ->
        it.specExtra.onEachIndexed { index, specExtra ->
            specExtra.specCode = "$i$index"
        }
    }
    return this
}