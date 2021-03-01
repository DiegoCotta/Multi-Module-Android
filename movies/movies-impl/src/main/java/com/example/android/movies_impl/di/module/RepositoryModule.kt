package com.example.android.movies_impl.di.module

import com.example.android.movies_impl.data.repository.MoviesRepositoryImpl
import com.example.android.movies_impl.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideMovieRepository(moviesRepository: MoviesRepositoryImpl):
            MoviesRepository = moviesRepository
}