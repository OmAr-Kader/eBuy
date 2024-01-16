package com.ramo.ebuy.ui.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.NavigationBar
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramo.ebuy.di.Project
import com.ramo.ebuy.global.base.Theme
import com.ramo.ebuy.global.navigation.MokoModel
import com.ramo.ebuy.global.navigation.Navigator
import com.ramo.ebuy.global.ui.AddItem
import com.ramo.ebuy.global.ui.HotBar
import com.ramo.ebuy.global.ui.VerticalListSingleTitle
import com.ramo.ebuy.global.ui.VerticalListTitle
import com.ramo.ebuy.global.ui.collapse.CollapsingToolbar
import com.ramo.ebuy.global.ui.collapse.CollapsingToolbarScaffold
import com.ramo.ebuy.global.ui.collapse.ScrollStrategy
import com.ramo.ebuy.global.ui.collapse.rememberCollapsingToolbarScaffoldState
import com.ramo.ebuy.global.ui.collapse.rememberCollapsingToolbarState
import com.ramo.ebuy.global.ui.rememberProfile
import com.ramo.ebuy.global.util.bottomBarData
import com.ramo.ebuy.global.util.hotBarData
import com.ramo.ebuy.global.util.profileData
import com.ramo.ebuy.global.util.profileIcons
import com.ramo.ebuy.ui.common.BarMainScreen
import com.ramo.ebuy.ui.common.GridCircleCato
import com.ramo.ebuy.ui.common.ProductList
import com.ramo.ebuy.ui.common.ProfileItem
import com.ramo.ebuy.ui.common.SearchBarMainScreen
import org.koin.compose.koinInject

@Composable
fun HomeUserScreen(
    navigator: Navigator,
    project: Project = koinInject(),
    theme: Theme = koinInject(),
    viewModel: HomeUserViewModel = MokoModel { HomeUserViewModel(project) }
) {
    val state by viewModel.uiState.collectAsState()
    val scaffoldState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(scaffoldState) {
                Snackbar(it, containerColor = theme.backDarkSec, contentColor = theme.textColor)
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = theme.backDark,
                contentColor = theme.textGrayColor
            ) {
                bottomBarData.forEachIndexed { i, item ->
                    AddItem(
                        screen = item,
                        i,
                        state.selectedPage == i,
                    ) {
                        viewModel.setSelectedPage(it)
                    }
                }
            }
        }
    ) {
        Box(Modifier.padding(it)) {
            when (state.selectedPage) {
                0 -> HomeScreen(viewModel)
                1 -> ProfileScreen()
            }
        }
    }
}

@Composable
fun HomeScreen(
    //navigator: Navigator,
    viewModel: HomeUserViewModel,
) {
    val state by viewModel.uiState.collectAsState()
    val scrollState = rememberCollapsingToolbarScaffoldState()
    val offsetY = scrollState.offsetY // y offset of the layout

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
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
                    item {
                        HotBar(hotData = hotBarData) {

                        }
                    }
                    item {
                        VerticalListSingleTitle("Explore Popular Categories") {

                        }
                    }
                    item {
                        GridCircleCato(list = state.circleCato) {

                        }
                    }
                    item {
                        VerticalListTitle("Daily Deals") {

                        }
                    }
                    item {
                        ProductList(list = state.productVer) {

                        }
                    }
                }
            }
        }
        BarMainScreen(offsetY)
    }
}


@Composable
fun ProfileScreen(
    //navigator: Navigator,
    theme: Theme = koinInject()
) {
    Column(Modifier.fillMaxSize()) {
        BarMainScreen(-112)
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
                        Image(
                            modifier = Modifier.size(70.dp).padding(top = 10.dp),
                            imageVector = rememberProfile(theme.backDarkSec),
                            contentDescription = "",
                            colorFilter = ColorFilter.tint(theme.backDarkSec)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(modifier = Modifier.padding(), text = "User Name", color = theme.textColor, fontSize = 16.sp)
                }
            }
            itemsIndexed(profileData) { i, it ->
                ProfileItem(
                    text = it,
                    icon = {
                        i.profileIcons(theme.textGrayColor)
                    },
                ) {

                }
                if (i == 0 || i == 6) {
                    Divider(color = theme.textColor, modifier = Modifier.padding(horizontal = 30.dp))
                }
            }
        }
    }
}

