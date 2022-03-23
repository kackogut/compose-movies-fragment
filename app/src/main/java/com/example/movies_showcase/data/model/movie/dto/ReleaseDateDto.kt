package com.example.movies_showcase.data.model.movie.dto

import com.squareup.moshi.Json

data class ReleaseDateDto(
    @field:Json(name = "year") val year: String
)
