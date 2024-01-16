package com.ramo.ebuy.ui.common

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.ui.rememberMic
import com.ramo.ebuy.global.ui.rememberPhotoCamera
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@Composable
fun BarMainScreen(
    offsetY: Int,
    theme: Theme = koinInject(),
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
            painter = painterResource("ebuy.xml"),
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
                imageVector = Icons.Default.Search,
                colorFilter = ColorFilter.tint(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .background(color = theme.backDark, shape = CircleShape)
                    .padding(8.dp),
                imageVector = Icons.Default.ShoppingCart,
                colorFilter = ColorFilter.tint(theme.textColor),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
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
