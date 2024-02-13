package com.ramo.ebuy.data.dataSources.category

import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.data.util.BaseRepoImp
import com.ramo.ebuy.global.base.SUPA_CATO
import io.github.jan.supabase.SupabaseClient

class CategoryRepoImp(supabase: SupabaseClient) : BaseRepoImp(supabase), CategoryRepo {
    override suspend fun getCategories(): List<Category> = queryAll<Category>(SUPA_CATO)

    override suspend fun getMainCategories(): List<Category> {
        return query<Category>(SUPA_CATO) {
            Category::parentCato eq -1
        }
    }

    override suspend fun addNewCategory(item: Category): Category? = insert(SUPA_CATO, item)
    override suspend fun editCategory(item: Category): Category? = edit(SUPA_CATO, item.id, item)
    override suspend fun deleteCato(id: Long): Int = delete(SUPA_CATO, id)

}