package com.example.moviesapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_items")
data class MovieItem(
    var name: String,
    var amount: Int,
    var price: Float,
    var imageUrl: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)