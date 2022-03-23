package com.example.movies_showcase.data.model.movie

import com.example.movies_showcase.data.model.movie.dto.*
import com.example.movies_showcase.data.model.movie.genres.GenresResponse
import com.squareup.moshi.Json

data class MovieDetailsDto(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "titleText") val titleText: TitleTextDto,
    @field:Json(name = "primaryImage") val primaryImage: PrimaryImageDto?,
    @field:Json(name = "releaseDate") val releaseDate: ReleaseDateDto?,
    @field:Json(name = "plot") val plot: PlotTextDto?,
    @field:Json(name = "genres") val genres: GenresResponse?,
    @field:Json(name = "ratingsSummary") val ratings: RatingSummaryDto?,
)
