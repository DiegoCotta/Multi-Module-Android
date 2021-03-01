package com.example.android.movies_impl.domain.usecase

import com.example.android.core_impl.base.BaseUseCase
import com.example.android.core_impl.base.BaseUseCaseRequest
import com.example.android.core_impl.functional.ResultData
import com.example.android.movies_impl.domain.model.Movie
import com.example.android.movies_impl.domain.repository.MoviesRepository
import java.lang.Exception
import javax.inject.Inject

class SearchMovieUseCase @Inject constructor(val moviesRepository: MoviesRepository) :
    BaseUseCase<List<Movie>, SearchMovieUseCase.Params>() {

    data class Params(val search: String, val page: Int = 1) : BaseUseCaseRequest

    override suspend fun run(params: Params): ResultData<List<Movie>> =
        try {
            ResultData.Success(
                moviesRepository.searchMovie(
                    search = params.search,
                    page = params.page
                )
            )
        } catch (e: Exception) {
            ResultData.Failure(e)
        }
}