package com.example.android.core_impl.di.injector

import kotlin.reflect.KClass

data class ComponentProperties<T : ComponentApi>(val klass: KClass<T>)