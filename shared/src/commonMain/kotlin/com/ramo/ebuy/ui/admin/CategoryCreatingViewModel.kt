package com.ramo.ebuy.ui.admin

import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.data.supaBase.deleteFile
import com.ramo.ebuy.data.supaBase.uploadFile
import com.ramo.ebuy.data.util.rearrange
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.base.SUPA_STORAGE_CATO
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
                    state.copy(categories = it, isProcess = false)
                }
            }
        }
    }

    fun setCategory(it: Category) {
        val catoList = mutableListOf(it)
        uiState.value.categories.toMutableList().reversed().map { cato ->
            val e = cato.id == it.id || catoList.find { c -> c.parentCato == cato.id } != null
            if (e) {
                catoList.add(cato)
            }
            e
        }
        _uiState.update { state ->
            state.copy(parentCategories = catoList.distinct().map { it.name }.toTypedArray(), currentCategory = it)
        }
    }

    fun setNewCategory(it: String) {
        _uiState.update { state ->
            state.copy(newCategory = it)
        }
    }

    fun addNewCategory() {
        val imageByte = uiState.value.newCategoryImage
        if (imageByte == null) {
            setIsLoading(false)
            return
        }
        setIsLoading(true)
        uiState.value.let {
            Category(name = it.newCategory, parentCato = it.currentCategory?.id ?: -1)
        }.also { newCato ->
            launchBack {
                userInfo()?.let { user ->
                    project.supaBase.uploadFile(SUPA_STORAGE_CATO, user.id, imageByte) { newImage ->
                        project.categoryData.addNewCategory(newCato.copy(imageUri = newImage)).let {
                            if (it != null) {
                                uiState.value.categories.toMutableList().apply { add(it) }.rearrange().also { catos ->
                                    _uiState.update { state ->
                                        state.copy(categories = catos, newCategory = "", isProcess = false, modeModalBottom = -1)
                                    }
                                }
                            } else {
                                setIsLoading(false)
                            }
                        }
                    }
                }
            }
        }
    }

    fun editCategory() {
        val imageByte = uiState.value.newCategoryImage
        if (imageByte == null) {
            setIsLoading(false)
            return
        }
        setIsLoading(true)
        uiState.value.let {
            it.currentCategory?.copy(name = it.newCategory)
        }?.also { newCato ->
            checkCategoryImage(newCato.imageUri) { newImage ->
                launchBack {
                    project.categoryData.editCategory(newCato.copy(imageUri = newImage ?: newCato.imageUri)).let {
                        if (it != null) {
                            uiState.value.categories.toMutableList().apply { add(it) }.rearrange().also { catos ->
                                _uiState.update { state ->
                                    state.copy(categories = catos, newCategory = "", isProcess = false, modeModalBottom = -1)
                                }
                            }
                        } else {
                            setIsLoading(false)
                        }
                    }
                }
            }
        }
    }

    private fun checkCategoryImage(imageUrl: String, invoke: (String?) -> Unit) {
        val imageByte = uiState.value.newCategoryImage
        if (imageByte != null) {
            launchBack {
                userInfo()?.let { user ->
                    project.supaBase.uploadFile(SUPA_STORAGE_CATO, user.id, imageByte) { newImage ->
                        project.supaBase.deleteFile(SUPA_STORAGE_CATO, listOf(imageUrl)) {
                            invoke(newImage)
                        }
                    }
                }
            }
        } else {
            invoke(null)
        }
    }

    fun deleteCategory(id: Long) {
        setIsLoading(true)
        launchBack {
            uiState.value.categories.indexOfFirst { it.id == id }.let { i ->
                project.categoryData.deleteCato(id).let { d ->
                    if (d == 1) {
                        uiState.value.categories.toMutableList().apply { removeAt(i) }.rearrange().also { catos ->
                            _uiState.update { state ->
                                state.copy(categories = catos, newCategory = "", dummy = state.dummy + 1, isProcess = false)
                            }
                        }
                    } else {
                        setIsLoading(false)
                    }
                }
            }
        }
    }

    private fun setIsLoading(it: Boolean) {
        _uiState.update { state ->
            state.copy(isProcess = it)
        }
    }

    fun setModeModalBottom(it: Int) {
        _uiState.update { state ->
            when (it) {
                1 -> {
                    (state.currentCategory?.name ?: "")
                }
                0 -> {
                    ""
                }
                else -> {
                    ""
                }
            }.let { catoName ->
                state.copy(modeModalBottom = it, newCategory =  catoName, newCategoryImage = null)
            }
        }
    }

    fun setCategoryImage(it: ByteArray) {
        _uiState.update { state ->
            state.copy(newCategoryImage = it)
        }
    }

    data class State(
        val isProcess: Boolean = true,
        val categories: List<Category> = listOf(),
        val parentCategories: Array<String> = arrayOf(),
        val currentCategory: Category? = null,
        val newCategory: String = "",
        val newCategoryImage: ByteArray? = null,
        val modeModalBottom: Int = -1,
        val dummy: Int = 0,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as State

            if (isProcess != other.isProcess) return false
            if (categories != other.categories) return false
            if (!parentCategories.contentEquals(other.parentCategories)) return false
            if (currentCategory != other.currentCategory) return false
            if (newCategory != other.newCategory) return false
            if (newCategoryImage != null) {
                if (other.newCategoryImage == null) return false
                if (!newCategoryImage.contentEquals(other.newCategoryImage)) return false
            } else if (other.newCategoryImage != null) return false
            if (modeModalBottom != other.modeModalBottom) return false
            return dummy == other.dummy
        }

        override fun hashCode(): Int {
            var result = isProcess.hashCode()
            result = 31 * result + categories.hashCode()
            result = 31 * result + parentCategories.contentHashCode()
            result = 31 * result + (currentCategory?.hashCode() ?: 0)
            result = 31 * result + newCategory.hashCode()
            result = 31 * result + (newCategoryImage?.contentHashCode() ?: 0)
            result = 31 * result + modeModalBottom
            result = 31 * result + dummy
            return result
        }

    }

}