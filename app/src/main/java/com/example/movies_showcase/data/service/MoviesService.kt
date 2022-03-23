package com.example.movies_showcase.data.service

import com.example.movies_showcase.data.model.movie.MovieDetailsResponse
import com.example.movies_showcase.data.model.movie.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {

    @GET("/titles")
    suspend fun getMovies(
        @Query(value = "page") page: String,
        @Query(value = "year") year: String = "2021"
    ): Response<MoviesResponse>

    @GET("/titles/{title_id}")
    suspend fun getMovieDetails(@Path("title_id") movieId: String): Response<MovieDetailsResponse>
}
