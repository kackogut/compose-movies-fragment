package com.example.movies_showcase.data.model.movie

import com.squareup.moshi.Json

data class MovieDto(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "titleText") val titleText: TitleTextDto,
    @field:Json(name = "primaryImage") val primaryImage: PrimaryImageDto?,
    @field:Json(name = "releaseDate") val releaseDate: ReleaseDateDto?
)

data class TitleTextDto(
    @field:Json(name = "text") val title: String
)

data class PrimaryImageDto(
    @field:Json(name = "url") val url: String
)

data class ReleaseDateDto(
    @field:Json(name = "year") val year: String
)
