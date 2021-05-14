package com.example.android.architectureexample

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.android.architectureexample.di.AppComponent
import com.example.android.core_impl.di.injector.ComponentManager
import com.example.android.core_impl.di.injector.ComponentProperties
import com.example.android.movies_api.MoviesApi
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var componentManager: ComponentManager

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    val viewModel: SplashViewModel by viewModels { mViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppComponent.get().inject(this@SplashActivity)
    }


    override fun onResume() {
        super.onResume()
        startActivity(Intent(this,MainActivity::class.java))
    }
}