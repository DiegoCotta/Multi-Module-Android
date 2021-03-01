package com.example.android.movies_impl.data.model

import com.squareup.moshi.Json

data class MovieResponse(
    val Response: String,
    val Search: List<MovieData>,
    val totalResults: String
)