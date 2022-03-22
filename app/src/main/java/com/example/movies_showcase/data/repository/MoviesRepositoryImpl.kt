package com.example.movies_showcase.data.repository

import com.example.movies_showcase.data.handler.ResponseHandler
import com.example.movies_showcase.data.mapper.MoviesMapper
import com.example.movies_showcase.data.model.response.ApiResponse
import com.example.movies_showcase.data.service.MoviesService
import com.example.movies_showcase.domain.model.movie.Movie
import com.example.movies_showcase.domain.model.movie.MovieDetails
import com.example.movies_showcase.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val responseHandler: ResponseHandler,
    private val moviesService: MoviesService,
    private val moviesMapper: MoviesMapper
) : MoviesRepository {

    override suspend fun getMoviesList(page: Int): Flow<ApiResponse<List<Movie>>> {
        return flow {
            responseHandler.handleApiCall { moviesService.getMovies(page.toString()) }
                .run { mapData(moviesMapper::mapMoviesListResponse) }
                .also { emit(it) }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getMovieDetails(movieId: String): Flow<ApiResponse<MovieDetails>> {
        return flow {
            responseHandler.handleApiCall { moviesService.getMovieDetails(movieId) }
                .run { mapData(moviesMapper::movieDetailsToDomainModel) }
                .also { emit(it) }
        }.flowOn(Dispatchers.IO)
    }
}
