package com.ramo.ebuy.data.dataSources.product

import com.ramo.ebuy.data.model.DeliveryProcess
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.model.ProductBaseSpecs

interface ProductRepo {
    suspend fun getProductOnId(id: Long): Product?
    suspend fun getProductOnIdForeign(id: Long, invoke: (Product?, ProductBaseSpecs?, DeliveryProcess?) -> Unit)
    suspend fun getProductsOnCato(ids: Long): List<Product>
    suspend fun getProductsOnIds(ids: List<Long>): List<Product>
    suspend fun getProductsOnSearch(text: String): List<Product>
    suspend fun addNewProduct(item: Product): Product?
    suspend fun editProduct(item: Product): Product?
    suspend fun deleteProduct(id: Long): Int
}