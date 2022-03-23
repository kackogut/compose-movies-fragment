package com.example.movies_showcase.feature.movies.detail

import com.example.movies_showcase.data.model.response.ApiResponse
import com.example.movies_showcase.domain.model.movie.MovieDetails
import com.example.movies_showcase.domain.repository.MoviesRepository
import com.example.movies_showcase.feature.movies.details.state.MovieDetailsState
import com.example.movies_showcase.feature.movies.details.viewmodel.MoviesDetailsViewModel
import com.example.movies_showcase.utils.CoroutineTestRule
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
@DelicateCoroutinesApi
class MovieDetailsViewModelTest {

    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    private val moviesRepository = mockk<MoviesRepository>()

    private lateinit var movieDetailsViewModel: MoviesDetailsViewModel

    @Before
    fun setUp() {
        movieDetailsViewModel = MoviesDetailsViewModel(moviesRepository)
    }

    @Test
    fun `Given that movieId is passed, when repository returns response, then should post state with returned model`() =
        runTest {
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

            yield()
            assertThat(testResult).containsExactly(
                MovieDetailsState.Initial,
                MovieDetailsState.Loading,
                MovieDetailsState.Movie(movieDetails)
            )
            job.cancel()
        }


    @Test
    fun `Given that movieId is passed, when repository returns error, then should post network error state`() =
        runTest {
            val movieId = "id"
            coEvery { moviesRepository.getMovieDetails(movieId) } returns flowOf(
                ApiResponse.Error(
                    NullPointerException()
                )
            )
            val testResult = mutableListOf<MovieDetailsState>()
            val job = launch(Dispatchers.Main) {
                movieDetailsViewModel.state.toList(testResult)
            }

            movieDetailsViewModel.loadMovieDetails(movieId)

            assertThat(testResult).containsExactly(
                MovieDetailsState.Initial,
                MovieDetailsState.Loading,
                MovieDetailsState.NetworkError
            )
            job.cancel()
        }
}
