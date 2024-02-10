package com.ramo.ebuy

import com.ramo.ebuy.data.model.User
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.navigation.BaseViewModel
import io.github.jan.supabase.gotrue.SessionStatus
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.user.UserSession
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement

class AppViewModel(
    project: Project
) : BaseViewModel(project) {
    private val _uiState = MutableStateFlow(State())
    val uiState = _uiState.asStateFlow()

    fun init() {
        project.supaBase.auth.sessionStatus.onEach {
            _uiState.update { state ->
                state.copy(sessionStatus = it)
            }
        }.launchIn(this)
    }

    fun fetchUser(session: UserSession): User? {
        return session.user?.let {
            it.userMetadata?.let { it1 -> Json.decodeFromJsonElement<User>(it1) }?.copy(id = it.id)
        }
    }

    data class State(
        val sessionStatus: SessionStatus = SessionStatus.LoadingFromStorage,
        val user: User? = null
    )

}