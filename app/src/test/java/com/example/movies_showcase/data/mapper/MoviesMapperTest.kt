package com.example.movies_showcase.data.mapper

import com.example.movies_showcase.data.model.movie.*
import com.example.movies_showcase.domain.model.movie.Movie
import com.example.movies_showcase.domain.model.movie.MovieDetails
import com.example.movies_showcase.domain.model.movie.ratings.Rating
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MoviesMapperTest {

    private val sut = MoviesMapper()

    @Test
    fun `Given that movies response model is passed, when mapMoviesListResponse is called, then should map to a domain model`() {
        val movieDto = MovieDtoUtil.createMovieDto()
        val moviesResponse = MoviesResponse(listOf(movieDto))

        val mappedModel = sut.mapMoviesListResponse(moviesResponse)

        assertThat(mappedModel).isEqualTo(listOf(getExpectedDomainMovieModelFromDto(movieDto)))
    }

    @Test
    fun `Given that movies response model that is passed contains null values, when mapMoviesListResponse is called, then should map to a domain model`() {
        val movieDto = MovieDtoUtil.createMovieDto(posterUrl = null, releaseYear = null)
        val moviesResponse = MoviesResponse(listOf(movieDto))

        val mappedModel = sut.mapMoviesListResponse(moviesResponse)

        assertThat(mappedModel).isEqualTo(listOf(getExpectedDomainMovieModelFromDto(movieDto)))
    }

    @Test
    fun `Given that movie details response model is passed, when mapMoviesListResponse is called, then should map to a domain model`() {
        val movieDetailsDto = MovieDtoUtil.createMovieDetailsDto()
        val moviesDetailsResponse = MovieDetailsResponse(movieDetailsDto)

        val mappedModel = sut.mapMovieDetailsToDomainObject(moviesDetailsResponse)

        assertThat(mappedModel).isEqualTo(getExpectedDomainMovieDetailsModelFromDto(movieDetailsDto))
    }

    @Test
    fun `Given that movie details response model that is passed contains null values, when mapMoviesListResponse is called, then should map to a domain model`() {
        val movieDetailsDto =
            MovieDtoUtil.createMovieDetailsDto(posterUrl = null, releaseYear = null, plot = null)
        val moviesDetailsResponse = MovieDetailsResponse(movieDetailsDto)

        val mappedModel = sut.mapMovieDetailsToDomainObject(moviesDetailsResponse)

        assertThat(mappedModel).isEqualTo(getExpectedDomainMovieDetailsModelFromDto(movieDetailsDto))
    }

    private fun getExpectedDomainMovieModelFromDto(movieDto: MovieDto): Movie {
        return with(movieDto) {
            Movie(
                id = id,
                title = titleText.title,
                posterUrl = primaryImage?.url,
                releaseYear = releaseDate?.year
            )
        }
    }

    private fun getExpectedDomainMovieDetailsModelFromDto(movieDetailsDto: MovieDetailsDto): MovieDetails {
        return with(movieDetailsDto) {
            MovieDetails(
                title = titleText.title,
                posterUrl = primaryImage?.url,
                releaseYear = releaseDate?.year,
                genres = genres?.genreDtos?.map { it.text } ?: emptyList(),
                rating = ratings?.let {
                    Rating(
                        aggregate = it.aggregateRating,
                        votesCount = it.voteCount
                    )
                },
                plot = plot?.plotText?.text
            )
        }
    }
}
