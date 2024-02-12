package com.ramo.ebuy

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object MyLibraryObject {
    var context: Context? = null
    fun init(context: Context) {
        this.context = context
    }
}
