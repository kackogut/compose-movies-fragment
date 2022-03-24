package com.example.movies_showcase.feature.movies.details.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.movies_showcase.feature.movies.details.state.MovieDetailsState
import com.example.movies_showcase.feature.movies.details.ui.components.MovieDetailsView
import com.example.movies_showcase.feature.movies.details.viewmodel.MoviesDetailsViewModel
import com.example.movies_showcase.ui.components.error.NetworkErrorView
import com.example.movies_showcase.ui.components.loading.LoadingView
import com.example.movies_showcase.ui.theme.MoviesShowcaseTheme
import com.example.movies_showcase.ui.theme.baseGradient
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesDetailsFragment : Fragment() {

    val args: MoviesDetailsFragmentArgs by navArgs()
    private val viewModel: MoviesDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        setContent {
            viewModel.loadMovieDetails(args.movieId)
            val listState by viewModel.state.collectAsState()

            MoviesShowcaseTheme {
                Surface {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(brush = baseGradient)
                    ) {
                        Content(listState)
                    }
                }
            }
        }
    }

    @Composable
    fun Content(state: MovieDetailsState) {
        when (state) {
            MovieDetailsState.Initial,
            MovieDetailsState.Loading -> {
                LoadingView(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Transparent)
                )
            }
            is MovieDetailsState.Movie -> {
                MovieDetailsView(state.movieDetails)
            }
            MovieDetailsState.NetworkError -> {
                NetworkErrorView(
                    onTryAgain = { viewModel.loadMovieDetails(args.movieId) },
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Transparent),
                    textColor = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}
