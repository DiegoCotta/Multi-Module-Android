package com.example.android.login_impl.domain.usecase

import com.example.android.architectureexample.usecase.LoggedUserUseCase
import com.example.android.core_impl.base.BaseUseCase
import com.example.android.core_impl.base.BaseUseCaseRequest
import com.example.android.core_impl.di.scope.FeatureScope
import com.example.android.core_impl.functional.ResultData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.broadcastIn
import kotlinx.coroutines.flow.flow

@FeatureScope
class LoggedUserUseCaseImpl @Inject constructor() : LoggedUserUseCase<FirebaseUser>,
    BaseUseCase<FirebaseUser, BaseUseCase.None>() {
    override val dispatcher: CoroutineDispatcher
        get() = Dispatchers.IO

    override fun doWork(params: None): Flow<FirebaseUser?> = flow {
        emit(FirebaseAuth.getInstance().currentUser)
    }
}
