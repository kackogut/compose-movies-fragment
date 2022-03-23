package com.example.movies_showcase.feature.movies.details.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movies_showcase.domain.model.movie.MovieDetails
import com.example.movies_showcase.ui.theme.Dimens

@Composable
fun MovieDetailsView(movieDetails: MovieDetails) {
    Row(
        modifier = Modifier.padding(horizontal = Dimens.baseHorizontalPadding)
    ) {
        MovieDetailsToolbar(movieDetails)
    }
}
