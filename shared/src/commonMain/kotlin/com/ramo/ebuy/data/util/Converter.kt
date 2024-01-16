package com.ramo.ebuy.data.util

fun List<com.ramo.ebuy.data.model.Category>.rearrange() {
    onEach { cato ->
        cato.haveChildren = this@rearrange.find {
            cato.id == it.parentId
        } != null
    }
}