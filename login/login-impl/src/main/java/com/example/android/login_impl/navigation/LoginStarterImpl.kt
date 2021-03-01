package com.example.android.login_impl.navigation

import android.app.Activity
import android.content.Intent
import com.example.android.architectureexample.LoginStarter
import com.example.android.login_impl.presentation.LoginActivity

class LoginStarterImpl: LoginStarter {
    override fun start(activity: Activity) {
        activity.startActivity(Intent(activity,LoginActivity::class.java))
    }
}