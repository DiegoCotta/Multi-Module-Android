package com.example.android.movies_impl.navigation

import android.app.Activity
import android.content.Intent
import com.example.android.movies_api.MoviesStarter
import com.example.android.movies_impl.presentation.MoviesActivity

class MoviesStarterImpl: MoviesStarter {
    override fun start(activity: Activity) {
        activity.startActivity(Intent(activity, MoviesActivity::class.java))
    }

}