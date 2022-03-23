package com.example.movies_showcase.feature.movies.detail

import com.example.movies_showcase.data.model.response.ApiResponse
import com.example.movies_showcase.domain.model.movie.MovieDetails
import com.example.movies_showcase.domain.repository.MoviesRepository
import com.example.movies_showcase.feature.movies.details.state.MovieDetailsState
import com.example.movies_showcase.feature.movies.details.viewmodel.MoviesDetailsViewModel
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
@DelicateCoroutinesApi
class MovieDetailsViewModelTest {

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    private val moviesRepository = mockk<MoviesRepository>()

    private lateinit var movieDetailsViewModel: MoviesDetailsViewModel

    @Before
    fun setUp() {
        movieDetailsViewModel = MoviesDetailsViewModel(moviesRepository)
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun `Given that movieId is passed, when repository returns response, then should post state with returned model`() {
        runBlocking {
            val movieId = "id"
            val movieDetails = mockk<MovieDetails>()
            coEvery { moviesRepository.getMovieDetails(movieId) } returns flowOf(
                ApiResponse.Success(
                    movieDetails
                )
            )
            val testResult = mutableListOf<MovieDetailsState>()
            val job = launch(Dispatchers.Main) {
                movieDetailsViewModel.state.toList(testResult)
            }

            movieDetailsViewModel.loadMovieDetails(movieId)

            assertThat(testResult).containsExactly(
                MovieDetailsState.Loading,
                MovieDetailsState.Movie(movieDetails)
            )
            job.cancel()
        }
    }
}
