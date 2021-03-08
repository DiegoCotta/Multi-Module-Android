package com.example.android.architectureexample

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android.architectureexample.di.AppComponent
import com.example.android.core_impl.di.injector.ComponentManager
import com.example.android.core_impl.di.injector.ComponentProperties
import com.example.android.core_impl.functional.isFailure
import com.example.android.core_impl.functional.onFailure
import com.example.android.movies_api.MoviesApi
import com.example.android.movies_api.MoviesStarter
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {
    @Inject
    lateinit var componentManager: ComponentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppComponent.get().inject(this)
        val result = componentManager.getOrCreateComponent(ComponentProperties(MoviesApi::class))
            .movieInterector().movieToRentUseCase()
        if (!result.isFailure) {
            result.onFailure {
                Toast.makeText(this, it!!.message, Toast.LENGTH_LONG).show()
            }

        } else {
            componentManager.getOrCreateComponent(ComponentProperties(MoviesApi::class))
                .moviesStarter().start(this)
            finish()
        }
    }
}