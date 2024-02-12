package com.ramo.ebuy.global.util

import com.ramo.ebuy.MyLibraryObject

actual fun getByteArray(it: String): ByteArray? {
    return MyLibraryObject.context?.contentResolver?.openInputStream(android.net.Uri.parse(it))?.use { it.buffered().readBytes() }
}