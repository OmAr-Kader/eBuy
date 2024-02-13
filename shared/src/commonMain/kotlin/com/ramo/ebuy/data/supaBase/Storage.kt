package com.ramo.ebuy.data.supaBase

import com.ramo.ebuy.data.util.supabase
import com.ramo.ebuy.global.base.SUPA_STORAGE_LINK
import io.github.jan.supabase.storage.storage
import kotlinx.datetime.Clock

suspend fun io.github.jan.supabase.SupabaseClient.uploadFile(
    bucket: String,
    baseName: String,
    image: ByteArray,
    invoke: suspend (String) -> Unit,
) {
    storage.from(bucket).apply {
        kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
            supabase {
                upload(
                    baseName + "_" + Clock.System.now().toEpochMilliseconds() + "_" + kotlin.random.Random.nextInt(),
                    data = image,
                    upsert = false
                ).let { link ->
                    SUPA_STORAGE_LINK + link
                }
            } ?: ""
        }.let {
            invoke(it)
        }
    }
}

suspend fun io.github.jan.supabase.SupabaseClient.uploadListFile(
    bucket: String,
    baseName: String,
    images: List<ByteArray>,
    invoke: suspend (List<String>) -> Unit,
) {
    kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
        images.map {
            supabase {
                storage.from(bucket).upload(
                    baseName + "_" + Clock.System.now().toEpochMilliseconds() + "_" + kotlin.random.Random.nextInt(),
                    data = it,
                    upsert = false
                ).let { link ->
                    SUPA_STORAGE_LINK + link
                }
            } ?: ""
        }
    }.let {
        invoke(it)
    }
}

suspend fun io.github.jan.supabase.SupabaseClient.deleteFile(
    bucket: String,
    url: String,
    invoke: suspend (Unit?) -> Unit,
) {
    storage.from(bucket).apply {
        kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
            supabase {
                url.split("${bucket}/").lastOrNull()?.let {
                    delete(it)
                }
            }
        }.let {
            invoke(it)
        }
    }
}