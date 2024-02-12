package com.ramo.ebuy.data.supaBase

import com.ramo.ebuy.data.util.supabase
import com.ramo.ebuy.global.base.SUPA_STORAGE_CATO
import com.ramo.ebuy.global.base.SUPA_STORAGE_PRODUCT
import io.github.jan.supabase.storage.storage
import kotlinx.datetime.Clock

suspend fun io.github.jan.supabase.SupabaseClient.uploadFile(
    baseName: String,
    image: ByteArray,
    invoke: suspend (String) -> Unit,
) {
    storage.from(SUPA_STORAGE_CATO).apply {
        kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
            supabase {
                upload(
                    baseName + "_" + Clock.System.now().toEpochMilliseconds() + "_" + kotlin.random.Random.nextInt(),
                    data = image,
                    upsert = false
                )
            } ?: ""
        }.let {
            invoke(it)
        }
    }
}

suspend fun io.github.jan.supabase.SupabaseClient.uploadListFile(
    baseName: String,
    images: List<ByteArray>,
    invoke: suspend (List<String>) -> Unit,
) {
    kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
        android.util.Log.w("WWWWw", images.size.toString())
        images.map {
            supabase {
                storage.from(SUPA_STORAGE_PRODUCT).upload(
                    baseName + "_" + Clock.System.now().toEpochMilliseconds() + "_" + kotlin.random.Random.nextInt(),
                    data = it,
                    upsert = false
                ).let { link ->
                    "https://odqkrfnamcdglfmqhkhv.supabase.co/storage/v1/object/public/$link"
                }
            } ?: ""
        }
    }.let {
        invoke(it)
    }
}