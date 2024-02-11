package com.ramo.ebuy.data.dataSources.category

import com.ramo.ebuy.data.model.Category

interface CategoryRepo {

    suspend fun getCategories(): List<Category>
    suspend fun addNewCategory(item: Category): Category?
    suspend fun deleteCato(id: Long): Int
}