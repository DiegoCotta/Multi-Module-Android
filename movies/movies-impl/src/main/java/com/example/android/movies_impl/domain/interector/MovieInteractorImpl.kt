package com.example.android.movies_impl.domain.interector

import com.example.android.core_impl.di.scope.FeatureScope
import com.example.android.core_impl.functional.ResultData
import com.example.android.movies_api.MovieInteractor
import com.example.android.movies_api.data.model.Movie
import javax.inject.Inject

@FeatureScope
class MovieInteractorImpl @Inject constructor(): MovieInteractor {
    companion object {
        var movie: Movie? = null
    }

    override fun movieToRentUseCase(): ResultData<Movie> =
        if (movie != null)
            ResultData.Success(movie!!)
        else
            ResultData.Failure(Exception("Nenhum filme para alugar"))

}