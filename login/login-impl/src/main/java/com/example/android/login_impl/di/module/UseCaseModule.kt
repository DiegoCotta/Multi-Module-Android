package com.example.android.login_impl.di.module

import com.example.android.architectureexample.usecase.LoggedUserUseCase
import com.example.android.core_impl.di.scope.FeatureScope
import com.example.android.login_impl.domain.usecase.LoggedUserUseCaseImpl
import com.example.android.login_impl.domain.usecase.LogoutUseCaseImpl
import com.google.firebase.auth.FirebaseUser
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {

    @FeatureScope
    @Binds
    abstract fun provideLoggedUserUseCase(loggedUserUseCaseImpl: LoggedUserUseCaseImpl): LoggedUserUseCase<FirebaseUser>

    @FeatureScope
    @Binds
    abstract fun provideLogoutUseCase(logoutUseCaseImpl: LogoutUseCaseImpl): LogoutUseCaseImpl
}