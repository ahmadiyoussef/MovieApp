package com.example.moviesapp.repositories

import androidx.lifecycle.LiveData
import com.example.moviesapp.data.remote.MoviesApi
import com.example.moviesapp.data.local.MovieItem
import com.example.moviesapp.models.Movie
import com.example.moviesapp.models.MovieResponse
import javax.inject.Inject


class MovieRepository @Inject constructor(
    private val api: MoviesApi) {

    suspend fun insertMovieItem(shoppingItem: MovieItem) {}

    suspend fun deleteMovieItem(shoppingItem: MovieItem) {}

   // fun observeAllMoviesItems(): LiveData<List<MovieItem>> {}

    suspend fun getMovies(): MovieResponse? {
        return try {
            api.getMovies()
        } catch (e: Exception) {
            null
        }

    }


}