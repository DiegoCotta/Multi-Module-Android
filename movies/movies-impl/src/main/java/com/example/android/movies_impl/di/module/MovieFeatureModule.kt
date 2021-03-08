package com.example.android.movies_impl.di.module

import com.example.android.core_impl.di.scope.FeatureScope
import com.example.android.movies_api.MoviesStarter
import com.example.android.movies_api.MovieInteractor
import com.example.android.movies_impl.domain.interector.MovieInteractorImpl
import com.example.android.movies_impl.navigation.MoviesStarterImpl
import dagger.Binds
import dagger.Module

@Module
abstract class MovieFeatureModule{

    @FeatureScope
    @Binds
    abstract fun provideMoviesStarterImpl(moviesStarterImpl: MoviesStarterImpl): MoviesStarter

    @FeatureScope
    @Binds
    abstract fun provideMovieInteractor(movieInterector: MovieInteractorImpl): MovieInteractor
}