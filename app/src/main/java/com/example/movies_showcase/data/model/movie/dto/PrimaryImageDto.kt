package com.example.movies_showcase.data.model.movie.dto

import com.squareup.moshi.Json

data class PrimaryImageDto(
    @field:Json(name = "url") val url: String
)
