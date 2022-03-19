package com.example.movies_showcase.data.repository

import com.example.movies_showcase.data.model.movie.MoviesResponse
import com.example.movies_showcase.data.service.MoviesService
import com.example.movies_showcase.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val moviesService: MoviesService) :
    MoviesRepository {

    override suspend fun getMoviesList(): Flow<MoviesResponse> {
        return flow<MoviesResponse> {
            emit(moviesService.getMovies().body()!!)
        }.flowOn(Dispatchers.IO)
    }
}
