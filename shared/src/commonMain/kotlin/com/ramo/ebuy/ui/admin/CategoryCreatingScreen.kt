package com.ramo.ebuy.ui.admin

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.preat.peekaboo.image.picker.SelectionMode
import com.preat.peekaboo.image.picker.rememberImagePickerLauncher
import com.preat.peekaboo.image.picker.toImageBitmap
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.base.outlinedTextFieldStyle
import com.ramo.ebuy.global.navigation.MokoModel
import com.ramo.ebuy.global.navigation.Navigator
import com.ramo.ebuy.global.ui.LoadingScreen
import com.ramo.ebuy.global.ui.OnLaunchScreenScope
import com.ramo.ebuy.global.ui.SheetBottomTitle
import com.ramo.ebuy.global.ui.rememberAdd
import com.ramo.ebuy.global.ui.rememberCorrect
import com.ramo.ebuy.global.ui.rememberDeleteForever
import com.ramo.ebuy.global.ui.rememberEdit
import com.ramo.ebuy.global.ui.rememberFindReplace
import com.ramo.ebuy.ui.common.ExpandableCato
import com.ramo.ebuy.ui.product.ProductSellingSpecsHeadBarBack
import com.seiko.imageloader.rememberImagePainter
import com.skydoves.flexible.bottomsheet.material3.FlexibleBottomSheet
import com.skydoves.flexible.core.FlexibleSheetSize
import com.skydoves.flexible.core.rememberFlexibleBottomSheetState
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
    val singleImagePicker = rememberImagePickerLauncher(
        selectionMode = SelectionMode.Single,
        scope = scope,
        onResult = { byteArrays ->
            byteArrays.firstOrNull()?.let { viewModel.setCategoryImage(it) }
        }
    )
    val str = "Add ${(if (state.currentCategory == null) "New" else "Sub")} Category"
    OnLaunchScreenScope {
        viewModel.loadCategories()
    }
    Scaffold(
        bottomBar = {
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
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                    state.currentCategory?.let {
                        Button(
                            onClick = {
                                viewModel.setModeModalBottom(1)
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = theme.secondary)
                        ) {
                            Image(
                                modifier = Modifier
                                    .width(25.dp)
                                    .height(25.dp)
                                    .padding(3.dp),
                                imageVector = rememberEdit(Color.White),
                                contentDescription = "Icon"
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = "Edit",
                                color = Color.White,
                                fontSize = 18.sp
                            )
                        }
                    }
                    Button(
                        onClick = {
                            viewModel.setModeModalBottom(0)
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = theme.primary)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp)
                                .padding(3.dp),
                            imageVector = rememberAdd(theme.textForPrimaryColor),
                            contentDescription = "Icon"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = str,
                            color = theme.textForPrimaryColor,
                            fontSize = 18.sp
                        )
                    }
                }
            }
            ExpandableCato(-1, state.categories, state.parentCategories) {
                viewModel.setCategory(it)
            }
        }
        if (state.modeModalBottom != -1) {
            FlexibleBottomSheet(
                onDismissRequest = {
                    viewModel.setModeModalBottom(-1)
                },
                sheetState = rememberFlexibleBottomSheetState(
                    flexibleSheetSize = FlexibleSheetSize(
                        fullyExpanded = 0.9F,
                        intermediatelyExpanded = 0.9F,
                        slightlyExpanded = 0.9F,
                    ),
                    isModal = true,
                    skipSlightlyExpanded = false,
                ),
                dragHandle = {
                    SheetBottomTitle(
                        if (state.modeModalBottom == 1) "Edit this Category" else (str),
                        theme
                    )
                },
                containerColor = theme.backDark,
                contentColor = theme.textColor,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CategoryImage(state.newCategoryImage, if (state.modeModalBottom == 0) null else state.currentCategory?.imageUri, theme) {
                        singleImagePicker.launch()
                    }
                }
                Spacer(Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = state.newCategory,
                        onValueChange = { change ->
                            viewModel.setNewCategory(change)
                        },
                        shape = RoundedCornerShape(25.dp),
                        label = {
                            Text(str + (if (state.currentCategory == null) "" else "For ${state.currentCategory?.name}"), color = theme.textGrayColor)
                        },
                        maxLines = 1,
                        colors = theme.outlinedTextFieldStyle(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    )
                }
                Spacer(Modifier.height(25.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                    if (state.modeModalBottom == 1) {
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
                    Button(
                        onClick = {
                            if (state.modeModalBottom == 1) {
                                viewModel.editCategory()
                            } else {
                                viewModel.addNewCategory()
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp)
                                .padding(3.dp),
                            imageVector = rememberCorrect(Color.Black),
                            contentDescription = "Icon"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Save",
                            color = Color.Black,
                            fontSize = 18.sp
                        )
                    }
                }
                Spacer(Modifier.height(25.dp))
            }
        }
        LoadingScreen(state.isProcess, theme)
    }
}


@Composable
fun RowScope.CategoryImage(newCategoryImage: ByteArray?, imageUrl: String?, theme: Theme, invoke: () -> Unit) {
    newCategoryImage?.also { byte ->
        Column(Modifier.wrapContentSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = theme.backDark),
                bitmap = byte.toImageBitmap(),
                contentScale = ContentScale.Fit,
                contentDescription = "Product",
            )
            Image(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .background(color = theme.backDark, shape = CircleShape)
                    .clickable {
                        invoke()
                    }
                    .padding(8.dp),
                imageVector = rememberFindReplace(theme.textGrayColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
        }
    } ?: run {
        imageUrl?.let { url ->
            Column(Modifier.wrapContentSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                val painter = rememberImagePainter(url = url)
                Image(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .padding(5.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(color = theme.backDark),
                    painter = painter,
                    contentScale = ContentScale.Fit,
                    contentDescription = "Product",
                )
                Image(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .background(color = theme.backDark, shape = CircleShape)
                        .clickable {
                            invoke()
                        }
                        .padding(8.dp),
                    imageVector = rememberFindReplace(theme.textGrayColor),
                    contentScale = ContentScale.Fit,
                    contentDescription = null,
                )
            }
        } ?: run {
            Column(Modifier.wrapContentSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                Surface(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clickable {
                            invoke()
                        }
                        .padding(start = 5.dp, end = 5.dp, top = 5.dp, bottom = 5.dp),
                    color = Color.Transparent,
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(0.5.dp, color = theme.textHintColor)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                    ) {
                        Image(
                            modifier = Modifier
                                .size(30.dp),
                            imageVector = rememberAdd(color = theme.primary),
                            contentScale = ContentScale.Fit,
                            contentDescription = "Product Image",
                        )
                    }
                }
                Spacer(Modifier.height(40.dp))
            }
        }
    }
}