package com.example.android.movies_api


import com.example.android.core_impl.functional.ResultData
import com.example.android.movies_api.data.model.Movie

interface RentMovieInteractor {
    fun getMovieUseCase(): ResultData<Movie>
}