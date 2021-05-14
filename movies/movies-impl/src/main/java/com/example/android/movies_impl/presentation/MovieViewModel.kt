package com.example.android.movies_impl.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android.architectureexample.LoginApi
import com.example.android.architectureexample.LoginInteractors
import com.example.android.core_impl.base.BaseViewModel
import com.example.android.core_impl.di.injector.ComponentManager
import com.example.android.core_impl.di.injector.ComponentProperties
import com.example.android.core_impl.functional.isSuccessful
import com.example.android.core_impl.functional.onFailure
import com.example.android.core_impl.functional.onSuccess
import com.example.android.movies_api.data.model.Movie
import com.example.android.movies_impl.domain.interector.SearchMovieUseCase
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MovieViewModel @Inject constructor(
    private val searchMovieUseCase: SearchMovieUseCase,
    private val loginInteractors: LoginInteractors
) : BaseViewModel() {

    private val _selectedMovie = MutableLiveData<Movie?>()
    val selectedMovie: LiveData<Movie?>
        get() = _selectedMovie


    private val _movies = MutableLiveData<List<Movie>>()

    val movies: LiveData<List<Movie>>
        get() = _movies

    private val _user = MutableLiveData<FirebaseUser?>()

    val user: LiveData<FirebaseUser?>
        get() = _user

    fun searchMovies(search: String) {
        loading.value = true

        searchMovieUseCase.produce(SearchMovieUseCase.Params("batman")).map { result ->
            _movies.value = result
            loading.value = false
        }.launchIn(viewModelScope)
    }

    fun getUser() {
        loginInteractors.getLoggedUser().map { _user.value = it }.launchIn(viewModelScope)
    }

    fun setSelected(movie: Movie?) {
        _selectedMovie.value = movie
    }
}