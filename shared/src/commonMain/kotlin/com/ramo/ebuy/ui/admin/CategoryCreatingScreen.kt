package com.ramo.ebuy.ui.admin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darkrockstudios.libraries.mpfilepicker.FilePicker
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.navigation.MokoModel
import com.ramo.ebuy.global.navigation.Navigator
import com.ramo.ebuy.global.ui.LoadingScreen
import com.ramo.ebuy.global.ui.OnLaunchScreen
import com.ramo.ebuy.global.ui.rememberDeleteForever
import com.ramo.ebuy.ui.common.ExpandableCato
import com.ramo.ebuy.ui.product.ProductSellingSpecsHeadBarBack
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun CategoryCreatingScreen(
    navigator: Navigator,
    theme: Theme = koinInject(),
    project: Project = koinInject(),
    viewModel: CategoryCreatingViewModel = MokoModel {
        CategoryCreatingViewModel(project)
    }
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    OnLaunchScreen {
        viewModel.loadCategories()
    }
    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                //.align(Alignment.BottomCenter)
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    //enabled = isEnabled,
                    shape = RoundedCornerShape(8.dp),
                    label = {
                        Text("Add New Sub Category For ${(state.currentCategory?.name ?: "")}", color = theme.textGrayColor)
                    },
                    trailingIcon = {
                        IconButton(
                            modifier = Modifier
                                .width(50.dp)
                                .height(50.dp)
                                .align(Alignment.CenterVertically)
                                .padding(5.dp)
                                .background(
                                    color = theme.backDark,
                                    shape = CircleShape
                                ),
                            onClick = {
                                viewModel.addNewCategory()
                            }
                        ) {
                            Icon(
                                Icons.Filled.Add,
                                contentDescription = "",
                            )
                        }
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = theme.backDark,
                        unfocusedContainerColor = theme.backDark,
                    ),
                    value = state.newCategory,
                    onValueChange = { change ->
                        viewModel.setNewCategory(change)
                    },
                    singleLine = false
                )
            }

        }
    ) { pad ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pad)
                .background(color = theme.background)
        ) {
            ProductSellingSpecsHeadBarBack("Add New Category", theme) {
                scope.launch {
                    navigator.goBack()
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    Modifier
                        .defaultMinSize(minHeight = 70.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                ) {
                    Text(modifier = Modifier.width(130.dp), text = "In Category", color = theme.textGrayColor)
                    Text(state.currentCategory?.name ?: "", color = theme.textColor)
                }
                Row {
                    Button(
                        onClick = {
                            state.currentCategory?.id?.let { viewModel.deleteCategory(it) }
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = theme.error)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp)
                                .padding(3.dp),
                            imageVector = rememberDeleteForever(Color.White),
                            contentDescription = "Icon"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Delete",
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                }
            }
            ExpandableCato(-1, state.categories, state.parentCategories) {
                viewModel.setCategory(it)
            }
        }
        FilePicker(state.isShowPicker, fileExtensions = listOf("jpg", "png", "webp", "mpeg", "heic", "heif", "hevc")) { file ->
            file?.platformFile?.toString()?.let { viewModel.setCategoryImage(it) } ?: viewModel.setIsShowPicker(false)
        }
        LoadingScreen(state.isProcess, theme)
    }
}