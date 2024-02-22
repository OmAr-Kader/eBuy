package com.ramo.ebuy.ui.common

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.base.outlinedTextFieldStyle
import com.ramo.ebuy.global.ui.rememberArrowBack
import com.ramo.ebuy.global.ui.rememberEbuy
import com.ramo.ebuy.global.ui.rememberMenu
import com.ramo.ebuy.global.ui.rememberMic
import com.ramo.ebuy.global.ui.rememberPhotoCamera
import com.ramo.ebuy.global.ui.rememberSearch
import com.ramo.ebuy.global.ui.rememberShare
import com.ramo.ebuy.global.ui.rememberShoppingCart
import com.ramo.ebuy.global.ui.rememberVoice
import org.koin.compose.koinInject

@Composable
fun BarMainScreen(
    offsetY: Int,
    cartSize: Int,
    theme: Theme = koinInject(),
    onCart: () -> Unit,
) {
    val last = remember {
        mutableFloatStateOf(-150F)
    }
    val position by animateFloatAsState(
        when (offsetY) {
            -112 -> 0F
            0 -> -150F
            else -> last.floatValue
        }, label = "qw"
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(theme.background)
            .padding(start = 15.dp, end = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Image(
            modifier = Modifier
                .height(56.dp),
            imageVector = rememberEbuy(),
            contentScale = ContentScale.Fit,
            contentDescription = null,
        )
        Row {
            Image(
                modifier = Modifier
                    .graphicsLayer {
                        if (position != last.floatValue) {
                            last.floatValue = position
                        }
                        translationY = (position)
                    }
                    .width(40.dp)
                    .height(40.dp)
                    .background(color = theme.backDark, shape = CircleShape)
                    .padding(8.dp),
                imageVector = rememberSearch(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            ShoppingCartItem(cartSize, theme, onCart)
        }
    }
}

@Composable
fun ShoppingCartItem(cartSize: Int, theme: Theme, onClick: () -> Unit) {
    Box {
        Box(Modifier.padding(10.dp)) {
            Image(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .align(Alignment.Center)
                    .background(color = theme.backDark, shape = CircleShape)
                    .clickable(onClick = onClick)
                    .padding(8.dp),
                imageVector = rememberShoppingCart(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
        }
        Box(
            Modifier
                .align(Alignment.TopEnd)
        ) {
            Text(
                text = cartSize.toString(),
                fontSize = 12.sp,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
                    .background(color = Color(red = 155, green = 0, blue = 0), shape = CircleShape),
                color = Color.White,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun BarSearchScreen(
    theme: Theme,
    focusRequester: FocusRequester,
    search: String,
    onSearch: (String) -> Unit,
    onClick: (Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(theme.background)
            .padding(start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
                    .clip(CircleShape)
                    .clickable {
                        onClick(0)
                    }
                    .padding(7.dp),
                imageVector = rememberArrowBack(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
            Spacer(Modifier.width(5.dp))
            TextField(
                modifier = Modifier
                    .weight(1F)
                    .focusRequester(focusRequester),
                value = search,
                onValueChange = onSearch,
                placeholder = {
                    Text("Search On Ebuy", color = theme.textGrayColor)
                },
                maxLines = 1,
                colors = theme.outlinedTextFieldStyle(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go),
                keyboardActions = KeyboardActions(onGo = {
                    onClick(1)
                })
            )
        }
        Row {
            Image(
                modifier = Modifier
                    .clickable {
                        onClick(1)
                    }
                    .width(40.dp)
                    .height(40.dp)
                    .background(color = theme.backDark, shape = CircleShape)
                    .clip(CircleShape)
                    .padding(8.dp),
                imageVector = rememberVoice(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                modifier = Modifier
                    .clickable {
                        onClick(2)
                    }
                    .width(40.dp)
                    .height(40.dp)
                    .background(color = theme.backDark, shape = CircleShape)
                    .clip(CircleShape)
                    .padding(8.dp),
                imageVector = rememberPhotoCamera(theme.textColor),
                colorFilter = ColorFilter.tint(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
        }
    }
}


@Composable
fun BarSearchProcess(
    theme: Theme,
    search: String,
    cartSize: Int,
    onClick: (Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(theme.background)
            .padding(start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
                    .clip(CircleShape)
                    .clickable {
                        onClick(0)
                    }
                    .padding(7.dp),
                imageVector = rememberArrowBack(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
            Spacer(Modifier.width(5.dp))
            Text(search, color = theme.textColor, fontSize = 22.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
        }
        Row {
            Image(
                modifier = Modifier
                    .clickable {
                        onClick(1)
                    }
                    .width(40.dp)
                    .height(40.dp)
                    .background(color = theme.backDark, shape = CircleShape)
                    .clip(CircleShape)
                    .padding(8.dp),
                imageVector = rememberSearch(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            ShoppingCartItem(cartSize, theme) {
                onClick(2)
            }
        }
    }
}

@Composable
fun BarProductScreen(
    cartSize: Int,
    theme: Theme = koinInject(),
    onClick: (Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(theme.background)
            .padding(start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
                    .clip(CircleShape)
                    .clickable {
                        onClick(0)
                    }
                    .padding(7.dp),
                imageVector = rememberArrowBack(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
            Spacer(Modifier.width(5.dp))
            Text("Item", color = theme.textColor, fontSize = 22.sp)
        }
        Row {
            Image(
                modifier = Modifier
                    .clickable {
                        onClick(1)
                    }
                    .width(40.dp)
                    .height(40.dp)
                    .background(color = theme.backDark, shape = CircleShape)
                    .clip(CircleShape)
                    .padding(8.dp),
                imageVector = rememberSearch(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            ShoppingCartItem(cartSize, theme) {
                onClick(2)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                modifier = Modifier
                    .clickable {
                        onClick(3)
                    }
                    .width(40.dp)
                    .height(40.dp)
                    .background(color = theme.backDark, shape = CircleShape)
                    .clip(CircleShape)
                    .padding(8.dp),
                imageVector = rememberShare(theme.textColor),
                colorFilter = ColorFilter.tint(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                modifier = Modifier
                    .clickable {
                        onClick(4)
                    }
                    .width(40.dp)
                    .height(40.dp)
                    .background(color = theme.backDark, shape = CircleShape)
                    .clip(CircleShape)
                    .padding(8.dp),
                imageVector = rememberMenu(theme.textColor),
                colorFilter = ColorFilter.tint(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
        }
    }
}


@Composable
fun BarWatchListScreen(
    cartSize: Int,
    theme: Theme = koinInject(),
    onClick: (Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(theme.background)
            .padding(start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
                    .clip(CircleShape)
                    .clickable {
                        onClick(0)
                    }
                    .padding(7.dp),
                imageVector = rememberArrowBack(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
            Spacer(Modifier.width(5.dp))
            Text("WatchList", color = theme.textColor, fontSize = 22.sp)
        }
        Row {
            Image(
                modifier = Modifier
                    .clickable {
                        onClick(1)
                    }
                    .width(40.dp)
                    .height(40.dp)
                    .background(color = theme.backDark, shape = CircleShape)
                    .clip(CircleShape)
                    .padding(8.dp),
                imageVector = rememberSearch(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            ShoppingCartItem(cartSize, theme) {
                onClick(2)
            }
        }
    }
}

@Composable
fun BarCartScreen(
    theme: Theme = koinInject(),
    onBack: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(theme.background)
            .padding(start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
                    .clip(CircleShape)
                    .clickable {
                        onBack()
                    }
                    .padding(7.dp),
                imageVector = rememberArrowBack(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
            Spacer(Modifier.width(5.dp))
            Text("eBuy shopping cart", color = theme.textColor, fontSize = 22.sp)
        }
    }
}

@Composable
fun SearchBarMainScreen(
    theme: Theme = koinInject(),
    height: Dp = 56.dp,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .padding(start = 25.dp, end = 25.dp, top = 5.dp, bottom = 5.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(width = 1.dp, color = theme.backDark),
        color = theme.backGreyTrans
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1F),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(45.dp)
                        .height(45.dp)
                        .padding(8.dp),
                    imageVector = Icons.Default.Search,
                    colorFilter = ColorFilter.tint(theme.textColor),
                    contentScale = ContentScale.Fit,
                    contentDescription = null,
                )
                Text(
                    modifier = Modifier
                        .weight(1F)
                        .padding(start = 10.dp, end = 10.dp),
                    text = "Search on eBuy",
                    color = theme.textColor,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Image(
                modifier = Modifier
                    .width(45.dp)
                    .height(45.dp)
                    .padding(8.dp),
                imageVector = rememberMic(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
            Image(
                modifier = Modifier
                    .width(45.dp)
                    .height(45.dp)
                    .padding(8.dp),
                imageVector = rememberPhotoCamera(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
        }
    }
}
