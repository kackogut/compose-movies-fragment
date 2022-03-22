package com.example.movies_showcase.feature.movies.movies_list.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.example.movies_showcase.domain.model.movie.Movie
import com.example.movies_showcase.ui.components.NetworkErrorView
import com.example.movies_showcase.ui.components.loading.LoadingView
import com.example.movies_showcase.ui.theme.Dimens

@Composable
fun MoviesList(
    movies: LazyPagingItems<Movie>,
    listState: LazyListState,
    onMovieClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.baseHorizontalPadding),
        state = listState
    ) {
        items(movies) { movie ->
            movie?.let { MovieListItem(movie, onMovieClick) }
        }

        when {
            movies.loadState.append is LoadState.Loading -> {
                item { LoadingView(modifier = Modifier.fillParentMaxWidth()) }
            }
            movies.loadState.refresh is LoadState.Loading -> {
                item { LoadingView(modifier = Modifier.fillParentMaxSize()) }
            }
            movies.loadState.append is LoadState.Error -> {
                item {
                    NetworkErrorView(
                        onTryAgain = { movies.retry() },
                        modifier = Modifier.fillParentMaxWidth()
                    )
                }
            }
            movies.loadState.refresh is LoadState.Error -> {
                item {
                    NetworkErrorView(
                        onTryAgain = { movies.retry() },
                        modifier = Modifier.fillParentMaxSize()
                    )
                }
            }
        }
    }
}
