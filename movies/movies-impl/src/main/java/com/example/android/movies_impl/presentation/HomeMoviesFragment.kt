package com.example.android.movies_impl.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.core_impl.base.BaseFragment
import com.example.android.core_impl.view.MarginItemDecoration
import com.example.android.movies_impl.R
import com.example.android.movies_impl.databinding.FragmentHomeMoviesBinding
import com.example.android.movies_impl.di.MovieComponent
import com.example.android.movies_impl.presentation.adapter.MoviesAdapter

class HomeMoviesFragment :
    BaseFragment<FragmentHomeMoviesBinding>(R.layout.fragment_home_movies) {

    val viewModel: MovieViewModel by activityViewModels { mViewModelFactory }

    private var columnCount = 2

    override fun onCreate(savedInstanceState: Bundle?) {

        MovieComponent.get().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.gridMovies.apply {
            addItemDecoration(MarginItemDecoration(resources.getDimensionPixelSize(R.dimen.grid_margin)))
            layoutManager = GridLayoutManager(context, columnCount)
            adapter = MoviesAdapter {
                Toast.makeText(requireContext(), it.title, Toast.LENGTH_SHORT).show()
            }
        }
    }

}
