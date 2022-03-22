package com.example.movies_showcase.data.model.movie

import com.example.movies_showcase.data.model.movie.dto.PrimaryImageDto
import com.example.movies_showcase.data.model.movie.dto.ReleaseDateDto
import com.example.movies_showcase.data.model.movie.dto.TitleTextDto
import com.squareup.moshi.Json

data class MovieDetailsDto(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "titleText") val titleText: TitleTextDto,
    @field:Json(name = "primaryImage") val primaryImage: PrimaryImageDto?,
    @field:Json(name = "releaseDate") val releaseDate: ReleaseDateDto?
)
