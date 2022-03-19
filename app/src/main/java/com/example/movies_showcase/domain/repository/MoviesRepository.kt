package com.example.movies_showcase.domain.repository

import com.example.movies_showcase.data.model.response.ApiResponse
import com.example.movies_showcase.domain.model.movie.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    suspend fun getMoviesList(): Flow<ApiResponse<List<Movie>>>
}
