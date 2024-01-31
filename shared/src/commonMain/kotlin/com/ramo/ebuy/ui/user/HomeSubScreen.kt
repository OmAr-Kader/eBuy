package com.ramo.ebuy.ui.user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import com.ramo.ebuy.global.ui.HotBar
import com.ramo.ebuy.global.ui.VerticalListSingleTitle
import com.ramo.ebuy.global.ui.VerticalListTitle
import com.ramo.ebuy.global.ui.collapse.CollapsingToolbar
import com.ramo.ebuy.global.ui.collapse.CollapsingToolbarScaffold
import com.ramo.ebuy.global.ui.collapse.ScrollStrategy
import com.ramo.ebuy.global.ui.collapse.rememberCollapsingToolbarScaffoldState
import com.ramo.ebuy.global.ui.collapse.rememberCollapsingToolbarState
import com.ramo.ebuy.global.util.hotBarData
import com.ramo.ebuy.ui.common.BarMainScreen
import com.ramo.ebuy.ui.common.GridCircleCatoItem
import com.ramo.ebuy.ui.common.ProductList
import com.ramo.ebuy.ui.common.SearchBarMainScreen


@Composable
fun HomeSubScreen(
    //navigator: Navigator,
    viewModel: HomeViewModel,
) {
    val state by viewModel.uiState.collectAsState()
    val scrollState = rememberCollapsingToolbarScaffoldState()
    val offsetY = scrollState.offsetY // y offset of the layout
    val catoList = state.circleCato

    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier.onSizeChanged {  size ->
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
                    item {
                        HotBar(hotData = hotBarData) {

                        }
                    }
                    item {
                        VerticalListSingleTitle("Explore Popular Categories") {

                        }
                    }
                    items(viewModel.repeatableCategory) { i ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val w = i * state.repeatableCato
                            repeat(state.repeatableCato) { sub ->
                                GridCircleCatoItem(catoList[w + sub]) {}
                            }
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

