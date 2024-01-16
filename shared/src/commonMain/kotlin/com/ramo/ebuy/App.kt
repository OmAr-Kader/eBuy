package com.ramo.ebuy

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.di.initApp
import com.ramo.ebuy.global.base.MyApplicationTheme
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.navigation.MokoModel
import com.ramo.ebuy.global.navigation.Navigator
import com.ramo.ebuy.global.navigation.RootComponent
import com.ramo.ebuy.global.ui.OnLaunchScreenScope
import com.ramo.ebuy.ui.sign.LogInEmailScreen
import com.ramo.ebuy.ui.sign.LogInScreen
import com.ramo.ebuy.ui.user.HomeUserScreen
import com.ramo.ebuy.ui.user.HomeUserViewModel
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject

@Composable
fun Main(root: RootComponent) {
    KoinApplication(
        application = initApp(isDarkMode = isSystemInDarkTheme())
    ) {
        val childStack by root.childStack.subscribeAsState()
        val theme: Theme = koinInject()
        MyApplicationTheme(theme = theme) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = theme.background
            ) {
                Children(
                    stack = childStack,
                    animation = stackAnimation(slide())
                ) { child ->
                    when (val instance = child.instance) {
                        is RootComponent.Screen.SplashRoute -> SplashScreen(instance.component)
                        is RootComponent.Screen.LogInRoute -> LogInScreen(instance.component)
                        is RootComponent.Screen.LogInEmailRoute -> LogInEmailScreen(instance.component)
                        is RootComponent.Screen.HomeUserRoute -> HomeUserScreen(instance.component)
                    }
                }
            }
        }
    }
}

@Composable
fun SplashScreen(
    navigator: Navigator,
    project: Project = koinInject(),
    viewModel: HomeUserViewModel = MokoModel { HomeUserViewModel(project) },
) {
    val state by viewModel.uiState.collectAsState()
    OnLaunchScreenScope {
        kotlinx.coroutines.delay(1000L)
        kotlinx.coroutines.coroutineScope {
            navigator.navigateTo(RootComponent.Configuration.HomeUserRoute)
        }
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Box(contentAlignment = Alignment.Center) {
            Image(
                modifier = Modifier.width(100.dp),
                painter = painterResource("ebuy.xml"),
                contentDescription = ""
            )
        }
    }
}
