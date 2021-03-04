package com.example.android.core_impl.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.android.core_impl.delegate.dataBinding
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes contentLayoutId : Int) : AppCompatActivity(contentLayoutId) {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    protected val binding: T by dataBinding()
}