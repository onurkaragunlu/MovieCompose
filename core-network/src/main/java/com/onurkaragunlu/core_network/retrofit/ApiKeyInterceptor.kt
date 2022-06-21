package com.onurkaragunlu.core_network.retrofit

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Onur Karagünlü on 4.06.2022.
 */
class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        //TODO it will be hidden
        val url = request.url.newBuilder()
            .addQueryParameter(API_KEY, "2774c3307231501a4f73a5ba9a123079").build()
        val requestBuilder = request.newBuilder().url(url)
        return chain.proceed(requestBuilder.build())
    }

    companion object {
        private const val API_KEY = "api_key"
    }
}
