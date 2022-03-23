package com.example.movies_showcase.data.mapper

import com.example.movies_showcase.data.model.movie.MovieDto
import com.example.movies_showcase.data.model.movie.MoviesResponse
import com.example.movies_showcase.domain.model.movie.Movie
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
}
