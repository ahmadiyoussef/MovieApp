package com.example.moviesapp.api

import com.example.moviesapp.models.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("search/tv")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("query") query: String,
        @Query("include_adult") includeAdult: Boolean
    ): Response<MovieResponse>

}
