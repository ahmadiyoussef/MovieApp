package com.example.moviesapp.models

data class Movie(
    val name: String,
    val id: Int,
    val vote_average: Double,
    val vote_count: Int,
    val poster_path: String
)