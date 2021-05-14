package com.example.android.architectureexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android.core_impl.base.BaseViewModel
import com.example.android.core_impl.di.injector.ComponentManager
import com.example.android.core_impl.di.injector.ComponentProperties
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class SplashViewModel @Inject constructor(
    componentManager: ComponentManager
) : BaseViewModel() {

    private val _user = MutableLiveData<FirebaseUser?>()

    val user: LiveData<FirebaseUser?>
        get() = _user


    val loginInteractors: LoginInteractors = componentManager.getOrCreateComponent(
        ComponentProperties(LoginApi::class)
    ).getLoginInteractors()

    fun getLoggedUser() {
        loginInteractors.getLoggedUser().map {
            _user.value = it
        }.catch {
            _user.value = null
        }.launchIn(viewModelScope)

    }
}
