package com.example.moviesapp.di

import android.content.Context
import androidx.room.Room
import com.example.moviesapp.data.remote.MoviesApi
import com.example.moviesapp.util.Constants.BASE_URL
import com.example.moviesapp.util.Constants.DATABASE_NAME
import com.example.moviesapp.data.local.MovieDao
import com.example.moviesapp.data.local.MovieItemDatabase
import com.example.moviesapp.data.local.MovieLocalDataSource
import com.example.moviesapp.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMovieItemDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, MovieItemDatabase::class.java, DATABASE_NAME).build()



    @Singleton
    @Provides
    fun provideMovieDao(
        database: MovieItemDatabase
    ) = database.movieDa()

    @Provides
    @Singleton
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSource(movieDao)
    }

    @Singleton
    @Provides
    fun provideMovieApi(): MoviesApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(MoviesApi::class.java)
    }


    @Provides
    fun provideRepository(movieApi: MoviesApi): MovieRepository {
        return MovieRepository(movieApi)
    }
}