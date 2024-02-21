package com.ramo.ebuy.data.dataSources.productQuantity

import com.ramo.ebuy.data.model.ProductQuantity

class ProductQuantityData(
    private val repo: ProductQuantityRepo
) {
    suspend fun getProductQuantityOnId(id: Long): ProductQuantity? = repo.getProductQuantityOnId(id)
    suspend fun addNewProductQuantity(item: ProductQuantity): ProductQuantity? = repo.addNewProductQuantity(item)
    suspend fun editProductQuantity(item: ProductQuantity): ProductQuantity? = repo.editProductQuantity(item)
    suspend fun deleteProductQuantity(id: Long): Int = repo.deleteProductQuantity(id)
}