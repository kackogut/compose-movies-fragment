package com.example.movies_showcase.data.model.movie

import com.squareup.moshi.Json

data class MovieDetailsResponse(
    @field:Json(name = "results") val movieDetails: MovieDetailsDto
)
