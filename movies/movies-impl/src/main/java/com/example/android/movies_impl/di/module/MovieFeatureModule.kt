package com.example.android.movies_impl.di.module

import com.example.android.core_impl.di.scope.FeatureScope
import com.example.android.movies_api.RentMovieInteractor
import com.example.android.movies_impl.domain.interector.RentMovieInteractorImpl
import dagger.Binds
import dagger.Module

@Module
abstract class MovieFeatureModule{

    @FeatureScope
    @Binds
    abstract fun provideMovieInteractor(movieInterector: RentMovieInteractorImpl): RentMovieInteractor
}