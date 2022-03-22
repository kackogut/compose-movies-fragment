package com.example.movies_showcase.feature.movies.details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_showcase.data.model.response.ApiResponse
import com.example.movies_showcase.domain.repository.MoviesRepository
import com.example.movies_showcase.feature.movies.details.state.MovieDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesDetailsViewModel @Inject constructor(private val moviesRepository: MoviesRepository) :
    ViewModel() {

    private val _state: MutableStateFlow<MovieDetailsState> =
        MutableStateFlow(MovieDetailsState.Initial)
    val state = _state.asStateFlow()

    fun loadMovieDetails(movieId: String) {
        viewModelScope.launch {
            _state.value = MovieDetailsState.Loading

            moviesRepository.getMovieDetails(movieId).collect { moviesResponse ->
                when (moviesResponse) {
                    is ApiResponse.Error -> _state.value = MovieDetailsState.NetworkError
                    is ApiResponse.Success -> {
                        _state.value = MovieDetailsState.Movie(moviesResponse.data)
                    }
                }
            }
        }
    }
}
