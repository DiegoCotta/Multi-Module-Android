package com.example.android.movies_impl.data.mapper

import com.example.android.core_impl.base.BaseMapper
import com.example.android.movies_api.data.model.MovieDetailsData
import com.example.android.movies_impl.domain.model.MovieDetails

object MovieDetailsMapper : BaseMapper<MovieDetailsData, MovieDetails>() {
    override fun transformTo(source: MovieDetailsData): MovieDetails =
        MovieDetails(
            actors = source.actors,
            awards = source.awards,
            country = source.country,
            director = source.director,
            genre = source.genre,
            language = source.language,
            plot = source.plot,
            poster = source.poster,
            production = source.production,
            released = source.released,
            runtime = source.runtime,
            title = source.title,
            writer = source.writer,
            year = source.year,
            imdbID = source.imdbID,
            imdbRating = source.imdbRating
        )
}