package com.example.movies_showcase.domain.repository

import com.example.movies_showcase.data.model.movie.MoviesResponse
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    suspend fun getMoviesList(): Flow<MoviesResponse>
}
