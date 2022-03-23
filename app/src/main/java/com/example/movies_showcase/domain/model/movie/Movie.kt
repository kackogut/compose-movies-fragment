package com.example.movies_showcase.domain.model.movie

data class Movie(
    val id: String,
    val title: String,
    val posterUrl: String?,
    val releaseYear: String?
)
