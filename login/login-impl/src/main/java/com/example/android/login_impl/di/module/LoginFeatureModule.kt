package com.example.android.login_impl.di.module

import com.example.android.architectureexample.LoginInteractors
import com.example.android.architectureexample.LoginStarter
import com.example.android.core_impl.di.scope.FeatureScope
import com.example.android.login_impl.domain.LoginInteractorsImpl
import com.example.android.login_impl.navigation.LoginStarterImpl
import dagger.Binds
import dagger.Module

@Module
abstract class LoginFeatureModule {
    @FeatureScope
    @Binds
    abstract fun provideMoviesStarterImpl(loginStarterImpl: LoginStarterImpl): LoginStarter

    @FeatureScope
    @Binds
    abstract fun provideLoginInteractors(loggedUserInteractorImpl: LoginInteractorsImpl): LoginInteractors
}
