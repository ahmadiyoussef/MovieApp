package com.example.moviesapp.repositories

import com.example.moviesapp.data.local.MovieDao
import com.example.moviesapp.data.remote.MoviesApi
import com.example.moviesapp.data.local.MovieEntity
import com.example.moviesapp.data.local.MovieLocalDataSource
import com.example.moviesapp.models.Movie
import com.example.moviesapp.models.MovieResponse
import javax.inject.Inject


class MovieRepository @Inject constructor(
    private val api: MoviesApi

) {

    suspend fun getMovies(): MovieResponse? {
        return try {
           api.getMovies()
        } catch (e: Exception) {
            null
        }

    }

// this function will be used to manage offline mode,
    /*  suspend fun getMovies(): List<Movie> {
       val localMovies = localDataSource.getMovieList()
       if (localMovies.isNotEmpty()) return localMovies
       val remoteMovies =  api.getMovies()
       localDataSource.saveMovies(remoteMovies.movieList)
       return localDataSource.getMovieList()
       }
   }*/



}


