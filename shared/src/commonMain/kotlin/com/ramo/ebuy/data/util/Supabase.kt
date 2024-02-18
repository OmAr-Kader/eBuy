package com.ramo.ebuy.data.util

import kotlinx.serialization.json.Json

@Suppress("JSON_FORMAT_REDUNDANT")
suspend inline fun <reified T> io.github.jan.supabase.postgrest.result.PostgrestResult.toListOfObject(): List<T>? {
    return try {
        kotlinx.coroutines.coroutineScope {
            Json {
                ignoreUnknownKeys = true
            }.decodeFromString<List<T>?>(data)
        }
    } catch (e: kotlinx.serialization.SerializationException) {
        android.util.Log.w("jsonToObject", e.stackTraceToString())
        null
    } catch (e: IllegalArgumentException) {
        android.util.Log.w("jsonToObject", e.stackTraceToString())
        null
    }
}

suspend inline fun <reified T : Any> supabase(
    crossinline operation: suspend () -> T?,
): T? {
    return try {
        kotlinx.coroutines.coroutineScope {
            operation()
        }
    } catch (e: io.github.jan.supabase.exceptions.RestException) {
        android.util.Log.w("supabase", e.stackTraceToString())
        null
    } catch (e: io.ktor.client.plugins.HttpRequestTimeoutException) {
        android.util.Log.w("supabase", e.stackTraceToString())
        null
    } catch (e: io.github.jan.supabase.exceptions.HttpRequestException) {
        android.util.Log.w("supabase", e.stackTraceToString())
        null
    }
}