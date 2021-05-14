package com.example.android.movies_api

import com.example.android.core_impl.di.injector.ComponentApi

interface MoviesApi : ComponentApi {

    fun movieInterector(): RentMovieInteractor
}