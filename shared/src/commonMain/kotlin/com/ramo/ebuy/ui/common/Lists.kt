package com.ramo.ebuy.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.data.model.Product
import androidx.compose.foundation.lazy.grid.itemsIndexed as itemIndexedGird

@Composable
fun ProductList(list: List<Product>, onClick: (Product) -> Unit) {
    LazyRow {
        items(list) { item ->
            ProductItem(item, onClick)
        }
    }
}

@Composable
fun GridCato(
    list: List<Category>,
    onClick: (Category) -> Unit,
) {
    LazyVerticalGrid(columns = GridCells.Adaptive(150.dp)) {
        itemIndexedGird(list) { i, cato ->
            GridCatoItem(cato, i == list.lastIndex, onClick)
        }
    }
}

@Composable
fun GridCircleCato(
    list: List<Category>,
    onClick: (Category) -> Unit,
) {
    FlowRow(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        repeat(list.size) { i ->
            GridCircleCatoItem(list[i], onClick)
        }
    }
}

@Composable
fun ProductMainSearch(
    list: List<Product>,
    favorite: (Product) -> Unit,
    onClick: (Product) -> Unit,
) {
    LazyColumn {
        items(list) { item ->
            ProductMainSearchItem(item, favorite, onClick)
        }
    }
}

@Composable
fun ExpandableCato(
    id: Int,
    fetchCato: (id: Int, list: (List<Category>) -> Unit) -> Unit
) {
    val list: MutableState<List<Category>?> = remember {
        mutableStateOf(null)
    }
    LaunchedEffect(key1 = Unit) {
        if (list.value == null) {
            fetchCato(id) {
                list.value = it
            }
        }
    }
    list.value?.let { value ->
        LazyColumn(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
            items(value) {
                val isExpanded = remember {
                    mutableStateOf(false)
                }
                ExpandableCatoItem(it.name, isExpanded.value)
                if (it.haveChildren && isExpanded.value) {
                    ExpandableCato(it.id, fetchCato)
                }
            }
        }
    }
}
