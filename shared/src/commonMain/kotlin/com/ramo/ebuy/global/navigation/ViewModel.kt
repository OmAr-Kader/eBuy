package com.ramo.ebuy.global.navigation

import androidx.compose.runtime.Composable
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

@Composable
inline fun <reified T: ViewModel> MokoModel(crossinline builder: () -> T): T {
    return getViewModel(
        key = Unit,
        factory = viewModelFactory(builder)
    )
}

abstract class BaseViewModel : ViewModel() {

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
}