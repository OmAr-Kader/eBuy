package com.ramo.ebuy.ui.user

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramo.ebuy.di.Stater
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.navigation.Navigator
import com.ramo.ebuy.global.navigation.RootComponent
import com.ramo.ebuy.global.ui.HotBar
import com.ramo.ebuy.global.ui.OnLaunchScreen
import com.ramo.ebuy.global.ui.OnLaunchScreenScope
import com.ramo.ebuy.global.ui.PagerTab
import com.ramo.ebuy.global.ui.VerticalListSingleTitle
import com.ramo.ebuy.global.ui.VerticalListTitle
import com.ramo.ebuy.global.ui.collapse.CollapsingToolbar
import com.ramo.ebuy.global.ui.collapse.CollapsingToolbarScaffold
import com.ramo.ebuy.global.ui.collapse.ScrollStrategy
import com.ramo.ebuy.global.ui.collapse.rememberCollapsingToolbarScaffoldState
import com.ramo.ebuy.global.ui.collapse.rememberCollapsingToolbarState
import com.ramo.ebuy.global.ui.rememberProfile
import com.ramo.ebuy.global.util.hotBarData
import com.ramo.ebuy.global.util.ifEmptyOrNull
import com.ramo.ebuy.global.util.profileData
import com.ramo.ebuy.global.util.profileIcons
import com.ramo.ebuy.global.util.urlCheckIfEmpty
import com.ramo.ebuy.ui.common.BarMainScreen
import com.ramo.ebuy.ui.common.BarSearchScreen
import com.ramo.ebuy.ui.common.CatoList
import com.ramo.ebuy.ui.common.ProductList
import com.ramo.ebuy.ui.common.ProfileItem
import com.ramo.ebuy.ui.common.SearchBarMainScreen
import com.ramo.ebuy.ui.product.StateProductSelling
import com.seiko.imageloader.rememberImagePainter
import kotlinx.coroutines.launch
import org.koin.compose.koinInject


@Composable
fun HomeSubScreen(
    navigator: Navigator,
    viewModel: HomeViewModel,
    cartSize: Int,
    theme: Theme = koinInject(),
    stater: Stater = koinInject(),
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    val scrollState = rememberCollapsingToolbarScaffoldState()
    val offsetY = scrollState.offsetY
    val catoList = state.circleCato

    OnLaunchScreen {
        viewModel.loadMainData()
    }
    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier.onSizeChanged { size ->
                viewModel.setRepeatableCato(size.width)
            }
        ) {
            Spacer(Modifier.height(56.dp))
            CollapsingToolbarScaffold(
                modifier = Modifier.fillMaxSize(),
                scrollStrategy = ScrollStrategy.EnterAlways,
                state = scrollState,
                toolbar = {
                    CollapsingToolbar(collapsingToolbarState = rememberCollapsingToolbarState()) {
                        Box(
                            Modifier.parallax().road(
                                whenCollapsed = Alignment.CenterStart,
                                whenExpanded = Alignment.CenterStart
                            )
                        ) {
                            SearchBarMainScreen()
                        }
                    }
                }
            ) {
                LazyColumn {
                    HotBar(hotData = hotBarData, theme) {

                    }
                    VerticalListSingleTitle("Explore Popular Categories", theme) {

                    }
                    CatoList(catoList = catoList, repeatableCategory = viewModel.repeatableCategory, repeatableCato = state.repeatableCato) {

                    }
                    VerticalListTitle("Daily Deals", theme) {

                    }
                    ProductList(list = state.productVer) {
                        stater.getScreenCount(RootComponent.Configuration.ProductDetailsRoute::class).let { count ->
                            RootComponent.Configuration.ProductDetailsRoute(it.id, count + 1).also { route ->
                                scope.launch {
                                    stater.writeArguments(route = route, screenCount = count + 1)
                                    navigator.navigateTo(route)
                                }
                            }
                        }
                    }
                }
            }
        }
        BarMainScreen(offsetY, cartSize) {
            stater.getScreenCount(RootComponent.Configuration.CartRoute::class).let { count ->
                RootComponent.Configuration.CartRoute(count + 1).also { route ->
                    scope.launch {
                        stater.writeArguments(route = route, screenCount = count + 1)
                        navigator.navigateTo(route)
                    }
                }
            }
        }
    }
}


@Composable
fun ProfileSubScreen(
    navigator: Navigator,
    viewModel: HomeViewModel,
    cartSize: Int,
    theme: Theme = koinInject(),
    stater: Stater = koinInject(),
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    val painter = state.user?.image.urlCheckIfEmpty?.let {
        rememberImagePainter(url = it)
    }
    OnLaunchScreen {
        viewModel.loadUserData()
    }
    Column(Modifier.fillMaxSize()) {
        BarMainScreen(-112, cartSize) {
            stater.getScreenCount(RootComponent.Configuration.CartRoute::class).let { count ->
                RootComponent.Configuration.CartRoute(count + 1).also { route ->
                    scope.launch {
                        stater.writeArguments(route = route, screenCount = count + 1)
                        navigator.navigateTo(route)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn {
            item {
                Column(
                    modifier = Modifier
                        .padding(15.dp)
                        .clickable {

                        }
                ) {
                    Surface(
                        modifier = Modifier.size(70.dp),
                        color = theme.backDark,
                        shape = CircleShape,
                    ) {
                        painter?.let {
                            Image(
                                modifier = Modifier.size(70.dp).padding(top = 10.dp),
                                painter = it,
                                contentScale = ContentScale.Fit,
                                contentDescription = "",
                            )
                        } ?: run {
                            Image(
                                modifier = Modifier.size(70.dp).padding(top = 10.dp),
                                imageVector = rememberProfile(theme.backDarkSec),
                                contentDescription = "",
                                colorFilter = ColorFilter.tint(theme.backDarkSec)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        modifier = Modifier.padding(),
                        text = state.user?.name.ifEmptyOrNull { state.user?.email ?: "User Name" },
                        color = theme.textColor,
                        fontSize = 16.sp
                    )
                }
            }
            itemsIndexed(profileData) { i, it ->
                ProfileItem(
                    text = it,
                    icon = {
                        i.profileIcons(theme.textGrayColor)
                    },
                ) {
                    scope.launch {
                        navigator.navigateTo(RootComponent.Configuration.WatchListRoute)
                    }
                }
                if (i == 0 || i == 6) {
                    Divider(color = theme.textColor, modifier = Modifier.padding(horizontal = 30.dp))
                }
            }
        }
    }
}

@Composable
fun SearchSubScreen(
    navigator: Navigator,
    viewModel: HomeViewModel,
    theme: Theme = koinInject(),
    stater: Stater = koinInject(),
) {
    val scope = rememberCoroutineScope()
    val state by viewModel.uiState.collectAsState()
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 2 })
    val focusRequester = remember { FocusRequester() }
    OnLaunchScreenScope {
        if (state.isSearchNeedRefresh) {
            viewModel.setIsProcess(true)
            viewModel.loadSearchHistory {
                scope.launch {
                    focusRequester.requestFocus()
                }
            }
        } else {
            focusRequester.requestFocus()
        }
    }

    fun onSearchAction(searchText: String, typeSearch: Int) {
        viewModel.makeIsSearchNeedRefresh()
        stater.getScreenCount(RootComponent.Configuration.SearchProcessRoute::class).let { count ->
            RootComponent.Configuration.SearchProcessRoute(searchText, typeSearch, count + 1).also { route ->
                scope.launch {
                    stater.writeArguments(route = route, screenCount = count + 1)
                    navigator.navigateTo(route)
                }
            }
        }
    }
    Column(Modifier.fillMaxSize()) {
        BarSearchScreen(theme, focusRequester, state.search, viewModel.onSearch) {
            when (it) {
                0 -> {
                    focusRequester.freeFocus()
                    viewModel.setSelectedPage(0)
                }

                1 -> {
                    onSearchAction(state.search, 0)
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        PagerTab(theme, arrayOf("Recent", "Saved"), pagerState, { index ->
            scope.launch {
                pagerState.animateScrollToPage(index)
            }
        }) { screen ->
            if (screen == 0) {
                LazyColumn {
                    items(state.userSearchList) {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onSearchAction(it.search, 0)
                                }
                        ) {
                            Text(
                                modifier = Modifier.padding(start = 30.dp, end = 10.dp, top = 10.dp, bottom = 5.dp),
                                fontSize = 18.sp,
                                text = it.search,
                                color = theme.textColor
                            )
                            Spacer(Modifier.height(5.dp))
                        }
                    }
                    if (state.userSearchList.isNotEmpty()) {
                        item {
                            Row(
                                Modifier
                                    .fillMaxWidth().clickable {

                                    }
                            ) {
                                Text(
                                    modifier = Modifier.padding(start = 30.dp, end = 10.dp, top = 10.dp, bottom = 5.dp),
                                    fontSize = 18.sp,
                                    text = "CLEAR RECENT SEARCHES",
                                    color = theme.primary
                                )
                                Spacer(Modifier.height(5.dp))
                            }
                        }
                    }
                }
            } else {
                LazyColumn {
                    items(state.userSearchSavedList) {
                        Row(
                            Modifier
                            .fillMaxWidth().clickable {
                                onSearchAction(it.search, 1)
                            }
                        ) {
                            Text(
                                modifier = Modifier.padding(start = 30.dp, end = 10.dp, top = 10.dp, bottom = 5.dp),
                                fontSize = 18.sp,
                                text = it.search,
                                color = theme.textColor
                            )
                            Spacer(Modifier.height(5.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SellingSubScreen(
    navigator: Navigator,
    viewModel: HomeViewModel,
    theme: Theme = koinInject(),
    stater: Stater = koinInject(),
) {
    val scope = rememberCoroutineScope()
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
                        scope.launch {
                            stater.stateProductSelling = StateProductSelling()
                            navigator.navigateTo(RootComponent.Configuration.ProductConditionMainRoute)
                        }
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