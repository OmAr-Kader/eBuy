package com.ramo.ebuy.ui.sign

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.base.outlinedTextFieldStyle
import com.ramo.ebuy.global.navigation.MokoModel
import com.ramo.ebuy.global.navigation.Navigator
import com.ramo.ebuy.global.navigation.RootComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@OptIn(ExperimentalResourceApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LogInScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
) {
    val scaffoldState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(scaffoldState) {
                Snackbar(it, containerColor = theme.backDarkSec, contentColor = theme.textColor)
            }
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize().background(color = theme.background).verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Sign in",
                    modifier = Modifier.padding(horizontal = 50.dp),
                    color = theme.textColor,
                    fontSize = 25.sp,
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Hello",
                    modifier = Modifier.padding(horizontal = 20.dp),
                    color = theme.textColor,
                    fontSize = 35.sp,
                )
                Text(
                    text = "You can use your email or username, or continue with your social account",
                    modifier = Modifier.padding(horizontal = 20.dp),
                    color = theme.textColor,
                    fontSize = 14.sp,
                )
            }
            Spacer(modifier = Modifier.weight(1.0f))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column(
                    modifier = Modifier
                        .width(300.dp),
                ) {
                    OutlinedButton(
                        modifier = Modifier.fillMaxWidth().height(50.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = theme.primary,
                            contentColor = theme.textForPrimaryColor,
                        ),
                        border = BorderStroke(
                            width = 0.dp,
                            color = theme.primary,
                        ),
                        onClick = {
                            navigator.navigateTo(RootComponent.Configuration.LogInEmailRoute)
                        },
                    ) {
                        Text(
                            text = "Use email and password",
                            color = theme.textForPrimaryColor,
                            fontSize = 18.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedButton(
                        modifier = Modifier.fillMaxWidth().height(50.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color(240, 240, 240),
                            contentColor = Color.Black,
                        ),
                        border = BorderStroke(
                            width = 0.dp,
                            color = Color(240, 240, 240),
                        ),
                        onClick = {

                        },
                    ) {
                        Row {
                            Image(painterResource("google.xml"), null, modifier = Modifier.width(20.dp).height(20.dp))
                            Spacer(modifier = Modifier.width(35.dp))
                            Text(
                                text = "continue with Google",
                                color = Color.Black,
                                fontSize = 18.sp,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedButton(
                        modifier = Modifier.fillMaxWidth().height(50.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color(3, 155, 229),
                            contentColor = Color.White,
                        ),
                        border = BorderStroke(
                            width = 1.5.dp,
                            color = Color(3, 155, 229),
                        ),
                        onClick = {

                        },
                    ) {
                        Row {
                            Image(painterResource("facebook.xml"), null, modifier = Modifier.width(20.dp).height(20.dp))
                            Spacer(modifier = Modifier.width(35.dp))
                            Text(
                                text = "continue with Facebook",
                                color = Color.White,
                                fontSize = 18.sp,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedButton(
                        modifier = Modifier.fillMaxWidth().height(50.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color.Transparent,
                            contentColor = theme.textColor,
                        ),
                        border = BorderStroke(
                            width = 1.5.dp,
                            color = theme.primary,
                        ),
                        onClick = {

                        },
                    ) {
                        Text(
                            text = "Create an account",
                            color = theme.textColor,
                            fontSize = 18.sp,
                        )
                    }
                }
            }
        }
    }
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LogInEmailScreen(
    navigator: Navigator,
    project: Project = koinInject(),
    theme: Theme = koinInject(),
    viewModel: LogInViewModel = MokoModel { LogInViewModel(project) }
) {
    val state by viewModel.uiState.collectAsState()
    val scaffoldState = remember { SnackbarHostState() }

    val isEmailOrPasswordEmpty = state.email.isEmpty() || state.password.isEmpty()
    Scaffold(
        snackbarHost = {
            SnackbarHost(scaffoldState) {
                Snackbar(it, containerColor = theme.backDarkSec, contentColor = theme.textColor)
            }
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize().background(color = theme.background).verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Sign in",
                    modifier = Modifier.padding(horizontal = 50.dp),
                    color = theme.textColor,
                    fontSize = 25.sp,
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Welcome",
                    modifier = Modifier.padding(horizontal = 20.dp),
                    color = theme.textColor,
                    fontSize = 35.sp,
                )
                Spacer(modifier = Modifier.height(30.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Column(
                        modifier = Modifier
                            .width(300.dp),
                    ) {
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = state.email,
                            onValueChange = {
                                viewModel.setEmail(it)
                            },
                            shape = RoundedCornerShape(12.dp),
                            placeholder = { Text(text = "Enter Email", fontSize = 14.sp) },
                            label = { Text(text = "Email", fontSize = 14.sp) },
                            maxLines = 1,
                            colors = theme.outlinedTextFieldStyle(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        )
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = state.password,
                            onValueChange = {
                                viewModel.setPassword(it)
                            },
                            shape = RoundedCornerShape(12.dp),
                            placeholder = { Text(text = "Enter Password") },
                            label = { Text(text = "Password") },
                            maxLines = 1,
                            colors = theme.outlinedTextFieldStyle(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        OutlinedButton(
                            modifier = Modifier.fillMaxWidth().height(50.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                containerColor = theme.primary,
                                disabledContainerColor = theme.backDark
                            ),
                            enabled = !isEmailOrPasswordEmpty,
                            border = BorderStroke(
                                width = 0.dp,
                                color = if (isEmailOrPasswordEmpty) theme.backDark else theme.primary,
                            ),
                            onClick = {
                                navigator.navigateTo(RootComponent.Configuration.HomeUserRoute)
                            },
                        ) {
                            Text(
                                text = "Sign in",
                                color = if (isEmailOrPasswordEmpty) theme.backDarkSec else theme.textForPrimaryColor,
                                fontSize = 18.sp,
                            )
                        }
                    }
                }
            }
        }
    }
}

