package com.example.android.core_impl.data

import com.example.android.core_impl.BuildConfig
import exception.IllegalAppStateException
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class APIClientImpl : APIClient {

    companion object {
        @Volatile
        var instance: APIClient? = null
    }

    private var mRetrofit: Retrofit? = null

    init {
        instance = this
    }

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    private fun createClient(customInterceptors: List<Interceptor>): OkHttpClient {
        val client = OkHttpClient.Builder().apply {

            customInterceptors.forEach { interceptor ->
                this.addInterceptor(interceptor)
            }
            if (BuildConfig.DEBUG) {
                this.addInterceptor(interceptor)
            }
        }

        return client.build()
    }

    override fun getRetrofit(): Retrofit =
        mRetrofit ?: throw IllegalAppStateException()

    override fun configure(baseUrl: String, customInterceptors: List<Interceptor>) {
        mRetrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(createClient(customInterceptors))
            .build()
    }

}