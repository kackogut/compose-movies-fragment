package com.example.movies_showcase.data.model.movie.dto

import com.squareup.moshi.Json

data class TitleTextDto(
    @field:Json(name = "text") val title: String
)
