package com.example.movies_showcase.data.model.movie

object MovieDtoUtil {

    fun createMovieDto(
        id: String = "id",
        title: String = "title",
        posterUrl: String? = "url",
        releaseYear: String? = "1994"
    ): MovieDto {
        return MovieDto(
            id = id,
            titleText = TitleTextDto(title),
            primaryImage = posterUrl?.let { PrimaryImageDto(posterUrl) },
            releaseDate = releaseYear?.let { ReleaseDateDto(releaseYear) }
        )
    }
}
