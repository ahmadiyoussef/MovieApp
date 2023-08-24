package com.example.moviesapp.models

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("vote_average")
    val vote_average: Double,
    @SerializedName("vote_count")
    val vote_count: Int,
    @SerializedName("poster_path")
    val poster_path: String
)