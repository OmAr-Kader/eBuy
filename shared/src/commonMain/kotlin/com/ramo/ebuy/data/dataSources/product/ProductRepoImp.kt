package com.ramo.ebuy.data.dataSources.product

import com.ramo.ebuy.data.model.DeliveryProcess
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.model.ProductBaseSpecs
import com.ramo.ebuy.data.util.BaseRepoImp
import com.ramo.ebuy.data.util.toListOfObject
import com.ramo.ebuy.global.base.SUPA_DELIVERY_PROCESS
import com.ramo.ebuy.global.base.SUPA_PRODUCT
import com.ramo.ebuy.global.base.SUPA_PRODUCT_SPECS
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.query.filter.TextSearchType

class ProductRepoImp(supabase: SupabaseClient) : BaseRepoImp(supabase), ProductRepo {

    override suspend fun getProductOnId(id: Long): Product? = querySingle(SUPA_PRODUCT) {
        Product::id eq id
    }

    override suspend fun getProductOnIdForeign(id: Long, invoke: (Product?, ProductBaseSpecs?, DeliveryProcess?) -> Unit) {
        querySingleByForeign(SUPA_PRODUCT, Columns.raw("*, $SUPA_PRODUCT_SPECS(), $SUPA_DELIVERY_PROCESS()")) {
            Product::id eq id
        }?.apply {
            invoke(
                toListOfObject<Product>()?.firstOrNull().let { if (it == Product()) null else it },
                toListOfObject<ProductBaseSpecs>()?.firstOrNull().let { if (it == ProductBaseSpecs()) null else it },
                toListOfObject<DeliveryProcess>()?.firstOrNull().let { if (it == DeliveryProcess()) null else it }
            )
        } ?: invoke(null, null, null)
    }

    override suspend fun getProductsOnCato(ids: Long): List<Product> = query<Product>(SUPA_PRODUCT) {
        Product::parentCatoId eq ids
    }

    override suspend fun getProductsOnIds(ids: List<Long>): List<Product> = query<Product>(SUPA_PRODUCT) {
        Product::id isIn ids
    }

    override suspend fun getProductsOnSearch(text: String): List<Product> {
        return queryByForeign<Product>(
            SUPA_PRODUCT,
            Columns.raw("*, $SUPA_PRODUCT_SPECS(*)"),
        ) {
            or {
                like("${SUPA_PRODUCT_SPECS}.sub_title", "%${text}%")
                like("${SUPA_PRODUCT_SPECS}.description", "%${text}%")
            }
            or {
                textSearch(column = "title", query = text, textSearchType = TextSearchType.WEBSEARCH)
                Product::title like "%${text}%"
                textSearch(column = "condition", query = text, textSearchType = TextSearchType.WEBSEARCH)
                Product::condition like "%${text}%"
                Product::categoriesSearch like "%${text}%"
            }
        }
    }

    override suspend fun addNewProduct(item: Product): Product? = insert(SUPA_PRODUCT, item)

    override suspend fun editProduct(item: Product): Product? = edit(SUPA_PRODUCT, item.id, item)

    override suspend fun deleteProduct(id: Long): Int = delete(SUPA_PRODUCT, id)
}