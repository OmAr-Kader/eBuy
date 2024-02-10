package com.ramo.ebuy.global.navigation

import androidx.compose.runtime.Composable
import com.ramo.ebuy.di.Project
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

@Composable
inline fun <reified T : ViewModel> MokoModel(crossinline builder: () -> T): T {
    return getViewModel(
        key = Unit,
        factory = viewModelFactory(builder)
    )
}

abstract class BaseViewModel(
    protected val project: Project
) : ViewModel(), kotlinx.coroutines.CoroutineScope {

    override val coroutineContext: kotlin.coroutines.CoroutineContext
        get() = kotlinx.coroutines.Dispatchers.Default + kotlinx.coroutines.SupervisorJob() + kotlinx.coroutines.CoroutineExceptionHandler { _, _ -> }

    fun launchBack(
        block: suspend kotlinx.coroutines.CoroutineScope.() -> Unit
    ): Job {

        return launch(kotlinx.coroutines.Dispatchers.Default, kotlinx.coroutines.CoroutineStart.DEFAULT, block)
    }

    fun launchMain(
        block: suspend kotlinx.coroutines.CoroutineScope.() -> Unit
    ): Job {
        return launch(kotlinx.coroutines.Dispatchers.Main.immediate, kotlinx.coroutines.CoroutineStart.DEFAULT, block)
    }

    override fun onCleared() {
        cancel()
        super.onCleared()
    }
}