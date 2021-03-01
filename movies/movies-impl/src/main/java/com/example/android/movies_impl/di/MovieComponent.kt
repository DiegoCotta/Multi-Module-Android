package com.example.android.movies_impl.di


import com.example.android.core_impl.di.component.CoreComponent
import com.example.android.core_impl.di.scope.FeatureScope
import com.example.android.movies_impl.di.module.MovieAPIClientModule
import com.example.android.movies_impl.di.module.RepositoryModule
import com.example.android.movies_impl.di.module.ViewModelModule
import com.example.android.movies_impl.presentation.HomeMoviesFragment
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        MovieAPIClientModule::class,
        RepositoryModule::class
    ],
    dependencies = [CoreComponent::class]
)
@FeatureScope
interface MovieComponent {
    fun inject(homeMoviesFragment: HomeMoviesFragment)
}