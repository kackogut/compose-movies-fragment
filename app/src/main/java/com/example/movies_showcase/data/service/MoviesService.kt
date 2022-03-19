package com.example.movies_showcase.data.service

import com.example.movies_showcase.data.model.movie.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET

interface MoviesService {

    @GET("/titles")
    suspend fun getMovies(): Response<MoviesResponse>
}
