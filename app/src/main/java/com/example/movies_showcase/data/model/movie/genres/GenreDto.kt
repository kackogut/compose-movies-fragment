package com.example.movies_showcase.data.model.movie.genres

import com.squareup.moshi.Json

data class GenreDto(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "text") val text: String
)
