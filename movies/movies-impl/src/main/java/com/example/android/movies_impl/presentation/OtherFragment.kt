package com.example.android.movies_impl.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.navGraphViewModels
import com.example.android.core_impl.base.BaseFragment
import com.example.android.movies_impl.R
import com.example.android.movies_impl.databinding.FragmentOtherBinding

class OtherFragment :
    BaseFragment<FragmentOtherBinding>(R.layout.fragment_other) {
    val viewModel: MovieViewModel by navGraphViewModels(R.id.movies_navigation)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }
}