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
                id = 7384,
                productCode = "viris",
                name = "Shelton Patterson",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/93/619094/1.jpg?2560"),
                price = 8.9f,
                discount = 10.11f,
                discountStart = 6110,
                discountEnd = 3498,
                parentCato = 1291,
                parentCatoName = "Adan Goodwin",
                condition = "New",
            )
        )
        add(
            Product(
                id = 9589,
                productCode = "expetenda",
                name = "Cherry Mayer",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/359744/1.jpg?4978"),
                price = 16.17f,
                discount = 18.19f,
                discountStart = 8687,
                discountEnd = 6307,
                parentCato = 4482,
                parentCatoName = "Kathryn Alston",
                condition = "New",
            )
        )
        add(
            Product(
                id = 9122,
                productCode = "himenaeos",
                name = "Kerri Burnett",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/359744/1.jpg?4978"),
                price = 24.25f,
                discount = 26.27f,
                discountStart = 4193,
                discountEnd = 1261,
                parentCato = 4362,
                parentCatoName = "Mona Owen",
                condition = "New",
            )
        )
        add(
            Product(
                id = 7449,
                productCode = "voluptatum",
                name = "Heather Ramirez",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/47/796613/1.jpg?7826"),
                price = 32.33f,
                discount = 34.35f,
                discountStart = 6303,
                discountEnd = 6759,
                parentCato = 8497,
                parentCatoName = "Eliza Frank",
                condition = "New",
            )
        )
        add(
            Product(
                id = 5132,
                productCode = "expetenda",
                name = "Amelia Lewis",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/74/956483/1.jpg?9747"),
                price = 40.41f,
                discount = 42.43f,
                discountStart = 1155,
                discountEnd = 6576,
                parentCato = 9036,
                parentCatoName = "Kareem Smith",
                condition = "New",

                )
        )
        add(
            Product(
                id = 6330,
                productCode = "molestiae",
                name = "Rachel Langley",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/40/357284/1.jpg?5906"),
                price = 48.49f,
                discount = 50.51f,
                discountStart = 9625,
                discountEnd = 2549,
                parentCato = 5189,
                parentCatoName = "Garth Barron",
                condition = "New",
            )
        )
        add(
            Product(
                id = 3740,
                productCode = "disputationi",
                name = "Stephen Ewing",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/18/313084/1.jpg?0214"),
                price = 56.57f,
                discount = 58.59f,
                discountStart = 3306,
                discountEnd = 4182,
                parentCato = 3158,
                parentCatoName = "Nora Britt",
                condition = "New",

                )
        )
        add(
            Product(
                id = 7305,
                productCode = "dicunt",
                name = "Tamara Lawrence",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/491602/1.jpg?1949"),
                price = 64.65f,
                discount = 66.67f,
                discountStart = 3883,
                discountEnd = 3322,
                parentCato = 5627,
                parentCatoName = "Lawanda Burt",
                condition = "New",
            )
        )
        add(
            Product(
                id = 3485,
                productCode = "elit",
                name = "Hershel Hooper",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/22/411581/1.jpg?9349"),
                price = 72.73f,
                discount = 74.75f,
                discountStart = 1490,
                discountEnd = 2468,
                parentCato = 5768,
                parentCatoName = "Graham Thompson",
                condition = "New",
            )
        )
    }
}


data class TimeGap(val days: Int, val hours: Int)

data class HotBarData(val icon: String, val label: String)