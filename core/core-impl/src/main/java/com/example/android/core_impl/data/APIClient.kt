package com.example.android.core_impl.data

import okhttp3.Interceptor
import retrofit2.Retrofit

interface APIClient {
    fun getRetrofit(): Retrofit
    fun configure(baseUrl: String, customInterceptors: List<Interceptor> = listOf())
}