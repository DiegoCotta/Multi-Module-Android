package com.example.android.core_impl.di.module

import android.app.Application
import android.content.Context
import com.example.android.core_impl.di.injector.ComponentManager
import com.example.android.core_impl.di.injector.RootComponentManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton



@Module
class ContextModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Singleton
    @Provides
    fun provideComponentManager(): ComponentManager = RootComponentManager
}
