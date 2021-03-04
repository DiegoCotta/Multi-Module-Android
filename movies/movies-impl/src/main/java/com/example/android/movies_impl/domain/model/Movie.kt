package com.example.android.movies_impl.domain.model

data class Movie(
    val poster: String,
    val title: String,
    var year: String,
    val imdbID: String
)