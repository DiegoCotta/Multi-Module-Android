package com.example.android.core_impl.di.module

import com.example.android.core_impl.data.APIClient
import com.example.android.core_impl.data.APIClientImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesApiClient(): APIClient = APIClientImpl()
}
