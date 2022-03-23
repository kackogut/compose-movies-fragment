package com.example.movies_showcase.data.model.movie.dto

import com.squareup.moshi.Json

data class PlotTextDto(
    @field:Json(name = "plainText") val plainText: String
)
