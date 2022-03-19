package com.example.movies_showcase.data.model.movie

import com.squareup.moshi.Json

data class MovieDto(
    @field:Json(name = "id") val id: String
)
