package com.example.android.architectureexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.movies_impl.navigation.MoviesStarterImpl

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        finish()
    }
}