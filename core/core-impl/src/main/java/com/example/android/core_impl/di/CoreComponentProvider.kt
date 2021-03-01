package com.example.android.core_impl.di

import com.example.android.core_impl.di.component.CoreComponent

interface CoreComponentProvider {
    fun provideCoreComponent(): CoreComponent
}