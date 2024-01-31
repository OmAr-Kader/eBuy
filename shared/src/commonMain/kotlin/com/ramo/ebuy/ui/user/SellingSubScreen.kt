package com.ramo.ebuy.ui.user

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.navigation.MokoModel
import com.ramo.ebuy.global.navigation.Navigator
import com.ramo.ebuy.global.navigation.RootComponent
import org.koin.compose.koinInject

//List an item
@Composable
fun SellingSubScreen(
    navigator: Navigator,
    project: Project = koinInject(),
    theme: Theme = koinInject(),
    viewModel: SellingViewModel = MokoModel { SellingViewModel(project) }
) {
    @Suppress("UNUSED_VARIABLE") val state by viewModel.uiState.collectAsState()
    val scaffoldState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(scaffoldState) {
                Snackbar(it, containerColor = theme.backDarkSec, contentColor = theme.textColor)
            }
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it).background(color = theme.background).verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Selling",
                    modifier = Modifier.padding(horizontal = 10.dp),
                    color = theme.textColor,
                    fontSize = 20.sp,
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth().height(50.dp).padding(horizontal = 5.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = theme.primary,
                        contentColor = theme.textForPrimaryColor,
                    ),
                    border = BorderStroke(
                        width = 0.dp,
                        color = theme.primary,
                    ),
                    onClick = {
                        navigator.navigateTo(RootComponent.Configuration.ProductConditionMainRoute)
                    },
                ) {
                    Text(
                        text = "List an item",
                        color = theme.textForPrimaryColor,
                        fontSize = 18.sp,
                    )
                }
            }
        }
    }
}