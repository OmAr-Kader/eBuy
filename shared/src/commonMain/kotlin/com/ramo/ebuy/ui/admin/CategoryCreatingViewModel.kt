package com.ramo.ebuy.ui.admin

import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.data.util.rearrange
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.navigation.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CategoryCreatingViewModel(
    project: Project
) : BaseViewModel(project) {
    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    fun loadCategories() {
        launchBack {
            project.categoryData.getCategories().rearrange().let {
                _uiState.update { state ->
                    state.copy(categories = it)
                }
            }
        }
    }

    fun setCategory(it: Category) {
        val catoList = mutableListOf(it)
        uiState.value.categories.toMutableList().reversed().map { cato ->
            val e = cato.id == it.id || catoList.find { c -> c.parentId == cato.id } != null
            if (e) {
                catoList.add(cato)
            }
            e
        }
        _uiState.update { state ->
            state.copy(parentCategories = catoList.distinct().map { it.name }, currentCategory = it)
        }
    }

    fun setNewCategory(it: String) {
        _uiState.update { state ->
            state.copy(newCategory = it)
        }
    }

    fun addNewCategory() {
        uiState.value.let {
            Category(name = it.newCategory, parentId = it.currentCategory?.id ?: -1)
        }.also { newCato ->
            launchBack {
                project.categoryData.addNewCategory(newCato).let {
                    if (it != null) {
                        uiState.value.categories.toMutableList().apply { add(it) }.rearrange().also { catos ->
                            _uiState.update { state ->
                                state.copy(categories = catos, newCategory = "")
                            }
                        }
                    }
                }
            }
        }
    }

    fun deleteCategory(id: Long) {
        launchBack {
            uiState.value.categories.indexOfFirst { it.id == id }.let { i ->
                project.categoryData.deleteCato(id).let { d ->
                    if (d == 1) {
                        uiState.value.categories.toMutableList().apply { removeAt(i) }.rearrange().also { catos ->
                            _uiState.update { state ->
                                state.copy(categories = catos, newCategory = "", dummy = state.dummy + 1)
                            }
                        }
                    }
                }
            }
        }
    }

    data class State(
        val categories: List<Category> = emptyList(),
        val parentCategories: List<String> = emptyList(),
        val currentCategory: Category? = null,
        val newCategory: String = "",
        val dummy: Int = 0,
    )

}