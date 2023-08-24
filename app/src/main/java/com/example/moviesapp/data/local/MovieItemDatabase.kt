package com.example.moviesapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [MovieEntity::class],
    version = 1
)
abstract class MovieItemDatabase : RoomDatabase() {
    abstract fun movieDa(): MovieDao
}