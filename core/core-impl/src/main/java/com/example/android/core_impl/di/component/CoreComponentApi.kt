package com.example.android.core_impl.di.component

import com.example.android.core_impl.data.APIClient
import com.example.android.core_impl.di.injector.ComponentApi

interface CoreComponentApi: ComponentApi {
    fun apiClient(): APIClient
}