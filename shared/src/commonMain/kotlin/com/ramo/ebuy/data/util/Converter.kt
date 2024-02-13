package com.ramo.ebuy.data.util

fun List<com.ramo.ebuy.data.model.Category>.rearrange(): List<com.ramo.ebuy.data.model.Category> {
    return onEach { cato ->
        cato.haveChildren = this@rearrange.find {
            cato.id == it.parentCato
        } != null
    }
}