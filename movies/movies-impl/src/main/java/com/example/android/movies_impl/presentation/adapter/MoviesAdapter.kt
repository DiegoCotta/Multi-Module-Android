package com.example.android.movies_impl.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.movies_impl.databinding.ItemMovieBinding
import com.example.android.movies_api.data.model.Movie


class MoviesAdapter(val onClickListener: (Movie) -> Unit) :
    ListAdapter<Movie, MoviesAdapter.ItemAsteroidViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.imdbID == newItem.imdbID
        }
    }

    class ItemAsteroidViewHolder(private var binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            movie: Movie,
            onClickListener: (Movie) -> Unit
        ) {
            binding.movie = movie
            binding.root.setOnClickListener { onClickListener(movie) }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ItemAsteroidViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
                return ItemAsteroidViewHolder(binding)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAsteroidViewHolder {
        return ItemAsteroidViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ItemAsteroidViewHolder, position: Int) {
        holder.bind(getItem(position), onClickListener)
    }
}
