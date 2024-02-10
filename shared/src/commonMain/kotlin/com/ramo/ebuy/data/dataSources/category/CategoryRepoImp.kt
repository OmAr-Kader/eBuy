package com.ramo.ebuy.data.dataSources.category

import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.data.util.BaseRepoImp
import com.ramo.ebuy.global.base.SUPA_CATO
import io.github.jan.supabase.SupabaseClient

class CategoryRepoImp(supabase: SupabaseClient) : BaseRepoImp(supabase), CategoryRepo {
    override suspend fun getCategories(): List<Category> = queryAll<Category>(SUPA_CATO)

    override suspend fun addNewCategory(item: Category): Category? = insert(SUPA_CATO, item)

    override suspend fun addNewCategoryList(item: List<Category>): List<Category>? = insertList(SUPA_CATO, item)

    override suspend fun deleteCato(id: Long): Int = delete(SUPA_CATO, id)

}