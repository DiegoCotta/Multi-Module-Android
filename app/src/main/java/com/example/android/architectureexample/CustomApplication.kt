package com.example.android.architectureexample

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.example.android.architectureexample.di.AppComponent
import com.example.android.architectureexample.di.DaggerAppComponent
import com.example.android.core_impl.data.APIClient
import com.example.android.core_impl.di.component.CoreComponent
import com.example.android.core_impl.di.component.CoreComponentApi
import com.example.android.core_impl.di.injector.ComponentProperties
import javax.inject.Inject

class CustomApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        AppComponent.init(
            DaggerAppComponent.builder()
                .build()
        )
        AppComponent.get().inject(this)

    }

    companion object {
        @Volatile
        lateinit var appContext: Context
            private set
    }

}