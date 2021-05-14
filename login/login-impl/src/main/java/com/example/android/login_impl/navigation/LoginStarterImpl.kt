package com.example.android.login_impl.navigation

import android.app.Activity
import android.content.Intent
import com.example.android.architectureexample.LoginStarter
import com.example.android.core_impl.di.scope.FeatureScope
//import com.example.android.login_impl.presentation.LoginActivity
import javax.inject.Inject

@FeatureScope
class LoginStarterImpl @Inject constructor(): LoginStarter {
    override fun start(activity: Activity) {
//        activity.startActivity(Intent(activity,LoginActivity::class.java))
    }
}