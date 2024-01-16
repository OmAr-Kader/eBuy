package com.ramo.ebuy

import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.base.PREF_USER_BUSINESS
import com.ramo.ebuy.global.base.PREF_USER_EMAIL
import com.ramo.ebuy.global.base.PREF_USER_ID
import com.ramo.ebuy.global.base.PREF_USER_NAME
import com.ramo.ebuy.global.navigation.BaseViewModel
import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppViewModel(
    private val project: Project
) : BaseViewModel() {
    private val _uiState = MutableStateFlow(State(0))
    val uiState = _uiState.asStateFlow()

    fun checkIsUserValid(success: (UserBase) -> Unit, failed: () -> Unit) {
        launchBack {
            project.pref.fetchUserBase()?.let { userBase ->
                success(userBase)
            } ?: launchMain { failed() }
        }
    }
    private fun Settings.fetchUserBase(): UserBase? {
        val id = get<String>(PREF_USER_ID) ?: return null
        val name = get<String>(PREF_USER_NAME) ?: return null
        val email = get<String>(PREF_USER_EMAIL) ?: return null
        val isBusiness = get<Boolean>(PREF_USER_BUSINESS) ?: return null
        return UserBase(id = id, name = name, email = email, isBusiness = isBusiness)
    }

    data class UserBase(
        val id: String,
        val name: String,
        val email: String,
        val isBusiness: Boolean,
    )

    data class State(
        val counter: Int
    )

}