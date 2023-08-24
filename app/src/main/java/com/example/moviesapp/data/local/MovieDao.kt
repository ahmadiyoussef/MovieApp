package com.example.moviesapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(movieItem: MovieItem)

    @Delete
    suspend fun deleteShoppingItem(movieItem: MovieItem)

    @Query("SELECT * FROM movie_items")
    fun observeAllShoppingItems(): LiveData<List<MovieItem>>


}