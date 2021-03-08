package com.example.android.login_impl.presentation

import androidx.lifecycle.map
import com.example.android.core_impl.base.BaseViewModel

class LoginViewModel : BaseViewModel() {


    enum class AuthenticationState {
        AUTHENTICATED, UNAUTHENTICATED, INVALID_AUTHENTICATION
    }

    val authenticationState = FirebaseUserLiveData().map { user ->
        if (user != null) {
            AuthenticationState.AUTHENTICATED
        } else {
            AuthenticationState.UNAUTHENTICATED
        }
    }
}