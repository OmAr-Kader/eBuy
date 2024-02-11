package com.ramo.ebuy.data.dataSources.productSpecs

import com.ramo.ebuy.data.model.ProductBaseSpecs
import com.ramo.ebuy.data.util.BaseRepoImp
import com.ramo.ebuy.global.base.SUPA_PRODUCT_SPECS
import io.github.jan.supabase.SupabaseClient

class ProductSpecsRepoImp(supabase: SupabaseClient) : BaseRepoImp(supabase), ProductSpecsRepo {
    override suspend fun getProductSpecsOnId(id: Long): ProductBaseSpecs? = querySingle(SUPA_PRODUCT_SPECS) {
        ProductBaseSpecs::productId eq id
    }

    override suspend fun addNewProductSpecs(item: ProductBaseSpecs): ProductBaseSpecs? = insert(SUPA_PRODUCT_SPECS, item)

    override suspend fun editProductSpecs(item: ProductBaseSpecs): ProductBaseSpecs? = edit(SUPA_PRODUCT_SPECS, item.id, item)

    override suspend fun deleteProductSpecs(id: Long): Int = delete(SUPA_PRODUCT_SPECS, id)

}