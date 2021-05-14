package com.example.android.movies_impl.presentation


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.core_impl.base.BaseFragment
import com.example.android.core_impl.di.injector.ComponentManager
import com.example.android.core_impl.di.injector.ComponentProperties
import com.example.android.core_impl.view.MarginItemDecoration
import com.example.android.movies_api.MoviesApi
import com.example.android.movies_api.data.model.Movie
import com.example.android.movies_impl.R
import com.example.android.movies_impl.databinding.FragmentHomeMoviesBinding
import com.example.android.movies_impl.di.MovieComponent
import com.example.android.movies_impl.presentation.adapter.MoviesAdapter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class HomeMoviesFragment :
    BaseFragment<FragmentHomeMoviesBinding>(R.layout.fragment_home_movies) {


    var movie: Movie? = null
    val viewModel: MovieViewModel by navGraphViewModels(R.id.movies_navigation){ mViewModelFactory }
    private var columnCount = 2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MovieComponent.get().inject(this)

        binding.viewModel = viewModel
        binding.gridMovies.apply {
            addItemDecoration(MarginItemDecoration(resources.getDimensionPixelSize(R.dimen.grid_margin)))
            layoutManager = GridLayoutManager(context, columnCount)
            adapter = MoviesAdapter {
                movie = it
                viewModel.getUser()
                viewModel.setSelected(it)
            }
        }
        viewModel.user.observe(viewLifecycleOwner) {
            if(it != null)
                Toast.makeText(requireContext(), "${movie?.title} ${it.displayName}", Toast.LENGTH_SHORT).show()
        }
        viewModel.selectedMovie.observe(viewLifecycleOwner) {
            findNavController().navigate(HomeMoviesFragmentDirections.actionHomeMoviesFragmentToOtherFragment())
        }
        viewModel.searchMovies("batman")
    }

}
