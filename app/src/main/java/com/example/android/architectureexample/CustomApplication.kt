package com.example.android.architectureexample

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.example.android.architectureexample.di.AppComponent
import com.example.android.architectureexample.di.DaggerAppComponent
import javax.inject.Inject

class CustomApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        AppComponent.init(
            DaggerAppComponent.builder()
                .build()
        )
        AppComponent.get().inject(this)
    }


}