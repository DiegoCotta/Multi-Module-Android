package com.example.android.movies_impl.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.example.android.core_impl.base.BaseActivity
import com.example.android.core_impl.di.InjectUtils
import com.example.android.movies_impl.R
import com.example.android.movies_impl.databinding.ActivityMoviesBinding
import com.example.android.movies_impl.di.DaggerMovieComponent

class MoviesActivity : BaseActivity<ActivityMoviesBinding>(R.layout.activity_movies) {

    val viewmodel  : MovieViewModel by viewModels { mViewModelFactory }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMovieComponent.builder()
            .coreComponent(InjectUtils.provideCoreComponent(applicationContext))
            .build()
            .inject(this)

        viewmodel.searchMovies("batman")
    }
}