package com.ramo.ebuy.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Category(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("image_uri")
    val imageUri: String,
    @SerialName("cato_type")
    val catoType: Int,
    @SerialName("parent_cato")
    val parentId: Int,
) {
    var haveChildren: Boolean = false
}
