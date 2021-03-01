package com.example.android.movies_impl.domain.repository

import com.example.android.movies_impl.domain.model.Movie
import com.example.android.movies_impl.domain.model.MovieDetails

interface MoviesRepository {

    suspend fun searchMovie(search: String, page: Int?): List<Movie>

    suspend fun getMovie(id: String): MovieDetails

}