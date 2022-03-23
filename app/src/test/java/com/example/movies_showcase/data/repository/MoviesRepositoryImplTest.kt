package com.example.movies_showcase.data.repository

import com.example.movies_showcase.data.handler.ResponseHandler
import com.example.movies_showcase.data.mapper.MoviesMapper
import com.example.movies_showcase.data.model.movie.MoviesResponse
import com.example.movies_showcase.data.model.response.ApiResponse
import com.example.movies_showcase.data.service.MoviesService
import com.example.movies_showcase.domain.model.movie.Movie
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Test
import retrofit2.Response

class MoviesRepositoryImplTest {

    private val moviesMapper = mockk<MoviesMapper>()
    private val moviesService = mockk<MoviesService>()
    private val responseHandler = ResponseHandler()

    private val sut by lazy { MoviesRepositoryImpl(responseHandler, moviesService, moviesMapper) }

    @Test
    fun `Given that service returns error, when getMoviesList is called, then should return Error`() =
        runBlocking {
            val page = 2
            val response = Response.error<MoviesResponse>(500, "".toResponseBody())
            coEvery { moviesService.getMovies(page.toString()) } returns response

            val returnedValue = sut.getMoviesList(page).first()

            assertThat(returnedValue).isInstanceOf(ApiResponse.Error::class.java)
        }

    @Test
    fun `Given that service return movies list, when getMoviesList is called, then should map the response and return Success with domain model`() =
        runBlocking {
            val page = 2
            val responseData = mockk<MoviesResponse>()
            val mappedData = mockk<List<Movie>>()
            val response = Response.success(responseData)
            every { moviesMapper.mapMoviesListResponse(responseData) } returns mappedData
            coEvery { moviesService.getMovies(page.toString()) } returns response

            val returnedValue = sut.getMoviesList(page).first()

            assertThat(returnedValue).isEqualTo(ApiResponse.Success(mappedData))
        }
}
