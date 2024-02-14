package com.ramo.ebuy.data.dataSources.product

import com.ramo.ebuy.data.model.Product

class ProductData(
    private val repo: ProductRepo
) {
    suspend fun getProductOnId(id: Long): Product? = repo.getProductOnId(id)
    suspend fun getProductsOnCato(catoId: Long): List<Product> = repo.getProductsOnCato(catoId)
    suspend fun getProductsOnIds(ids: List<Long>): List<Product> = repo.getProductsOnIds(ids)
    suspend fun getProductsOnSearch(text: String): List<Product> = repo.getProductsOnSearch(text)
    suspend fun addNewProduct(item: Product): Product? = repo.addNewProduct(item)
    suspend fun editProduct(item: Product): Product? = repo.editProduct(item)
    suspend fun deleteProduct(id: Long): Int = repo.deleteProduct(id)
}