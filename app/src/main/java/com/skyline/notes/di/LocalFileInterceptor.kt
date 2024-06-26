package com.skyline.notes.di


import android.content.Context
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody

class LocalFileInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.toString()
        if (url.contains("notes.json")) {
            val jsonString = context.assets.open("notes.json").bufferedReader().use { it.readText() }

            return Response.Builder()
                .code(200)
                .message("OK")
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .body(
                    ResponseBody.create(
                        "application/json".toMediaTypeOrNull(),
                        jsonString.toByteArray()
                    )
                )
                .addHeader("content-type", "application/json")
                .build()
        }

        return chain.proceed(request)
    }
}
