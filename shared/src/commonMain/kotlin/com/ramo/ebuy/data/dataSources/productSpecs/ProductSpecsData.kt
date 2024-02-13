package com.ramo.ebuy.data.dataSources.productSpecs

import com.ramo.ebuy.data.model.ProductBaseSpecs

class ProductSpecsData(
    private val repo: ProductSpecsRepo
) {
    suspend fun getProductSpecsOnId(id: Long): ProductBaseSpecs? = repo.getProductSpecsOnId(id)
    suspend fun getProductSpecsOnIdsProduct(ids: List<Long>): List<ProductBaseSpecs> = repo.getProductSpecsOnIdsProduct(ids)
    suspend fun addNewProductSpecs(item: ProductBaseSpecs): ProductBaseSpecs? = repo.addNewProductSpecs(item)
    suspend fun editProductSpecs(item: ProductBaseSpecs): ProductBaseSpecs? = repo.editProductSpecs(item)
    suspend fun deleteProductSpecs(id: Long): Int = repo.deleteProductSpecs(id)
}