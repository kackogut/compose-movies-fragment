package com.example.movies_showcase.feature.movies.movies_list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies_showcase.data.model.response.ApiResponse
import com.example.movies_showcase.data.repository.MoviesRepositoryImpl
import com.example.movies_showcase.feature.movies.movies_list.state.MoviesListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(private val moviesRepository: MoviesRepositoryImpl) :
    ViewModel() {

    private val _state = MutableLiveData<MoviesListState>(MoviesListState.Initial)
    val state: LiveData<MoviesListState>
        get() = _state

    fun loadInitialMovies() {
        viewModelScope.launch {
            _state.value = MoviesListState.Loading

            moviesRepository.getMoviesList().collect { moviesResponse ->
                when (moviesResponse) {
                    is ApiResponse.Error -> _state.value = MoviesListState.Error
                    is ApiResponse.Success -> {
                        _state.value = MoviesListState.Movies(moviesResponse.data)
                    }
                }
            }
        }
    }
}
