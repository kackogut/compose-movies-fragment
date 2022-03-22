package com.example.movies_showcase.data.mapper

import com.example.movies_showcase.data.model.movie.MovieDto
import com.example.movies_showcase.data.model.movie.MovieDtoUtil
import com.example.movies_showcase.data.model.movie.MoviesResponse
import com.example.movies_showcase.domain.model.movie.Movie
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
}
