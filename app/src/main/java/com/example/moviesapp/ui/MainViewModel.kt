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
    val movies: LiveData<Resource<List<Movie>>> = _movies
    private var originalMovieList: List<Movie>? = null

    init {
        _movies.value = Resource.Loading()
        fetchMovieData()
    }

    fun filterMovies(query: String) {
        val currentState = _movies.value

        if (originalMovieList == null) {
            originalMovieList = currentState?.data
        }
        if (query.isEmpty()) {
            _movies.postValue(Resource.Success(originalMovieList!!))
        } else if (currentState is Resource.Success) {
            val filteredMovies = currentState.data?.filter { it.name.contains(query, true) }
            _movies.postValue(Resource.Success(filteredMovies!!))
        }
    }

    private fun fetchMovieData() {
        viewModelScope.launch {
            _movies.postValue(Resource.Loading())
            val response = repository.getMovies()
            if (response != null) {
                _movies.postValue(Resource.Success(response.movieList))
            } else {
                _movies.postValue(Resource.Error("Error fetching movies"))
            }
        }
    }


}