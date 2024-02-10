package com.ramo.ebuy.data.util

import android.util.Log
import io.github.jan.supabase.exceptions.HttpRequestException
import io.github.jan.supabase.exceptions.RestException
import io.ktor.client.plugins.HttpRequestTimeoutException

suspend inline fun <reified T : Any> supabase(
    crossinline operation: suspend () -> T?,
): T? {
    return try {
        operation()
    } catch (e: RestException) {
        Log.w("supabase", e.stackTraceToString())
        null
    } catch (e: HttpRequestTimeoutException) {
        Log.w("supabase", e.stackTraceToString())
        null
    } catch (e: HttpRequestException) {
        Log.w("supabase", e.stackTraceToString())
        null
    }
}
