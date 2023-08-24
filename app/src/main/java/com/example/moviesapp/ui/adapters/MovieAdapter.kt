package com.example.moviesapp.ui.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.util.Constants.POSTER_BASE_URL
import com.example.moviesapp.R
import com.example.moviesapp.models.Movie

class MovieAdapter(private val movieList: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val movie = movieList[position]
        holder.tvRating.text = movie.vote_average.toString()
        holder.tvVote.text = movie.vote_count.toString()
        holder.tvName.text = movie.name
        val moviePosterURL = POSTER_BASE_URL + movie?.poster_path
        Glide.with(holder.itemView.context)
            .load(moviePosterURL)
            .into(holder.ivMovie);

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvRating: TextView = itemView.findViewById(R.id.tvRating)
        val tvVote: TextView = itemView.findViewById(R.id.tvVote)
        val ivMovie: ImageView = itemView.findViewById(R.id.ivMovie)
        val tvName: TextView = itemView.findViewById(R.id.tvMovieName)
    }
}


