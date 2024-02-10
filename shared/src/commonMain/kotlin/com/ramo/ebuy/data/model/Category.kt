package com.ramo.ebuy.data.model

import com.ramo.ebuy.data.util.BaseObject
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

@Serializable
data class Category(
    @SerialName("id")
    val id: Long = 0,
    @SerialName("name")
    val name: String = "",
    @SerialName("image_uri")
    val imageUri: String = "",
    @SerialName("cato_type")
    val catoType: Int = 0,
    @SerialName("parent_cato")
    val parentId: Long = -1,
): BaseObject() {
    var haveChildren: Boolean = false
    override fun json(): JsonObject {
        return buildJsonObject {
            put("name", name)
            put("image_uri", imageUri)
            put("cato_type", catoType)
            put("parent_cato", parentId)
        }
    }
}
