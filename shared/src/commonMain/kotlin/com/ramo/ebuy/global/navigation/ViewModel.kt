package com.ramo.ebuy.global.navigation

import androidx.compose.runtime.Composable
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.base.PREF_USER_BUSINESS
import com.ramo.ebuy.global.base.PREF_USER_EMAIL
import com.ramo.ebuy.global.base.PREF_USER_ID
import com.ramo.ebuy.global.base.PREF_USER_IMAGE
import com.ramo.ebuy.global.base.PREF_USER_NAME
import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@Composable
inline fun <reified T: ViewModel> MokoModel(crossinline builder: () -> T): T {
    return getViewModel(
        key = Unit,
        factory = viewModelFactory(builder)
    )
}

abstract class BaseViewModel(
    protected val project: Project
) : ViewModel() {

    fun launchBack(
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        return viewModelScope.launch(Dispatchers.Default, CoroutineStart.DEFAULT, block)
    }

    fun launchMain(
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        return viewModelScope.launch(Dispatchers.Main.immediate, CoroutineStart.DEFAULT, block)
    }

    protected fun fetchUserData(success: (UserBase?) -> Unit) {
        launchBack {
            project.pref.fetchUserBase()?.let { userBase ->
                launchMain {
                    success(userBase)
                }
            }
        }
    }

    protected fun Settings.fetchUserBase(): UserBase? {
        val id = get<String>(PREF_USER_ID) ?: return null
        val name = get<String>(PREF_USER_NAME) ?: return null
        val email = get<String>(PREF_USER_EMAIL) ?: return null
        val isBusiness = get<Boolean>(PREF_USER_BUSINESS) ?: return null
        val imageUri = get<String>(PREF_USER_IMAGE) ?: return null
        return UserBase(id = id, name = name, email = email, imageUri = imageUri, isBusiness = isBusiness)
    }

    data class UserBase(
        val id: String,
        val name: String,
        val email: String,
        val imageUri: String,
        val isBusiness: Boolean,
    )
}