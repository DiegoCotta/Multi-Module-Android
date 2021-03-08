package com.example.android.core_impl.di.injector

import kotlin.reflect.KClass

interface ComponentManager {
    fun <T : ComponentApi> registerFactory(factory: ComponentFactory<T>, klass: KClass<T>)
    fun <T : ComponentApi> getOrCreateComponent(properties: ComponentProperties<T>): T
    fun <T : ComponentApi> getComponent(klass: KClass<T>): T
    fun <T : ComponentApi> releaseComponent(klass: KClass<T>)
}
