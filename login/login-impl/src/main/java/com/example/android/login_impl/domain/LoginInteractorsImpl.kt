package com.example.android.login_impl.domain

import com.example.android.architectureexample.LoginInteractors
import com.example.android.architectureexample.com.example.android.architectureexample.usecase.LogoutUseCase
import com.example.android.architectureexample.usecase.LoggedUserUseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginInteractorsImpl @Inject constructor(
    private val loggedUserUseCase: LoggedUserUseCase<FirebaseUser>,
//    private val logoutUseCase: LogoutUseCase
) : LoginInteractors {
    override fun getLoggedUser(): Flow<FirebaseUser?>  {
        return flow {
            emit(FirebaseAuth.getInstance().currentUser)
        }
    }

//    override fun logoutUser(): LogoutUseCase = logoutUseCase

}