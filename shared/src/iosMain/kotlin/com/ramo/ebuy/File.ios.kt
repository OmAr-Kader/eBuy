package com.ramo.ebuy

import android.annotation.SuppressLint
import android.content.Context
import androidx.startup.Initializer

actual fun getByteArray(it: String): ByteArray? {
    return MyLibraryObject.context?.contentResolver?.openInputStream(android.net.Uri.parse(it))?.use { it.buffered().readBytes() }
}
