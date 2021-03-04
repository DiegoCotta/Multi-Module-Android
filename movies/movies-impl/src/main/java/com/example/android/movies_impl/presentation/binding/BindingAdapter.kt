package com.example.android.movies_impl.presentation.binding

import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.movies_impl.R
import com.example.android.movies_impl.domain.model.Movie
import com.example.android.movies_impl.presentation.adapter.MoviesAdapter
import java.util.*

@BindingAdapter("movieListData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Movie>?) {
    val adapter = recyclerView.adapter as MoviesAdapter
    data?.let { adapter.submitList(it) }
    recyclerView.scrollToPosition(0)
}

@BindingAdapter("image")
fun bindMovieImage(imageView: ImageView, movie: Movie?) {
    if (movie != null) {
        Glide
            .with(imageView.context)
            .load(movie.poster)
            .into(imageView)
    } else {
        imageView.setImageResource(R.drawable.ic_error)
    }
}