package com.example.movies_showcase.data.model.movie.dto

import com.squareup.moshi.Json

data class RatingSummaryDto(
    @field:Json(name = "aggregateRating") val aggregateRating: Float?,
    @field:Json(name = "voteCount") val voteCount: Int
)
