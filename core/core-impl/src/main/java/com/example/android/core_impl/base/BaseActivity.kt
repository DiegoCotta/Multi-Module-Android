package com.example.android.core_impl.base

import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.android.core_impl.R
import com.example.android.core_impl.delegate.dataBinding
import com.example.android.core_impl.exception.BaseException
import com.example.android.core_impl.exception.IllegalAppStateException
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes contentLayoutId: Int) :
    AppCompatActivity(contentLayoutId) {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    protected val binding: T by dataBinding()

    protected fun handleError(error: Throwable) {

        if (handleIllegalAppState(error)) return

        val message: String = when (error) {
            is UnknownHostException -> getString(R.string.no_connection_error)
            is HttpException -> getString(R.string.api_general_error)
            is BaseException -> error.message ?: ""
            else -> getString(R.string.api_general_error)
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun handleIllegalAppState(error: Throwable): Boolean {
        if (error is IllegalAppStateException || error.cause is IllegalAppStateException) {
            Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
            finish()
            return true
        }
        return false
    }
}