package com.ramo.ebuy.data.util

suspend inline fun <reified T> io.github.jan.supabase.postgrest.result.PostgrestResult.toListOfObject(json: kotlinx.serialization.json.Json): List<T>? {
    return try {
        kotlinx.coroutines.coroutineScope {
            json.decodeFromString<List<T>?>(data)
        }
    } catch (e: kotlinx.serialization.SerializationException) {
        null
    } catch (e: IllegalArgumentException) {
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
        null
    } catch (e: io.ktor.client.plugins.HttpRequestTimeoutException) {
        null
    } catch (e: io.github.jan.supabase.exceptions.HttpRequestException) {
        null
    }
}
