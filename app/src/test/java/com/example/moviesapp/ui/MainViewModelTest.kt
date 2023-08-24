package com.example.moviesapp.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviesapp.MainDispatcherRule
import com.example.moviesapp.models.Movie
import com.example.moviesapp.models.MovieResponse
import com.example.moviesapp.repositories.MovieRepository
import com.example.moviesapp.util.Constants.POSTER_BASE_URL
import com.example.moviesapp.util.Resource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val repository = mockk<MovieRepository>()


    @Test
    fun `Load success`() = runTest {
        // Given
        coEvery { repository.getMovies() } returns fakeMovies

        // When: call getMovies
        val viewModel = MainViewModel(repository)
        viewModel.getMovies()

        // Then: live data should contains success value
        assert(viewModel.movies.value is Resource.Success)
        val usersResponse = (viewModel.movies.value as Resource.Success).data
        Assert.assertEquals(usersResponse, fakeMovies)
    }


    @Test
    fun `Load failed`() = runTest {
        // Given
        coEvery { repository.getMovies() } returns null

        // When: call getMovies
        val viewModel = MainViewModel(repository)
        viewModel.getMovies()

        // Then: live data should contains error value
        assert(viewModel.movies.value is Resource.Error)
    }
}


private val fakeMovies = MovieResponse(
    1,
    movieList = listOf(
        Movie(
            id = 1,
            name = "Fname1",
            vote_average = 9.8,
            vote_count = 128,
            poster_path = POSTER_BASE_URL +"/Tts7M6f5KzEwa8OXD931w8ET0e.jpg"
        ),
        Movie(
            id = 2,
            name = "Fname2",
            vote_average = 9.6,
            vote_count = 129,
            poster_path = POSTER_BASE_URL +"/Tts7M6f5KzEwa8OXD931w8ET0e.jpg"
        ),
        Movie(
            id = 3,
            name = "Fname3",
            vote_average = 8.8,
            vote_count = 133,
            poster_path = POSTER_BASE_URL +"/Tts7M6f5KzEwa8OXD931w8ET0e.jpg"
        )
    ),
1,
    1
)