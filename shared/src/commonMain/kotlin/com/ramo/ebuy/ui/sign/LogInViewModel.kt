package com.ramo.ebuy.ui.sign

import com.ramo.ebuy.data.model.User
import com.ramo.ebuy.data.util.supabase
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.navigation.BaseViewModel
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

class LogInViewModel(
    project: Project
) : BaseViewModel(project) {

    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    fun setIsRegister(it: Boolean) {
        _uiState.update { state ->
            state.copy(isRegister = it)
        }
    }

    data class State(
        val isErrorPressed: Boolean = false,
        val isRegister: Boolean = false,
    )

}


class LogInEmailViewModel(
    project: Project
) : BaseViewModel(project) {

    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    fun setName(it: String) {
        _uiState.update { state ->
            state.copy(name = it)
        }
    }

    fun setEmail(it: String) {
        _uiState.update { state ->
            state.copy(email = it)
        }
    }

    fun setPassword(it: String) {
        _uiState.update { state ->
            state.copy(password = it)
        }
    }

    private fun setIsProcess(it: Boolean) {
        _uiState.update { state ->
            state.copy(isProcess = it)
        }
    }

    fun createNewUser(invoke: () -> Unit, failed: () -> Unit) {
        uiState.value.let { state ->
            setIsProcess(true)
            launchBack {
                registerAuth(User(name = state.name, email = state.email), state.password, invoke = { user ->
                    signInAuth(state.email, state.password, invoke = {
                        setIsProcess(false)
                        invoke()
                    }, failed)
                }, failed)
            }
        }
    }

    private suspend fun registerAuth(user: User, passwordUser: String, invoke: suspend (User) -> Unit, failed: suspend () -> Unit) {
        supabase {
            project.supaBase.auth.signUpWith(Email) {
                email = user.email
                password = passwordUser
                data = kotlinx.serialization.json.Json.encodeToJsonElement(user).jsonObject.toMutableMap().apply {
                    remove("id")
                }.let(::JsonObject)
            }
            user
        }.let {
            if (it != null) {
                invoke(it)
            } else {
                setIsProcess(false)
                failed()
            }
        }
    }

    fun loginUser(invoke: () -> Unit, failed: () -> Unit) {
        uiState.value.let { state ->
            setIsProcess(true)
            launchBack {
                signInAuth(state.email, state.password, invoke = {
                    setIsProcess(false)
                    invoke()
                }, failed)
            }
        }
    }

    private suspend fun signInAuth(emailUser: String, passwordUser: String, invoke: suspend () -> Unit, failed: suspend () -> Unit) {
        supabase {
            project.supaBase.auth.signInWith(Email) {
                email = emailUser
                password = passwordUser
            }
        }.let {
            if (it != null) {
                invoke()
            } else {
                setIsProcess(false)
                failed()
            }
        }
    }

    /*
    UserBase(
        id = user.id,
        email = user.email,
        name = user.name,
        imageUri = null,
        isBusiness = false,
        isVerified = true
    ).let(::userPref)

    private fun userPref(it: UserBase) {
        project.pref.apply {
            this[PREF_USER_ID] = it.id
            this[PREF_USER_EMAIL] = it.email
            this[PREF_USER_NAME] = it.name
            this[PREF_USER_BUSINESS] = it.isBusiness
            this[PREF_USER_VERIFIED] = it.isVerified
        }
    }*/

    data class State(
        val isProcess: Boolean = false,
        val name: String = "",
        val email: String = "",
        val password: String = "",
    )

}