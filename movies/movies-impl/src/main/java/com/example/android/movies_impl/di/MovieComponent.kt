package com.example.android.movies_impl.di

import com.example.android.architectureexample.LoginApi
import com.example.android.architectureexample.LoginInteractors
import com.example.android.core_impl.data.APIClient
import com.example.android.core_impl.di.component.CoreComponent
import com.example.android.core_impl.di.component.CoreComponentApi
import com.example.android.core_impl.di.injector.ComponentFactory
import com.example.android.core_impl.di.injector.ComponentManager
import com.example.android.core_impl.di.injector.ComponentProperties
import com.example.android.core_impl.di.injector.RootComponentManager
import com.example.android.core_impl.di.scope.FeatureScope
import com.example.android.movies_api.MoviesApi
import com.example.android.movies_impl.di.module.MovieAPIClientModule
import com.example.android.movies_impl.di.module.MovieFeatureModule
import com.example.android.movies_impl.di.module.RepositoryModule
import com.example.android.movies_impl.di.module.ViewModelModule
import com.example.android.movies_impl.presentation.HomeMoviesFragment
import dagger.Component

@Component(
    modules = [
        MovieAPIClientModule::class,
        RepositoryModule::class,
        MovieFeatureModule::class,
        ViewModelModule::class
    ],
    dependencies = [CoreComponent::class, MovieDependencies::class]
)
@FeatureScope
internal abstract interface MovieComponent : MoviesApi {

    abstract fun inject(homeMoviesFragment: HomeMoviesFragment)

    companion object {
        fun get(): MovieComponent =
            RootComponentManager.getOrCreateComponent(ComponentProperties(MoviesApi::class)) as MovieComponent

        fun release() = RootComponentManager.releaseComponent(MoviesApi::class)
    }
}

class MovieComponentFactory : ComponentFactory<MoviesApi> {
    override fun create(componentManager: ComponentManager): MoviesApi {
        return DaggerMovieComponent.builder()
            .coreComponent(getDependencies(componentManager))
            .movieDependencies(getMoviesDepedencies(componentManager))
            .build()
    }

    private fun getMoviesDepedencies(componentManager: ComponentManager): MovieDependencies {
        return object : MovieDependencies {
            override fun loginInteractors(): LoginInteractors =
                componentManager.getOrCreateComponent(ComponentProperties(LoginApi::class))
                    .getLoginInteractors()
        }
    }

    private fun getDependencies(componentManager: ComponentManager): CoreComponent {
        return object : CoreComponent() {
            override fun apiClient(): APIClient =
                componentManager.getOrCreateComponent(ComponentProperties((CoreComponentApi::class)))
                    .apiClient()
        }
    }
}