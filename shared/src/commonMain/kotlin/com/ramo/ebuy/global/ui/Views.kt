package com.ramo.ebuy.global.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.ColorUtils
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.util.bottomBarIcons
import com.ramo.ebuy.global.util.hotBarIcons
import com.seiko.imageloader.rememberImagePainter
import org.koin.compose.koinInject

@Composable
fun OnLaunchScreen(invoke: () -> Unit) {
    val isLaunched = remember {
        mutableStateOf(false)
    }
    if (!isLaunched.value) {
        isLaunched.value = true
        invoke.invoke()
    }
}

@Composable
fun OnLaunchScreenScope(invoke: suspend kotlinx.coroutines.CoroutineScope.() -> Unit) {
    val isLaunched = remember {
        mutableStateOf(false)
    }
    if (!isLaunched.value) {
        isLaunched.value = true
        LaunchedEffect(key1 = isLaunched, block = invoke)
    }
}


@Composable
fun CardButton(
    onClick: (() -> Unit),
    text: String,
    width: Dp = 80.dp,
    height: Dp = 30.dp,
    curve: Dp = height / 2,
    fontSize: TextUnit = 11.sp,
    color: Color,
    textColor: Color
) {
    Card(
        modifier = Modifier
            .width(width)
            .height(height)
            .padding(top = 5.dp, start = 5.dp, end = 5.dp),
        shape = RoundedCornerShape(curve),
        onClick = onClick,
        colors = CardDefaults.cardColors(color),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = text,
                color = textColor,
                fontSize = fontSize,
                //fontWeight = FontWeight.Thin,
                style = MaterialTheme.typography.titleSmall,
                maxLines = 1,
            )
        }
    }
}


@Composable
fun HotBar(
    hotData: List<String>,
    theme: Theme = koinInject(),
    onClick: (Int) -> Unit
) {
    LazyRow(contentPadding = PaddingValues(5.dp)) {
        itemsIndexed(hotData) { i, it ->
            Surface(
                modifier = Modifier.padding(5.dp),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(width = 1.dp, color = theme.backDarkSec),
                color = theme.backGreyTrans
            ) {
                Row(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, top = 3.dp, bottom = 3.dp)
                        .clickable {
                            onClick(i)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .width(25.dp)
                            .height(25.dp)
                            .padding(3.dp),
                        imageVector = i.hotBarIcons,
                        colorFilter = ColorFilter.tint(color = theme.textColor),
                        contentDescription = "Icon"
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = it,
                        color = theme.textColor
                    )
                }
            }
        }
    }
}

@Composable
fun ScrollableBar(
    background: Color = MaterialTheme.colorScheme.background,
    height: Dp = 56.dp,
    content: @Composable (() -> Unit),
) {
    Surface {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .background(color = background),
        ) {
            content()
        }
    }
}


@Composable
fun VerticalListTitle(
    title: String,
    theme: Theme = koinInject(),
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(50.dp).padding(start = 15.dp, end = 15.dp).clickable {
            onClick()
        },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1F),
            text = title,
            color = theme.textColor,
            fontSize = 25.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = "See all",
            color = theme.textColor,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textDecoration = TextDecoration.Underline,
        )
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
fun VerticalListSingleTitle(
    title: String,
    theme: Theme = koinInject(),
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(50.dp).padding(start = 15.dp, end = 15.dp).clickable {
            onClick()
        },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1F),
            text = title,
            color = theme.textColor,
            fontSize = 25.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}


@Composable
fun VerticalListTitleWithSub(
    title: String,
    subTitle: String,
    theme: Theme = koinInject(),
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(50.dp).padding(start = 15.dp, end = 15.dp).clickable {
            onClick()
        },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1F)) {
            Text(
                text = title,
                color = theme.textColor,
                fontSize = 25.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                modifier = Modifier.weight(1F),
                text = subTitle,
                color = theme.textColor,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Text(
            text = "See all",
            color = theme.textColor,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textDecoration = TextDecoration.Underline,
        )
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
fun RowScope.AddItem(
    screen: String,
    index: Int,
    isSelected: Boolean,
    theme: Theme = koinInject(),
    onClick: (Int) -> Unit
) {
    NavigationBarItem(
        label = {
            Text(text = screen)
        },
        icon = {
            Icon(
                modifier = Modifier.size(25.dp),
                imageVector = index.bottomBarIcons,
                contentDescription = screen,
                //tint = theme.pri
            )
        },
        selected = isSelected,
        alwaysShowLabel = true,
        onClick = {
            onClick(index)
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = theme.pri,
            selectedTextColor = theme.pri,
            indicatorColor = Color(34, 40, 52),
            unselectedIconColor = theme.textGrayColor,
            unselectedTextColor = theme.textGrayColor
        )
    )
}


@Composable
fun ImagesPageView(
    list: List<String>,
    size: DpSize
) {
    val pagerState = rememberPagerState(pageCount = { list.size })
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(13.dp))
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.size(size)
                .background(MaterialTheme.colorScheme.background)
                .clip(RoundedCornerShape(20.dp)),
        ) {
            val painter = rememberImagePainter(url = list[it])
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentScale = ContentScale.Crop,
                contentDescription = "",
            )
        }
        Spacer(modifier = Modifier.height(13.dp))
        DotsIndicator(
            totalDots = pagerState.pageCount,
            selectedIndex = pagerState.currentPage,
            selectedColor = MaterialTheme.colorScheme.secondary,
            unSelectedColor = Color(
                ColorUtils.setAlphaComponent(
                    MaterialTheme.colorScheme.secondary.toArgb(),
                    150
                )
            )
        )
    }
}

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color,
    unSelectedColor: Color,
) {
    LazyRow(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()

    ) {

        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(selectedColor)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(unSelectedColor)
                )
            }
            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}