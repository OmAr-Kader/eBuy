package com.ramo.ebuy.global.util

actual fun getByteArray(it: String): ByteArray? {
    if let data = try? Data(contentsOf: url) {
        if let image = UIImage(data: data) {
           return image.pngData()
        }
    }
    return null
}
