package com.ramo.ebuy.android

import androidx.activity.compose.setContent
import com.arkivanov.decompose.retainedComponent

class MainActivity : androidx.activity.ComponentActivity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        val root = retainedComponent {
            com.ramo.ebuy.global.navigation.RootComponent(it)
        }
        setContent {
            com.ramo.ebuy.Main(root)
        }
    }
}
