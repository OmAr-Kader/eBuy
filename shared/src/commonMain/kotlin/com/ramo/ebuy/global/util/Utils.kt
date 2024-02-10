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
import io.ktor.http.Url
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.toLocalDateTime
val String?.urlCheckIfEmpty: String?
    get() {
        /*return try {
            this?.let { Url(it).let { this } }
        } catch (e: Throwable) {
            null
        }*/
        return if (this@urlCheckIfEmpty?.isEmpty() == true) {
            null
        } else {
            this
        }
    }

val String?.urlFullCheck: String?
    get() {
        return if (this@urlFullCheck?.isEmpty() == true) {
            null
        } else {
            if (this == null) {
                null
            } else {
                try {
                    Url(this)
                    this
                } catch (e: Throwable) {
                    null
                }
            }
        }
    }

val Long.toYearString: String
    get() {
        return Instant.fromEpochMilliseconds(this).toLocalDateTime(TimeZone.currentSystemDefault()).year.toString()
    }

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

internal val fetchTimeGap: (time: Long) -> TimeGap?
    get() = { time ->
        Instant.fromEpochMilliseconds(time).toEpochMilliseconds().let { end ->
            Clock.System.now().toEpochMilliseconds().let { now ->
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

internal val currentTime: TimeSplitter
    get() {
        return Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).let {
            TimeSplitter(year = it.year, month = it.monthNumber, day = it.dayOfMonth, hour = it.hour)
        }
    }

internal val splitTime: (time: Long) -> TimeSplitter
    get() = { time ->
        Instant.fromEpochMilliseconds(
            time
        ).toLocalDateTime(TimeZone.currentSystemDefault()).let {
            TimeSplitter(year = it.year, month = it.monthNumber, day = it.dayOfMonth, hour = it.hour)
        }
    }

internal val margeYear: (year: Int) -> Long
    get() = { year ->
        val currentMoment: Instant = Clock.System.now()
        val datetimeInUtc: LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        currentMoment.minus(
            datetimeInUtc.year - year,
            DateTimeUnit.YEAR,
            TimeZone.currentSystemDefault()
        ).toEpochMilliseconds()
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


inline val offerSubTitle: String
    get() = "Buyers interested in your item can make you offers you can accept, counter, or decline."

inline val conditions: List<String>
    get() = listOf("Brand New", "Like New", "Very Good", "Good", "Acceptable")

fun cato(): List<Category> {
    return buildList {
        add(Category(1, "TECH", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/93/619094/1.jpg?2560", 1, -1))
        add(Category(2, "TELEVISIONS", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/359744/1.jpg?4978", 1, 1))
        add(Category(3, "TUBE", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/47/796613/1.jpg?7826", 1, 2))
        add(Category(4, "LED", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/74/956483/1.jpg?9747", 1, 2))
        add(Category(5, "PLASMA", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/40/357284/1.jpg?5906", 1, 2))
        add(Category(6, "ELECTRONICS", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/18/313084/1.jpg?0214", 1, 1))
        add(Category(7, "MP3 PLAYERS", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/491602/1.jpg?1949", 1, 6))
        add(Category(8, "FLASH", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/22/411581/1.jpg?9349", 1, 7))
        add(Category(9, "CD PLAYERS", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/37/850302/1.jpg?4989", 1, 6))
        add(Category(10, "2 WAY RADIOS", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/55/159784/1.jpg?3043", 1, 6))
        add(Category(11, "LCD", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/74/956483/1.jpg?9747", 1, 2))
        add(Category(12, "IPS", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/40/357284/1.jpg?5906", 1, 2))
        add(Category(13, "PORTABLE ELECTRONICS", "https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/18/313084/1.jpg?0214", 1, 1))
    }
}

fun countries(): List<Country> {
    return buildList {
        add(Country(0, "US", "USA America United State"))
        add(Country(1, "Egypt", "Egypt Cairo Giza"))
    }
}

inline val ratings: List<AgeRate>
    get() {
        return listOf(
            AgeRate(0, "G – General Audiences"),
            AgeRate(1, "PG – Parental Guidance Suggested"),
            AgeRate(2, "PG-13 – Parents Strongly Cautioned"),
            AgeRate(3, "R – Restricted"),
            AgeRate(4, "NC-17 – Adults Only"),
        )
    }

fun item(): List<Product> {
    return buildList {
        add(
            Product(
                id = 7384,
                productCode = "viris",
                title = "Shelton Patterson",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/93/619094/1.jpg?2560"),
                price = 8.9f,
                auction = -1f,
                offer = 10.11f,
                auctionStart = 6110,
                auctionEnd = 3498,
                parentCato = 1291,
                parentCategories = listOf("Adan Goodwin"),
                condition = "New",
                scheduled = -1L,
                status = 1,
                ageRate = 0,
            )
        )
        add(
            Product(
                id = 9589,
                productCode = "expetenda",
                title = "Cherry Mayer",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/359744/1.jpg?4978"),
                price = 16.17f,
                auction = -1f,
                offer = 18.19f,
                auctionStart = 8687,
                auctionEnd = 6307,
                parentCato = 4482,
                parentCategories = listOf("Adan Goodwin"),
                condition = "New",
                scheduled = -1L,
                status = 1,
                ageRate = 0,
            )
        )
        add(
            Product(
                id = 9122,
                productCode = "himenaeos",
                title = "Kerri Burnett",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/359744/1.jpg?4978"),
                price = 24.25f,
                auction = -1f,
                offer = 26.27f,
                auctionStart = 4193,
                auctionEnd = 1261,
                parentCato = 4362,
                parentCategories = listOf("Adan Goodwin"),
                condition = "New",
                scheduled = -1L,
                status = 1,
                ageRate = 0,
            )
        )
        add(
            Product(
                id = 7449,
                productCode = "voluptatum",
                title = "Heather Ramirez",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/47/796613/1.jpg?7826"),
                price = 32.33f,
                auction = -1f,
                offer = 34.35f,
                auctionStart = 6303,
                auctionEnd = 6759,
                parentCato = 8497,
                parentCategories = listOf("Adan Goodwin"),
                condition = "New",
                scheduled = -1L,
                status = 1,
                ageRate = 0,
            )
        )
        add(
            Product(
                id = 5132,
                productCode = "expetenda",
                title = "Amelia Lewis",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/74/956483/1.jpg?9747"),
                price = 40.41f,
                auction = -1f,
                offer = 42.43f,
                auctionStart = 1155,
                auctionEnd = 6576,
                parentCato = 9036,
                parentCategories = listOf("Adan Goodwin"),
                condition = "New",
                scheduled = -1L,
                status = 1,
                ageRate = 0,
            )
        )
        add(
            Product(
                id = 6330,
                productCode = "molestiae",
                title = "Rachel Langley",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/40/357284/1.jpg?5906"),
                price = 48.49f,
                auction = -1f,
                offer = 50.51f,
                auctionStart = 9625,
                auctionEnd = 2549,
                parentCato = 5189,
                parentCategories = listOf("Adan Goodwin"),
                condition = "New",
                scheduled = -1L,
                status = 1,
                ageRate = 0,
            )
        )
        add(
            Product(
                id = 3740,
                productCode = "disputationi",
                title = "Stephen Ewing",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/18/313084/1.jpg?0214"),
                price = 56.57f,
                auction = -1f,
                offer = 58.59f,
                auctionStart = 3306,
                auctionEnd = 4182,
                parentCato = 3158,
                parentCategories = listOf("Adan Goodwin"),
                condition = "New",
                scheduled = -1L,
                status = 1,
                ageRate = 0,
            )
        )
        add(
            Product(
                id = 7305,
                productCode = "dicunt",
                title = "Tamara Lawrence",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/77/491602/1.jpg?1949"),
                price = 64.65f,
                auction = -1f,
                offer = 66.67f,
                auctionStart = 3883,
                auctionEnd = 3322,
                parentCato = 5627,
                parentCategories = listOf("Adan Goodwin"),
                condition = "New",
                scheduled = -1L,
                status = 1,
                ageRate = 0,
            )
        )
        add(
            Product(
                id = 3485,
                productCode = "elit",
                title = "Hershel Hooper",
                imageUris = listOf("https://eg.jumia.is/unsafe/fit-in/680x680/filters:fill(white)/product/22/411581/1.jpg?9349"),
                price = 72.73f,
                auction = -1f,
                offer = 74.75f,
                auctionStart = 1490,
                auctionEnd = 2468,
                parentCato = 5768,
                parentCategories = listOf("Adan Goodwin"),
                condition = "New",
                scheduled = -1L,
                status = 1,
                ageRate = 0,
            )
        )
    }
}


data class Country(val id: Int, val display: String, val searchable: String)

data class AgeRate(val id: Int, val display: String)

data class TimeGap(val days: Int, val hours: Int)

data class TimeSplitter(val year: Int, val month: Int, val day: Int, val hour: Int) {

    constructor(year: Int) : this(year, 1, 1, 4)
}

data class HotBarData(val icon: String, val label: String)