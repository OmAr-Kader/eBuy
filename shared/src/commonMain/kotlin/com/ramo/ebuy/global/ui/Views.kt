package com.ramo.ebuy.global.ui

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.util.bottomBarIcons
import com.ramo.ebuy.global.util.hotBarIcons
import com.seiko.imageloader.rememberImagePainter
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

//@Composable
fun Modifier.fillWidthIfZero(/*@FloatRange(from = 0.0, to = 1.0)*/ size: DpSize) =
    this.then(if (size.width == 0.dp) fillMaxWidth().height(size.height) else size(size))

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
fun LoadingScreen(
    isLoading: Boolean,
    theme: Theme,
) {
    if (isLoading) {
        Surface(
            modifier = Modifier.fillMaxSize().clickable {  },
            color = theme.backDarkAlpha
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier,
                    color = theme.primary,
                )
            }
        }
    } else return
}

@Composable
fun <S> AnimatedText(
    targetState: S,
    content: @Composable AnimatedContentScope.(targetState: S) -> Unit
) {
    androidx.compose.animation.AnimatedContent(
        targetState = targetState,
        transitionSpec = {
            fadeIn(animationSpec = tween(durationMillis = 500)) togetherWith
                    fadeOut(animationSpec = tween(durationMillis = 500))
        },
        contentAlignment = Alignment.Center,
        label = "$targetState",
        content = content
    )
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


fun LazyListScope.HotBar(
    hotData: List<String>,
    theme: Theme,
    onClick: (Int) -> Unit
) = item {
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

fun LazyListScope.VerticalListTitle(
    title: String,
    theme: Theme,
    onClick: () -> Unit,
) = item {
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

fun LazyListScope.VerticalListSingleTitle(
    title: String,
    theme: Theme,
    onClick: () -> Unit,
) = item {
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
    list: Array<String>,
    size: DpSize,
    theme: Theme = koinInject(),
    onClick: (Int) -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { list.size })
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(theme.background),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(13.dp))
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillWidthIfZero(size)
                .background(theme.background)
                .clip(RoundedCornerShape(20.dp)),
        ) {
            val painter = rememberImagePainter(url = list[it])
            Image(
                modifier = Modifier.fillMaxSize().clickable {
                    onClick(it)
                },
                painter = painter,
                contentScale = ContentScale.Crop,
                contentDescription = "",
            )
        }
        Spacer(modifier = Modifier.height(13.dp))
        DotsIndicator(
            totalDots = pagerState.pageCount,
            selectedIndex = pagerState.currentPage,
            selectedColor = theme.textHintColor,
            unSelectedColor = theme.textHintAlpha
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
            Box(
                modifier = Modifier
                    .size(7.dp)
                    .clip(CircleShape)
                    .background(if (index == selectedIndex) selectedColor else unSelectedColor)
            )
            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

//https://github.com/DogusTeknoloji/compose-date-picker
@Composable
fun CalendarYearView(
    selectedYear: Int,
    minYear: Int,
    maxYear: Int,
    theme: Theme,
    setYear: (Int) -> Unit,
) {
    val years = IntRange(minYear, maxYear).toList().reversed()
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val selectedIndex = years.indexOf(selectedYear)
    LazyColumn(
        state = listState,
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(years) { year ->
            Text(text = year.toString(),
                fontSize = if (year == selectedYear) 35.sp else 30.sp,
                color = if (year == selectedYear) theme.primary else theme.textColor,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .clickable {
                        setYear(year)
                    })
        }
        scope.launch {
            listState.animateScrollToItem(selectedIndex)
        }
    }
}

@Composable
fun TextPickerView(
    selectedYear: Int,
    minYear: Int,
    maxYear: Int,
    themeColor: Color,
    setYear: (Int) -> Unit,
) {
    val years = IntRange(minYear, maxYear).toList().reversed()
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val selectedIndex = years.indexOf(selectedYear)
    LazyColumn(
        state = listState,
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(years) { year ->
            Text(text = year.toString(),
                fontSize = if (year == selectedYear) 35.sp else 30.sp,
                color = if (year == selectedYear) themeColor else Color.Black,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .clickable {
                        setYear(year)
                    })
        }
        scope.launch {
            listState.animateScrollToItem(selectedIndex)
        }
    }
}

/*
@Composable
fun LayoutMeasure(
    onSize: (Size) -> Unit,
    mainContent: @Composable () -> Unit,
) {
    val dimensionScope = remember{DimensionScopeImpl()}

    Layout(
        modifier = Modifier.fillMaxWidth(),
        content = mainContent
    ) { measurables: List<Measurable>, constraints: Constraints ->
        val placeables = measurables.map { measurable: Measurable ->
            measurable.measure(constraints)
        }
        val maxWidth = placeables.maxOf { it.width }
        val maxHeight = placeables.maxOf { it.height }
        val size = Size(maxWidth.toFloat(), maxHeight.toFloat())
        if (dimensionScope.size.width != size.width) {
            dimensionScope.size = size
            onSize(dimensionScope.size)
        }
        layout(maxWidth, maxHeight) {
            placeables.forEach { placeable: Placeable ->
                placeable.placeRelative(0, 0)
            }
        }
    }
}

interface DimensionScope {
    var size: Size
}
class DimensionScopeImpl(override var size: Size = Size.Zero) : DimensionScope
*/