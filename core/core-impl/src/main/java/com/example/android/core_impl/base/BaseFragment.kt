package com.example.android.core_impl.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment() {

    lateinit var binding: T
    lateinit var viewModel: V

    protected abstract fun getLayoutId(): Int
    protected abstract fun getViewModelClass(): Class<V>?
    abstract fun init()

//    @Inject
//    lateinit var mViewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.apply { lifecycleOwner = viewLifecycleOwner }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        getViewModelClass()?.apply {
//            viewModel = ViewModelProvider(this@BaseFragment, mViewModelFactory).get(this)
//        }

        init()
        super.onViewCreated(view, savedInstanceState)
    }
}