package com.example.moviesapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moviesapp.models.Movie
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_items")
data class MovieEntity(
    var name: String,
    var vote_average: Double,
    var vote_count: Int,
    var poster_path: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)

fun MovieEntity.toMovie() = Movie(
    id= id!!,
    name = name,
    vote_average = vote_average,
    vote_count = vote_count,
    poster_path = poster_path
)

