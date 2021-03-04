package com.example.android.core_impl.base

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.core_impl.delegate.dataBinding
import javax.inject.Inject

open class BaseFragment<T : ViewDataBinding>(@LayoutRes contentLayoutId: Int) :
    Fragment(contentLayoutId) {
    protected val binding: T by dataBinding()

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

}