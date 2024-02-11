package com.ramo.ebuy.data.dataSources.product

import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.util.BaseRepoImp
import com.ramo.ebuy.global.base.SUPA_PRODUCT
import io.github.jan.supabase.SupabaseClient

class ProductRepoImp(supabase: SupabaseClient) : BaseRepoImp(supabase), ProductRepo {

    override suspend fun getProductOnId(id: Long): Product? = querySingle(SUPA_PRODUCT) {
        Product::id eq id
    }

    override suspend fun getProductsOnCato(catoId: Long): List<Product> = query<Product>(SUPA_PRODUCT) {
        Product::parentCato eq catoId
    }

    override suspend fun addNewProduct(item: Product): Product? = insert(SUPA_PRODUCT, item)

    override suspend fun editProduct(item: Product): Product? = edit(SUPA_PRODUCT, item.id, item)

    override suspend fun deleteProduct(id: Long): Int = delete(SUPA_PRODUCT, id)
}