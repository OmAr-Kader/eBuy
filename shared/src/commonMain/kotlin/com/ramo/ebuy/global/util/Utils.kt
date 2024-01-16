package com.ramo.ebuy.global.util

import androidx.compose.ui.graphics.Color
import com.ramo.ebuy.data.model.Category
import com.ramo.ebuy.data.model.Product
import com.ramo.ebuy.global.ui.rememberBid
import com.ramo.ebuy.global.ui.rememberFavorite
import com.ramo.ebuy.global.ui.rememberHelp
import com.ramo.ebuy.global.ui.rememberHome
import com.ramo.ebuy.global.ui.rememberLightning
import com.ramo.ebuy.global.ui.rememberMessage
import com.ramo.ebuy.global.ui.rememberNotifications
import com.ramo.ebuy.global.ui.rememberPersonal
import com.ramo.ebuy.global.ui.rememberProductCategory
import com.ramo.ebuy.global.ui.rememberPurchaseManagement
import com.ramo.ebuy.global.ui.rememberRecentViewed
import com.ramo.ebuy.global.ui.rememberSearch
import com.ramo.ebuy.global.ui.rememberSell
import com.ramo.ebuy.global.ui.rememberSetting
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Duration.Companion.milliseconds


inline fun <C, R> List<C>.ifNotEmpty(defaultValue: List<C>.() -> R): R? = if (isNotEmpty()) defaultValue() else null

inline fun <R> String.ifNotEmpty(defaultValue: String.() -> R): R? = if (isNotEmpty()) defaultValue() else null

inline val String.firstSpace: String
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ReadOnlyComposable
    get() = indexOf(" ").let { if (it == -1) this else substring(0, it) }

inline val String.firstCapital: String
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ReadOnlyComposable
    get() = toCharArray().apply {
        this[0] = this[0].uppercaseChar()
    }.let {
        String(it)
    }

internal val Long.fetchHour: Int
    get() = java.util.Calendar.getInstance().apply {
        timeInMillis = this@fetchHour
    }[java.util.Calendar.HOUR_OF_DAY]

internal val Long.fetchMinute: Int
    get() = java.util.Calendar.getInstance().apply {
        timeInMillis = this@fetchMinute
    }[java.util.Calendar.MINUTE]


internal val fetchTimeGap: (time: Long) -> TimeGap?
    get() = { time ->
        Instant.fromEpochMilliseconds(time).epochSeconds.milliseconds.inWholeMilliseconds.let { end ->
            Clock.System.now().epochSeconds.milliseconds.inWholeMilliseconds.let { now ->
                if (end > now) {
                    Instant.fromEpochMilliseconds(
                        end - now
                    ).toLocalDateTime(TimeZone.currentSystemDefault()).let { gap ->
                        TimeGap(gap.dayOfYear, gap.hour)
                    }
                } else null
            }
        }
    }

inline val profileData: List<String>
    get() {
        return buildList {
            add("Messages")
            add("Watchlist")
            add("Saved")
            add("Purchases")
            add("Bids & Offers")
            add("Selling")
            add("Recent Viewed")
            add("Categories")
            add("Deals")
            add("Settings")
            add("Help")
        }
    }

inline val Int.profileIcons: @androidx.compose.runtime.Composable (Color) -> androidx.compose.ui.graphics.vector.ImageVector
    get() = {
        when (this) {
            0 -> rememberMessage(it)
            1 -> rememberFavorite(it)
            2 -> rememberFavorite(it)
            3 -> rememberPurchaseManagement(it)
            4 -> rememberBid(it)
            5 -> rememberSell(it)
            6 -> rememberRecentViewed(it)
            7 -> rememberProductCategory(it)
            8 -> rememberLightning(it)
            9 -> rememberSetting(it)
            10 -> rememberHelp(it)
            else -> rememberHelp(it)
        }
    }

inline val hotBarData: List<String>
    get() {
        return buildList {
            add("Selling")
            add("Deals")
            add("Categories")
            add("Saved")
        }
    }

inline val Int.hotBarIcons: androidx.compose.ui.graphics.vector.ImageVector
    @androidx.compose.runtime.Composable
    get() {
        return when (this) {
            0 -> rememberSell(Color.Gray)
            1 -> rememberLightning(Color.Gray)
            2 -> rememberProductCategory(Color.Gray)
            else -> rememberFavorite(Color.Gray)
        }
    }

inline val bottomBarData: List<String>
    get() {
        return buildList {
            add("Home")
            add("My eBuy")
            add("Search")
            add("Inbox")
            add("Selling")
        }
    }

inline val Int.bottomBarIcons: androidx.compose.ui.graphics.vector.ImageVector
    @androidx.compose.runtime.Composable
    get() {
        return when (this) {
            0 -> rememberHome(Color.Gray)
            1 -> rememberPersonal(Color.Gray)
            2 -> rememberSearch(Color.Gray)
            3 -> rememberNotifications(Color.Gray)
            else -> rememberSell(Color.Gray)
        }
    }


fun cato(): List<Category> {
    return buildList {
        add(Category(1, "TECH", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/93/619094/1.jpg?2560", 1, -1))
        add(Category(2, "TELEVISIONS", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/359744/1.jpg?4978", 1, 1))
        add(Category(3, "TUBE", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/47/796613/1.jpg?7826", 1, 2))
        add(Category(4, "LCD", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/74/956483/1.jpg?9747", 1, 2))
        add(Category(5, "PLASMA", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/40/357284/1.jpg?5906", 1, 2))
        add(Category(6, "PORTABLE ELECTRONICS", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/18/313084/1.jpg?0214", 1, 1))
        add(Category(7, "MP3 PLAYERS", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/491602/1.jpg?1949", 1, 6))
        add(Category(8, "FLASH", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/22/411581/1.jpg?9349", 1, 7))
        add(Category(9, "CD PLAYERS", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/37/850302/1.jpg?4989", 1, 6))
        add(Category(10, "2 WAY RADIOS", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/55/159784/1.jpg?3043", 1, 6))
        add(Category(4, "LCD", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/74/956483/1.jpg?9747", 1, 2))
        add(Category(5, "PLASMA", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/40/357284/1.jpg?5906", 1, 2))
        add(Category(6, "PORTABLE ELECTRONICS", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/18/313084/1.jpg?0214", 1, 1))
        add(Category(7, "MP3 PLAYERS", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/491602/1.jpg?1949", 1, 6))
        add(Category(8, "FLASH", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/22/411581/1.jpg?9349", 1, 7))
    }
}

fun item(): List<Product> {
    return buildList {
        add(
            Product(
                id = 9784,
                name = "Luis Forbes",
                imageUri = "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/93/619094/1.jpg?2560",
                price = 4.5f,
                discount = 6.7f,
                discountStart = 6041,
                discountEnd = 2588,
                parentCato = 6420,
                parentCatoName = "Sheldon Guzman",
                sold = 3900,
                country = 6458,
                size = "donec",
                condition = "Brand New",
                quantity = 9247,
                quantityAvailable = 1406,
                tint = "sanctus",
                category = 3514,
                specs = arrayOf()
            )
        )
        add(
            Product(
                id = 212,
                name = "Garmin Forerunner 945 GPS Sport Watch (Black)",
                price = 43.14F,
                imageUri = "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/359744/1.jpg?4978",
                discount = 33.14F,
                discountStart = 1L,
                discountEnd = 1704998827074L,
                parentCato = 2,
                parentCatoName = "",
                sold = 9042,
                country = 6996,
                size = "fabulas",
                condition = "Brand New",
                quantity = 2443,
                quantityAvailable = 4905,
                tint = "finibus",
                category = 4279,
                specs = arrayOf()
            )
        )
        add(
            Product(
                id = 212,
                name = "Urbanears Plattan Green On-Ear Headset",
                price = 43.14F,
                imageUri = "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/47/796613/1.jpg?7826",
                discount = 33.14F,
                discountStart = 1L,
                discountEnd = 1704938827074L,
                parentCato = 2,
                parentCatoName = "",
                sold = 6172,
                country = 1847,
                size = "vero",
                condition = "Brand New",
                quantity = 7695,
                quantityAvailable = 5354,
                tint = "elaboraret",
                category = 6282,
                specs = arrayOf(),
            )
        )
        add(
            Product(
                id = 212,
                name = "Urbanears Plattan Green On-Ear Headset",
                price = 43.14F,
                imageUri = "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/74/956483/1.jpg?9747",
                discount = 33.14F,
                discountStart = 1L,
                discountEnd = 1704938827074L,
                parentCato = 2,
                parentCatoName = "",
                sold = 4967,
                country = 2415,
                size = "vocent",
                condition = "Brand New",
                quantity = 9125,
                quantityAvailable = 7754,
                tint = "purus",
                category = 1776,
                specs = arrayOf(),
            )
        )
        add(
            Product(
                id = 212,
                name = "Urbanears Plattan Green On-Ear Headset",
                price = 43.14F,
                imageUri = "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/40/357284/1.jpg?5906",
                discount = 33.14F,
                discountStart = 1L,
                discountEnd = 1704938827074L,
                parentCato = 2,
                parentCatoName = "",
                sold = 2396,
                country = 4117,
                size = "cras",
                condition = "Brand New",
                quantity = 8083,
                quantityAvailable = 5582,
                tint = "repudiandae",
                category = 7323,
                specs = arrayOf(),
            )
        )
        add(
            Product(
                id = 212,
                name = "Urbanears Plattan Green On-Ear Headset",
                price = 43.14F,
                imageUri = "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/18/313084/1.jpg?0214",
                discount = 33.14F,
                discountStart = 1L,
                discountEnd = 1704938827074L,
                parentCato = 2,
                parentCatoName = "",
                sold = 7753,
                country = 3422,
                size = "dictum",
                condition = "Brand New",
                quantity = 5677,
                quantityAvailable = 9041,
                tint = "ornare",
                category = 7186,
                specs = arrayOf(),
            )
        )
        add(
            Product(
                id = 212,
                name = "Urbanears Plattan Green On-Ear Headset",
                price = 43.14F,
                imageUri = "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/491602/1.jpg?1949",
                discount = 33.14F,
                discountStart = 1L,
                discountEnd = 1704938827074L,
                parentCato = 2,
                parentCatoName = "",
                sold = 5350,
                country = 4947,
                size = "dolores",
                condition = "Brand New",
                quantity = 2922,
                quantityAvailable = 5620,
                tint = "no",
                category = 3647,
                specs = arrayOf(),
            )
        )
        add(
            Product(
                id = 212,
                name = "Urbanears Plattan Green On-Ear Headset",
                price = 43.14F,
                imageUri = "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/22/411581/1.jpg?9349",
                discount = 33.14F,
                discountStart = 1L,
                discountEnd = 1704938827074L,
                parentCato = 2,
                parentCatoName = "",
                sold = 2950,
                country = 6079,
                size = "bibendum",
                condition = "Brand New",
                quantity = 1955,
                quantityAvailable = 4087,
                tint = "natoque",
                category = 9340,
                specs = arrayOf(),
            )
        )
    }
}


data class TimeGap(val days: Int, val hours: Int)

data class HotBarData(val icon: String, val label: String)