package com.example.android.core_impl.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Exception

abstract class BaseViewModel : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading = _loading

    private val _failure: MutableLiveData<Exception> = MutableLiveData()
    val failure: LiveData<Exception> = _failure

    protected fun handleFailure(failure: Exception) {
        _failure.value = failure
    }

}