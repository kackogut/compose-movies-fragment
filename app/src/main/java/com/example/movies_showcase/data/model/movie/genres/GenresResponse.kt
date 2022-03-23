package com.example.movies_showcase.data.model.movie.genres

import com.squareup.moshi.Json

data class GenresResponse(
    @field:Json(name = "genres") val genreDtos: List<GenreDto>
)
