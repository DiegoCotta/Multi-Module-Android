package com.example.android.architectureexample

import com.example.android.architectureexample.com.example.android.architectureexample.usecase.LogoutUseCase
import com.example.android.architectureexample.usecase.LoggedUserUseCase
import com.example.android.core_impl.base.BaseInteractor
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface LoginInteractors {
    fun getLoggedUser(): Flow<FirebaseUser?>
//    fun logoutUser(): LogoutUseCase
}