package com.example.android.architectureexample.di


import com.example.android.architectureexample.CustomApplication
import com.example.android.architectureexample.LoginApi
import com.example.android.architectureexample.SplashActivity
import com.example.android.core_impl.di.component.CoreComponentFactory
import com.example.android.core_impl.di.component.CoreComponentApi
import com.example.android.core_impl.di.injector.RootComponentManager
import com.example.android.login_impl.di.LoginComponentFactory
import com.example.android.movies_api.MoviesApi
import com.example.android.movies_impl.di.MovieComponentFactory
import dagger.Component
import dagger.internal.Preconditions
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AppViewModelModule::class
    ]
)
abstract class AppComponent {
    abstract fun inject(application: CustomApplication)
    abstract fun inject(application: SplashActivity)
    companion object {
        @Volatile
        private var instance: AppComponent? = null

        fun get(): AppComponent {
            return Preconditions.checkNotNull(
                instance,
                "AppComponent is not initialized yet. Call init first."
            )!!
        }

        fun init(component: AppComponent) {
            require(instance == null) { "AppComponent is already initialized." }
            instance = component

            RootComponentManager.registerFactory(CoreComponentFactory(), CoreComponentApi::class)
            RootComponentManager.registerFactory(MovieComponentFactory(), MoviesApi::class)
            RootComponentManager.registerFactory(LoginComponentFactory(), LoginApi::class)
        }
    }

}
