package com.ramo.ebuy.data.dataSources.productSpecs

import com.ramo.ebuy.data.model.ProductBaseSpecs

interface ProductSpecsRepo {

    suspend fun getProductSpecsOnId(id: Long): ProductBaseSpecs?
    suspend fun addNewProductSpecs(item: ProductBaseSpecs): ProductBaseSpecs?
    suspend fun editProductSpecs(item: ProductBaseSpecs): ProductBaseSpecs?
    suspend fun deleteProductSpecs(id: Long): Int
}