package com.example.movies_showcase.feature.movies.movies_list.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movies_showcase.domain.model.movie.Movie
import com.example.movies_showcase.ui.theme.Dimens

@Composable
fun MoviesList(movies: List<Movie>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.paddingLarge)
    ) {
        items(movies) { movie ->
            MovieListItem(movie)
        }
    }
}
