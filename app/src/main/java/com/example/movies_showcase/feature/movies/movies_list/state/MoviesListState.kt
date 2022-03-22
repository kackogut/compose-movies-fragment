package com.example.movies_showcase.feature.movies.movies_list.state

import com.example.movies_showcase.domain.model.movie.Movie

sealed class MoviesListState {

    object Initial : MoviesListState()
    object Loading : MoviesListState()
    data class Movies(val movies: List<Movie>) : MoviesListState()
    object Error : MoviesListState()
}
