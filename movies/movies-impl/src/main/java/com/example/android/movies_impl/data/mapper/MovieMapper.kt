package com.example.android.movies_impl.data.mapper

import com.example.android.core_impl.base.BaseMapper
import com.example.android.movies_impl.data.model.MovieData
import com.example.android.movies_impl.domain.model.Movie

object MovieMapper : BaseMapper<MovieData, Movie>() {
    override fun transformTo(source: MovieData): Movie =
        Movie(
            poster = source.Poster,
            title = source.Title,
            year = source.Year,
            imdbID = source.imdbID
        )
}