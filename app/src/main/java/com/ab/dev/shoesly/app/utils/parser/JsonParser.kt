package com.ab.dev.shoesly.app.utils.parser

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import okio.BufferedSource

object JsonParser {
    val moshi : Moshi = Moshi.Builder().build()
    inline fun <reified T> toResponseError(json: BufferedSource) : T? {
        val jsonAdapter: JsonAdapter<T> = moshi.adapter(T::class.java)
        return jsonAdapter.fromJson(json)
    }
}