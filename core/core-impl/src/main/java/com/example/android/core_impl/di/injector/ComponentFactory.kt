package com.example.android.core_impl.di.injector

interface ComponentFactory<T : ComponentApi> {
    fun create(componentManager: ComponentManager): T
}