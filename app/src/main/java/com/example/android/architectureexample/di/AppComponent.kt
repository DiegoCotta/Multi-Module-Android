package com.example.android.architectureexample.di


import com.example.android.architectureexample.CustomApplication
import com.example.android.core_impl.di.component.CoreComponent
import com.example.android.core_impl.di.scope.AppScope
import dagger.Component
import dagger.android.AndroidInjectionModule

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class,
        AndroidInjectionModule::class]
)
interface AppComponent {
    fun inject(application: CustomApplication)
}
