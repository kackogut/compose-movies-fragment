package com.example.movies_showcase.data.model.movie

import com.example.movies_showcase.data.model.movie.dto.*
import com.example.movies_showcase.data.model.movie.genres.GenreDto
import com.example.movies_showcase.data.model.movie.genres.GenresResponse

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

    fun createMovieDetailsDto(
        id: String = "id",
        title: String = "title",
        posterUrl: String? = "url",
        releaseYear: String? = "1994",
        plot: String? = "plot",
        genres: List<String> = listOf("drama", "queen"),
        votesCount: Int = 12,
        rating: Float = 6.0F
    ): MovieDetailsDto {
        return MovieDetailsDto(
            id = id,
            titleText = TitleTextDto(title),
            primaryImage = posterUrl?.let { PrimaryImageDto(posterUrl) },
            releaseDate = releaseYear?.let { ReleaseDateDto(releaseYear) },
            plot = plot?.let { PlotTextDto(PlotPlainText(plot)) },
            genres = GenresResponse(genres.map { GenreDto("id", it) }),
            ratings = RatingSummaryDto(aggregateRating = rating, voteCount = votesCount)
        )
    }
}
