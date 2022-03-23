package com.example.movies_showcase.data.model.movie

import com.squareup.moshi.Json

data class MoviesResponse(
    @field:Json(name = "results") val moviesList: List<MovieDto>
)
