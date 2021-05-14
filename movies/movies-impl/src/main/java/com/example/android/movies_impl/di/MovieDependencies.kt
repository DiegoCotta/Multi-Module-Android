package com.example.android.movies_impl.di

import com.example.android.architectureexample.LoginInteractors

internal interface MovieDependencies {
    fun loginInteractors(): LoginInteractors
}