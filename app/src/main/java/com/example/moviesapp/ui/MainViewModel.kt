package com.example.moviesapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.models.Movie
import com.example.moviesapp.models.MovieResponse
import com.example.moviesapp.repositories.MovieRepository
import com.example.moviesapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _movies = MutableLiveData<Resource<List<Movie>>>()
    val movies: LiveData<Resource<List<Movie>>> get() = _movies



    init {
        getMovies()
    }

    fun getMovies() = viewModelScope.launch {
        _movies.postValue(Resource.Loading())
        val response = repository.getMovies()
        if (response != null) {
            _movies.postValue(Resource.Success(response.movieList))
        } else {
            _movies.postValue(Resource.Error("Error fetching books"))
        }
    }




}