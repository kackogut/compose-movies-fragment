package com.example.movies_showcase.domain.model.movie

import com.example.movies_showcase.domain.model.movie.ratings.Rating

data class MovieDetails(
    val title: String,
    val posterUrl: String?,
    val releaseYear: String?,
    val plot: String?,
    val genres: List<String>,
    val rating: Rating?
)
