package com.example.android.core_impl.di.component

import android.content.Context
import com.example.android.core_impl.data.APIClient
import com.example.android.core_impl.di.module.ContextModule
import com.example.android.core_impl.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
        AndroidInjectionModule::class
    ]
)
@Singleton
interface CoreComponent {
    fun context(): Context

    fun getAPIClient() : APIClient

}