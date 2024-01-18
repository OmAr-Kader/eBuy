package com.ramo.ebuy

import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.base.PREF_USER_BUSINESS
import com.ramo.ebuy.global.base.PREF_USER_EMAIL
import com.ramo.ebuy.global.base.PREF_USER_ID
import com.ramo.ebuy.global.base.PREF_USER_IMAGE
import com.ramo.ebuy.global.base.PREF_USER_NAME
import com.ramo.ebuy.global.navigation.BaseViewModel
import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppViewModel(
    project: Project
) : BaseViewModel(project) {
    private val _uiState = MutableStateFlow(State(0))
    val uiState = _uiState.asStateFlow()

    fun checkIsUserValid(success: (UserBase) -> Unit, failed: () -> Unit) {
        launchBack {
            project.pref.fetchUserBase()?.let { userBase ->
                success(userBase)
            } ?: launchMain { failed() }
        }
    }

    data class State(
        val counter: Int
    )

}