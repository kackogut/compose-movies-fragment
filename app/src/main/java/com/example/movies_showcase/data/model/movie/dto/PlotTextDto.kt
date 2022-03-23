package com.example.movies_showcase.data.model.movie.dto

import com.squareup.moshi.Json

data class PlotTextDto(
    @field:Json(name = "plotText") val plotText: PlotPlainText
)

data class PlotPlainText(
    @field:Json(name = "plainText") val text: String
)
