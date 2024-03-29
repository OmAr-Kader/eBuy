package com.ramo.ebuy.global.util

import androidx.compose.ui.graphics.Color
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

inline fun String?.ifEmptyOrNull(invoke: () -> String): String {
    return if (isNullOrEmpty()) {
        invoke()
    } else this
}

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


internal val currentMillis: Long
    get() {
        return Clock.System.now().toEpochMilliseconds()
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

inline val conditions: Array<String>
    get() = arrayOf("Brand New", "Like New", "Very Good", "Good", "Acceptable")

inline val ratings: Array<AgeRate>
    get() {
        return arrayOf(
            AgeRate(0, "G – General Audiences"),
            AgeRate(1, "PG – Parental Guidance Suggested"),
            AgeRate(2, "PG-13 – Parents Strongly Cautioned"),
            AgeRate(3, "R – Restricted"),
            AgeRate(4, "NC-17 – Adults Only"),
        )
    }

fun countries(): List<Country> {
    return buildList {
        add(Country(0, "US", "USA America United State"))
        add(Country(1, "Egypt", "Egypt Cairo Giza"))
    }
}

data class Country(val id: Int, val display: String, val searchable: String)

data class AgeRate(val id: Int, val display: String)

data class TimeGap(val days: Int, val hours: Int)

data class TimeSplitter(val year: Int, val month: Int, val day: Int, val hour: Int) {
    constructor(year: Int) : this(year, 1, 1, 4)
}
