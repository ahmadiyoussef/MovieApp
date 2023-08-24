package com.example.moviesapp.data.local

import com.example.moviesapp.models.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieLocalDataSource @Inject constructor (
    private val movieDao: MovieDao
) {

    suspend fun getMovieList(): List<Movie> = withContext(Dispatchers.IO) {
        return@withContext movieDao.getAll().map(MovieEntity::toMovie)
    }

    suspend fun saveMovies(movies: List<Movie>) = withContext(Dispatchers.IO) {
        movieDao.insertAll(movies.map {
            MovieEntity(
                id = 0,
                name = it.name,
                vote_average = it.vote_average,
                vote_count = it.vote_count,
                poster_path = it.poster_path

            )
        })
    }
}