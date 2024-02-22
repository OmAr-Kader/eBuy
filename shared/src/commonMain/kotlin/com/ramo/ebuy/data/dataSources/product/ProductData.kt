package com.ramo.ebuy.data.dataSources.product

import com.ramo.ebuy.data.model.DeliveryProcess
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.model.ProductBaseSpecs
import com.ramo.ebuy.data.model.ProductQuantity

class ProductData(
    private val repo: ProductRepo
) {
    suspend fun getProductOnId(id: Long): Product? = repo.getProductOnId(id)
    suspend fun getProductOnIdForeign(id: Long, invoke: (Product?, ProductBaseSpecs?, ProductQuantity?, DeliveryProcess?) -> Unit) {
        repo.getProductOnIdForeign(id, invoke)
    }
    suspend fun getProductsOnCato(catoId: Long): List<Product> = repo.getProductsOnCato(catoId)
    suspend fun getProductsOnIds(ids: List<Long>): List<Product> = repo.getProductsOnIds(ids)
    suspend fun getProductsOnSearch(text: String): List<Product> = repo.getProductsOnSearch(text)
    suspend fun addNewProduct(item: Product): Product? = repo.addNewProduct(item)
    suspend fun editProduct(item: Product): Product? = repo.editProduct(item)
    suspend fun deleteProduct(id: Long): Int = repo.deleteProduct(id)
}