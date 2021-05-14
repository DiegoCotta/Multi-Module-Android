package com.example.android.movies_impl.domain.interector

import com.example.android.core_impl.base.BaseUseCase
import com.example.android.core_impl.base.BaseUseCaseRequest
import com.example.android.core_impl.di.scope.FeatureScope
import com.example.android.core_impl.functional.ResultData
import com.example.android.movies_api.data.model.Movie
import com.example.android.movies_impl.domain.repository.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@FeatureScope
class SearchMovieUseCase @Inject constructor(private val moviesRepository: MoviesRepository) :
    BaseUseCase<List<Movie>, SearchMovieUseCase.Params>() {

    override val dispatcher: CoroutineDispatcher
        get() = Dispatchers.IO

    data class Params(val search: String, val page: Int = 1) : BaseUseCaseRequest

    override fun doWork(params: Params): Flow<List<Movie>> = flow {
        emit(
            moviesRepository.searchMovie(
                search = params.search,
                page = params.page
            )
        )
    }
}