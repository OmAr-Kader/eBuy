package com.ramo.ebuy.data.dataSources.productQuantity

import com.ramo.ebuy.data.model.ProductQuantity

interface ProductQuantityRepo {
    suspend fun getProductQuantityOnId(id: Long): ProductQuantity?
    suspend fun addNewProductQuantity(item: ProductQuantity): ProductQuantity?
    suspend fun editProductQuantity(item: ProductQuantity): ProductQuantity?
    suspend fun deleteProductQuantity(id: Long): Int
}