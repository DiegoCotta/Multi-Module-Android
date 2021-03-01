package com.example.android.movies_impl.presentation

import androidx.lifecycle.ViewModel
import com.example.android.core_impl.base.BaseActivity
import com.example.android.movies_impl.R
import com.example.android.movies_impl.databinding.ActivityMoviesBinding

class MoviesActivity : BaseActivity<ActivityMoviesBinding, ViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_movies

    override fun init() {
    }

    override fun getViewModelClass(): Class<ViewModel>? = null
}