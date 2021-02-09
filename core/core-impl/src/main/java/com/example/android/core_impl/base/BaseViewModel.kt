package com.example.android.core_impl.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


abstract class BaseViewModel : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading = _loading


}