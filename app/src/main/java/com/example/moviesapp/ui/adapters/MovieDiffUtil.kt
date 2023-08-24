package com.example.moviesapp.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.moviesapp.models.Movie

class MovieDiffUtil : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return newItem == oldItem
    }

    override fun getChangePayload(oldItem: Movie, newItem: Movie): Any? {
        return super.getChangePayload(oldItem, newItem)
    }
}


data class CarItemToggled(
    val expanded: Boolean
)