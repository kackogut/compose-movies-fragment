package com.example.movies_showcase.feature.movies.details.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.movies_showcase.feature.movies.details.viewmodel.MoviesDetailsViewModel
import com.example.movies_showcase.ui.theme.MoviesShowcaseTheme
import com.example.movies_showcase.ui.theme.Purple500
import com.example.movies_showcase.ui.theme.Purple700
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
            val listState = viewModel.state.collectAsState()

            MoviesShowcaseTheme {
                Surface(
                    modifier = Modifier.background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Purple700,
                                Purple500,
                            )
                        ),
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(listState.value.toString())
                    }
                }
            }
        }
    }
}
