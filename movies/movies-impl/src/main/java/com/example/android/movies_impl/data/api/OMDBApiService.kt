package com.example.android.movies_impl.data.api

import com.example.android.movies_api.data.model.MovieDetailsData
import com.example.android.movies_impl.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OMDBApiService {
    @GET("/")
    suspend fun searchMovies(
        @Query("s") search: String,
        @Query("page") page: Int = 1,
        @Query("type") type: String = "movie"
    ): MovieResponse

    @GET("/")
    suspend fun getMovie(
        @Query("i") id: String,
        @Query("plot") plot: String = "full"
    ): MovieDetailsData
}