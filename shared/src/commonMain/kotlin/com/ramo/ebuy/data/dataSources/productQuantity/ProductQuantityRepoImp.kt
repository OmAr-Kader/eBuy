package com.ramo.ebuy.data.dataSources.productQuantity

import com.ramo.ebuy.data.model.ProductQuantity
import com.ramo.ebuy.data.util.BaseRepoImp
import com.ramo.ebuy.global.base.SUPA_PRODUCT_QUANTITY
import io.github.jan.supabase.SupabaseClient

class ProductQuantityRepoImp(supabase: SupabaseClient) : BaseRepoImp(supabase), ProductQuantityRepo {
    override suspend fun getProductQuantityOnId(id: Long): ProductQuantity? {
        return querySingle(SUPA_PRODUCT_QUANTITY) {
            ProductQuantity::productId eq id
        }
    }

    override suspend fun addNewProductQuantity(item: ProductQuantity): ProductQuantity? {
        return insert(SUPA_PRODUCT_QUANTITY, item)
    }

    override suspend fun editProductQuantity(item: ProductQuantity): ProductQuantity? {
        return edit(SUPA_PRODUCT_QUANTITY, item.id, item)
    }

    override suspend fun deleteProductQuantity(id: Long): Int {
        return delete(SUPA_PRODUCT_QUANTITY, id)
    }
}