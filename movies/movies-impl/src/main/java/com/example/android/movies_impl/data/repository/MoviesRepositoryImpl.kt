package com.example.android.movies_impl.data.repository

import com.example.android.movies_impl.data.api.OMDBApiService
import com.example.android.movies_impl.data.mapper.MovieDetailsMapper
import com.example.android.movies_impl.data.mapper.MovieMapper
import com.example.android.movies_impl.domain.model.Movie
import com.example.android.movies_impl.domain.model.MovieDetails
import com.example.android.movies_impl.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(val service: OMDBApiService) : MoviesRepository {
    override suspend fun searchMovie(search: String, page: Int?): List<Movie> =
        MovieMapper.transformToList(service.searchMovies(search).Search)


    override suspend fun getMovie(id: String): MovieDetails =
        MovieDetailsMapper.transformTo(service.getMovie(id))

}