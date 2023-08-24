package com.example.moviesapp.data.remote

import com.example.moviesapp.models.Movie
import com.example.moviesapp.models.MovieResponse
import com.example.moviesapp.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("search/tv")
    suspend fun getMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String ="en-US",
        @Query("page") page: Int = 1,
        @Query("query") query: String = "comedy",
        @Query("include_adult") includeAdult: Boolean = false
    ): MovieResponse

}
