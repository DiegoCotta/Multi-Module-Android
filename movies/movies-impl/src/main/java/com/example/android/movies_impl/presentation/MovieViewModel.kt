package com.example.android.movies_impl.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.core_impl.base.BaseViewModel
import com.example.android.core_impl.functional.isSuccessful
import com.example.android.core_impl.functional.onFailure
import com.example.android.core_impl.functional.onSuccess
import com.example.android.movies_impl.domain.model.Movie
import com.example.android.movies_impl.domain.usecase.SearchMovieUseCase
import javax.inject.Inject


class MovieViewModel @Inject constructor(
    private val searchMovieUseCase: SearchMovieUseCase
) : BaseViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()

    val movies: LiveData<List<Movie>>
        get() = _movies

    fun searchMovies(search: String) {
        loading.value = true
        searchMovieUseCase(SearchMovieUseCase.Params(search)) { result ->
            if (result.isSuccessful)
                result.onSuccess { resultMovies ->
                    _movies.value = resultMovies
                }
            else {
                result.onFailure { ::handleFailure }
            }
            loading.value = false
        }
    }

//    suspend fun refreshAsteroids(startDate: String ) {
//        withContext(Dispatchers.IO) {
//            val asteroidList = Network.nasaService.getAsteroidlist(startDate).await()
//            database.asteroidDao.insertAll(*parseAsteroidsJsonResult(JSONObject(asteroidList)).asDatabaseModel())
//        }
//    }

//    val asteroids: LiveData<List<Asteroid>> =
//        Transformations.map(database.asteroidDao.getAsteroids()) {
//            it.asDomainModel()
//        }

}