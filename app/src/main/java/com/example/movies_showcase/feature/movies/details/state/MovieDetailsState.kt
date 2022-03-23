package com.example.movies_showcase.feature.movies.details.state

import com.example.movies_showcase.domain.model.movie.MovieDetails

sealed class MovieDetailsState {
    object Initial : MovieDetailsState()
    object Loading : MovieDetailsState()
    data class Movie(val movieDetails: MovieDetails) : MovieDetailsState()
    object NetworkError : MovieDetailsState()
}
