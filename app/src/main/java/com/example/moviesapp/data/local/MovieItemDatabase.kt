package com.example.moviesapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MovieItem::class],
    version = 1
)
abstract class MovieItemDatabase : RoomDatabase() {

    abstract fun shoppingDao(): MovieDao
}