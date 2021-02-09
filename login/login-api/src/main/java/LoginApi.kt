package com.example.android.architectureexample

import com.example.android.login_api.model.User
import java.util.concurrent.Flow

interface LoginApi {
    fun loginStarter(): LoginStarter

    fun getLoggedUser(): Flow<User>
}