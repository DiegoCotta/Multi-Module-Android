package com.example.android.movies_impl.navigation

import android.content.Context
import android.content.Intent
import com.example.android.core_impl.di.scope.FeatureScope
import com.example.android.movies_api.MoviesStarter
import com.example.android.movies_impl.presentation.MoviesActivity
import javax.inject.Inject

@FeatureScope
class MoviesStarterImpl @Inject constructor(): MoviesStarter {
    override fun start(context: Context) {
        val intent = Intent(context, MoviesActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}