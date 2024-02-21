package com.ramo.ebuy.data.dataSources.product

import com.ramo.ebuy.data.model.DeliveryProcess
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.data.model.ProductBaseSpecs
import com.ramo.ebuy.data.model.ProductQuantity
import com.ramo.ebuy.data.util.BaseRepoImp
import com.ramo.ebuy.data.util.toListOfObject
import com.ramo.ebuy.global.base.SUPA_DELIVERY_PROCESS
import com.ramo.ebuy.global.base.SUPA_PRODUCT
import com.ramo.ebuy.global.base.SUPA_PRODUCT_QUANTITY
import com.ramo.ebuy.global.base.SUPA_PRODUCT_SPECS
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.query.filter.TextSearchType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class ProductRepoImp(supabase: SupabaseClient) : BaseRepoImp(supabase), ProductRepo {

    override suspend fun getProductOnId(id: Long): Product? = querySingle(SUPA_PRODUCT) {
        Product::id eq id
    }

    override suspend fun getProductOnIdForeign(id: Long, invoke: (Product?, ProductBaseSpecs?, ProductQuantity?, DeliveryProcess?) -> Unit) {
        querySingleByForeign(SUPA_PRODUCT, Columns.raw("*, $SUPA_PRODUCT_SPECS(*), $SUPA_PRODUCT_QUANTITY(*), $SUPA_DELIVERY_PROCESS(*)")) {
            Product::id eq id
        }?.apply {
            toListOfObject<Result>(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            })?.firstOrNull().let { result ->
                invoke(
                    toListOfObject<Product>(kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true
                    })?.firstOrNull().let { if (it == Product()) null else it },
                    result?.productsSpecs?.firstOrNull()?.let { if (it == ProductBaseSpecs()) null else it },
                    result?.productQuantity?.firstOrNull()?.let { if (it == ProductQuantity()) null else it },
                    result?.deliveryProcess?.firstOrNull()?.let { if (it == DeliveryProcess()) null else it },
                )
            }

        } ?: invoke(null, null, null, null)
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


    @Serializable
    data class Result(
        @SerialName("products_specs") val productsSpecs: List<ProductBaseSpecs> = emptyList(),
        @SerialName("product_quantity") val productQuantity: List<ProductQuantity> = emptyList(),
        @SerialName("delivery_process") val deliveryProcess: List<DeliveryProcess> = emptyList(),
    )
}
