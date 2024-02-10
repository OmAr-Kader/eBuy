package com.ramo.ebuy.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.data.model.Product
import androidx.compose.foundation.lazy.grid.itemsIndexed as itemIndexedGird

fun LazyListScope.CatoList(catoList: List<Category>, repeatableCategory: Int, repeatableCato: Int, onClick: (Category) -> Unit) {
    items(repeatableCategory) { i ->
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val w = i * repeatableCato
            repeat(repeatableCato) { sub ->
                GridCircleCatoItem(catoList[w + sub], onClick)
            }
        }
    }
}

fun LazyListScope.ProductList(list: List<Product>, onClick: (Product) -> Unit) = item {
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

    LazyVerticalGrid(
        columns = GridCells.Adaptive(100.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        items(list.size) { i ->
            GridCircleCatoItem(list[i], onClick = onClick)
        }
    }
    /*FlowRow(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        repeat(list.size) { i ->
            GridCircleCatoItem(list[i], onClick)
        }
    }*/
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
    id: Long,
    list: List<Category>,
    productCato: List<String>,
    onClick: (Category) -> Unit,
) {
    var isShow = remember {
        mutableStateMapOf<Long, Boolean>()
    }
    val fetchCato = { iD: Long ->
        list.toMutableList().filter { it.parentId == iD }
    }
    LaunchedEffect(key1 = Unit) {
        isShow = isShow.apply {
            list.associate { item ->
                item.id to false
            }.also { map ->
                putAll(map)
            }
        }
    }
    LazyColumn(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
        ExpandableCatoList(id, productCato, 5, isShow, onClick, fetchCato)
    }
}


fun LazyListScope.ExpandableCatoList(
    id: Long,
    productCato: List<String>,
    padding: Int,
    isShow: SnapshotStateMap<Long, Boolean>,
    onClick: (Category) -> Unit,
    fetchCato: (id: Long) -> List<Category>
) {
    fetchCato(id).forEach {
        val isExpand = isShow[it.id] == true
        item(it.id) {
            Column(Modifier.padding(horizontal = (padding + 5).dp, vertical = 2.dp)) {
                ExpandableCatoItem(it.name, productCato.find { c -> c == it.name } != null, haveChildren = it.haveChildren, isExpand, onClick = {
                    onClick(it)
                }) { bool ->
                    isShow[it.id] = !bool
                }
            }
        }
        if (it.haveChildren && isExpand) {
            ExpandableCatoList(it.id, productCato, (padding + 5), isShow, onClick, fetchCato)
        }
    }
}
