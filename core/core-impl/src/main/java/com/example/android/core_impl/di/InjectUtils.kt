package com.example.android.core_impl.di

import android.content.Context
import com.example.android.core_impl.di.component.CoreComponent

object InjectUtils {

    fun provideCoreComponent(applicationContext: Context): CoreComponent {
        return if (applicationContext is CoreComponentProvider) {
            (applicationContext as CoreComponentProvider).provideCoreComponent()
        } else {
            throw IllegalStateException("Provide the application context which implement BaseComponentProvider")
        }
    }

}