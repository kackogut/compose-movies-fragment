package com.example.movies_showcase.data.network

import com.example.movies_showcase.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class KeyInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.request()
            .newBuilder()
            .addHeader(KEY_HEADER, BuildConfig.MOVES_DB_KEY)
            .build()
            .run { chain.proceed(this) }
    }

    private companion object {
        const val KEY_HEADER = "x-rapidapi-key"
    }
}
