package com.example.movies_showcase.feature.movies.movies_list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.movies_showcase.feature.movies.movies_list.state.MoviesListState
import com.example.movies_showcase.feature.movies.movies_list.ui.components.MoviesList
import com.example.movies_showcase.feature.movies.movies_list.viewmodel.MoviesListViewModel
import com.example.movies_showcase.ui.theme.MoviesShowcaseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesListFragment : Fragment() {

    private val viewModel: MoviesListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        viewModel.loadInitialMovies()

        setContent {
            val state by viewModel.state.observeAsState()

            MoviesShowcaseTheme {
                Surface(
                    color = MaterialTheme.colorScheme.surface
                ) {

                }
                when (val uiState = state) {
                    is MoviesListState.Loading -> Text("Loading")
                    MoviesListState.Error -> Text("Error")
                    MoviesListState.Initial -> Text("Initial")
                    is MoviesListState.Movies -> MoviesList(uiState.movies)
                    null -> Text("null")
                }
            }
        }
    }
}
