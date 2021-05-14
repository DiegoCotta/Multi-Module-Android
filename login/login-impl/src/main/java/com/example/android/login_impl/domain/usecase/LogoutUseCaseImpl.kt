package com.example.android.login_impl.domain.usecase

import com.example.android.architectureexample.com.example.android.architectureexample.usecase.LogoutUseCase
import com.example.android.core_impl.base.BaseUseCase
import com.example.android.core_impl.base.NoResultUseCase
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject


class LogoutUseCaseImpl @Inject constructor() : LogoutUseCase,
    NoResultUseCase< BaseUseCase.None>() {
    override suspend fun run(params: BaseUseCase.None) {
        FirebaseAuth.getInstance().signOut()
    }
}