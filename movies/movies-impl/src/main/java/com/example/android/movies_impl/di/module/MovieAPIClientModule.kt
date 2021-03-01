package com.example.android.movies_impl.di.module

import com.example.android.core_impl.data.APIClient
import com.example.android.movies_impl.BuildConfig
import com.example.android.movies_impl.data.api.OMDBApiService
import com.example.android.core_impl.BuildConfig as CoreBuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class MovieAPIClientModule {

    private val apiKeyInterceptor: Interceptor = Interceptor { chain ->
        var request: Request = chain.request()
        val url: HttpUrl = request.url
            .newBuilder()
            .addQueryParameter("apikey", BuildConfig.API_KEY)
            .build()

        request = request
            .newBuilder()
            .url(url)
            .build()

        return@Interceptor chain.proceed(request)
    }

    @Provides
    fun provideOMDBApiService(apiclient: APIClient): OMDBApiService {
        apiclient.configure(CoreBuildConfig.BASE_URL, listOf(apiKeyInterceptor))
        return apiclient.getRetrofit().create(OMDBApiService::class.java)
    }

}