package com.example.android.architectureexample.usecase

import com.example.android.core_impl.base.UseCase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface LoggedUserUseCase<T> : UseCase<FirebaseUser>