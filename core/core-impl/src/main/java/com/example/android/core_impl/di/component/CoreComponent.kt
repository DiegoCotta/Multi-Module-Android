package com.example.android.core_impl.di.component

import android.content.Context
import com.example.android.core_impl.base.BaseInteractor
import com.example.android.core_impl.data.APIClient
import com.example.android.core_impl.di.injector.ComponentFactory
import com.example.android.core_impl.di.injector.ComponentManager
import com.example.android.core_impl.di.injector.RootComponentManager
import com.example.android.core_impl.di.module.ContextModule
import com.example.android.core_impl.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class
    ]
)
@Singleton
abstract class CoreComponent : CoreComponentApi {
    companion object {
        fun get(): CoreComponent =
            RootComponentManager.getComponent(CoreComponentApi::class) as CoreComponent

        fun release() = RootComponentManager.releaseComponent(CoreComponentApi::class)
    }

    override fun isReleasable() = false

}

class CoreComponentFactory : ComponentFactory<CoreComponentApi> {
    override fun create(componentManager: ComponentManager): CoreComponentApi {
        return DaggerCoreComponent.builder().build()
    }
}