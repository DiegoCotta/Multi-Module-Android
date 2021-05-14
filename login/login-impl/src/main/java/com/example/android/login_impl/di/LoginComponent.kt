package com.example.android.login_impl.di

import com.example.android.architectureexample.LoginApi
import com.example.android.core_impl.data.APIClient
import com.example.android.core_impl.di.component.CoreComponent
import com.example.android.core_impl.di.component.CoreComponentApi
import com.example.android.core_impl.di.injector.ComponentFactory
import com.example.android.core_impl.di.injector.ComponentManager
import com.example.android.core_impl.di.injector.ComponentProperties
import com.example.android.core_impl.di.injector.RootComponentManager
import com.example.android.core_impl.di.scope.FeatureScope
import com.example.android.login_impl.di.module.LoginFeatureModule
import com.example.android.login_impl.di.module.UseCaseModule
import com.example.android.login_impl.di.module.ViewModelModule
import com.example.android.login_impl.domain.LoginInteractorsImpl
//import com.example.android.login_impl.presentation.LoginActivity
import dagger.Component
import javax.inject.Inject

@Component(
    modules = [
        LoginFeatureModule::class,
        ViewModelModule::class,
        UseCaseModule::class
    ],
    dependencies = [CoreComponent::class]
)
@FeatureScope
internal abstract interface LoginComponent : LoginApi {

    companion object {
        fun get(): LoginComponent =
            RootComponentManager.getComponent(LoginApi::class) as LoginComponent

        fun release() = RootComponentManager.releaseComponent(LoginApi::class)
    }

}

class LoginComponentFactory : ComponentFactory<LoginApi> {
    override fun create(componentManager: ComponentManager): LoginApi {
        return DaggerLoginComponent.builder()
            .coreComponent(getDependencies(componentManager))
            .build()
    }

    private fun getDependencies(componentManager: ComponentManager): CoreComponent {
        return object : CoreComponent() {
            override fun apiClient(): APIClient =
                componentManager.getOrCreateComponent(ComponentProperties(CoreComponentApi::class))
                    .apiClient()
        }
    }
}

