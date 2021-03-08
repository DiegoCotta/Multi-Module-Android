package com.example.android.login_impl.presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.android.core_impl.base.BaseActivity
import com.example.android.login_impl.R
import com.example.android.login_impl.databinding.ActivityLoginBinding
import com.example.android.login_impl.presentation.LoginViewModel.AuthenticationState.AUTHENTICATED
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    companion object {
        const val TAG = "LoginActivity"
        const val SIGN_IN_RESULT_CODE = 1001
    }

    val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btLogin.setOnClickListener {
            launchSignInFlow()
        }
    }

    private fun launchSignInFlow() {

        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(), AuthUI.IdpConfig.GoogleBuilder().build()
        )

        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            SIGN_IN_RESULT_CODE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SIGN_IN_RESULT_CODE) {
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK) {
                // User successfully signed in
                Log.i(
                    TAG,
                    "Successfully signed in user ${FirebaseAuth.getInstance().currentUser?.displayName}!"
                )
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                Log.i(TAG, "Sign in unsuccessful ${response?.error?.errorCode}")
            }
        }
    }

    private fun observeAuthenticationState() {

        viewModel.authenticationState.observe(this) { authenticationState ->

            when (authenticationState) {
                // you can customize the welcome message they see by
                // utilizing the getFactWithPersonalization() function provided
                AUTHENTICATED -> {
                    binding.btLogin.text = "Logout"
                    binding.btLogin.setOnClickListener {
                    AuthUI.getInstance().signOut(this)
                    }
                }
                else -> {
                    // auth_button should display Login and
                    // launch the sign in screen when clicked.
                    binding.btLogin.text = "Login"

                    binding.btLogin.setOnClickListener {
                        launchSignInFlow()
                    }
                }
            }
        }
    }

}