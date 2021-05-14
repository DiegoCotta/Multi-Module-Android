package com.example.android.architectureexample

import com.example.android.core_impl.di.injector.ComponentApi

interface LoginApi : ComponentApi {
    fun loginStarter(): LoginStarter
    fun getLoginInteractors(): LoginInteractors
}