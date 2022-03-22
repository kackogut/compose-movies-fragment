package com.example.movies_showcase.feature.movies.movies_list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.movies_showcase.R
import com.example.movies_showcase.feature.movies.movies_list.ui.components.MoviesList
import com.example.movies_showcase.feature.movies.movies_list.viewmodel.MoviesListViewModel
import com.example.movies_showcase.ui.components.toolbar.BaseToolbar
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
        setContent {
            val movies = viewModel.movies.collectAsLazyPagingItems()

            MoviesShowcaseTheme {
                Surface(
                    color = MaterialTheme.colorScheme.surface,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Column {
                        BaseToolbar(title = stringResource(R.string.movies_list_title))
                        MoviesList(movies = movies)
                    }
                }
            }
        }
    }
}
