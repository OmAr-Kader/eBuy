package com.ramo.ebuy.data.dataSources.product

import com.ramo.ebuy.data.model.Product

interface ProductRepo {
    suspend fun getProductOnId(id: Long): Product?
    suspend fun getProductsOnCato(catoId: Long): List<Product>
    suspend fun addNewProduct(item: Product): Product?
    suspend fun editProduct(item: Product): Product?
    suspend fun deleteProduct(id: Long): Int
}