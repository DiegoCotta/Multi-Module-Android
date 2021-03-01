package com.example.android.core_impl.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<T : ViewDataBinding,V: ViewModel> : AppCompatActivity() {

    lateinit var binding: T
    lateinit var activityViewModel: V
    abstract fun getLayoutId(): Int
    abstract fun init()
    protected abstract fun getViewModelClass(): Class<V>?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.apply { lifecycleOwner = this@BaseActivity }
        init()
    }
}