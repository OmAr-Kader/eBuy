package com.ramo.ebuy.data.dataSources.category

import com.ramo.ebuy.data.model.Category

class CategoryData(
    private val repo: CategoryRepo,
) {
    suspend fun getCategories(): List<Category> = repo.getCategories()
    suspend fun addNewCategory(item: Category): Category? = repo.addNewCategory(item)
    suspend fun addNewCategoryList(item: List<Category>): List<Category>? = repo.addNewCategoryList(item)
    suspend fun deleteCato(id: Long): Int = repo.deleteCato(id)
}