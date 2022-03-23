package com.example.movies_showcase.data.mapper

import com.example.movies_showcase.data.model.movie.MovieDetailsDto
import com.example.movies_showcase.data.model.movie.MovieDetailsResponse
import com.example.movies_showcase.data.model.movie.MovieDto
import com.example.movies_showcase.data.model.movie.MoviesResponse
import com.example.movies_showcase.data.model.movie.dto.RatingSummaryDto
import com.example.movies_showcase.domain.model.movie.Movie
import com.example.movies_showcase.domain.model.movie.MovieDetails
import com.example.movies_showcase.domain.model.movie.ratings.Rating
import javax.inject.Inject

class MoviesMapper @Inject constructor() {

    fun mapMoviesListResponse(moviesResponse: MoviesResponse): List<Movie> {
        return moviesResponse.moviesList.map { movieDto -> listItemToDomainModel(movieDto) }
    }

    private fun listItemToDomainModel(movieDto: MovieDto): Movie {
        return with(movieDto) {
            Movie(
                id = id,
                title = titleText.title,
                posterUrl = primaryImage?.url,
                releaseYear = releaseDate?.year
            )
        }
    }

    fun mapMovieDetailsToDomainObject(movieDetailsResponse: MovieDetailsResponse): MovieDetails {
        return movieDetailsToDomainModel(movieDetailsResponse.movieDetails)
    }

    private fun movieDetailsToDomainModel(movieDetailsDto: MovieDetailsDto): MovieDetails {
        return with(movieDetailsDto) {
            MovieDetails(
                title = titleText.title,
                posterUrl = primaryImage?.url,
                releaseYear = releaseDate?.year,
                plot = plot?.plotText?.text,
                rating = ratings?.let(::ratingDtoToDomainModel),
                genres = genres?.genreDtos?.map { it.text } ?: listOf()
            )
        }
    }

    private fun ratingDtoToDomainModel(ratingSummaryDto: RatingSummaryDto): Rating {
        return with(ratingSummaryDto) {
            Rating(
                aggregate = aggregateRating,
                votesCount = voteCount
            )
        }
    }
}
