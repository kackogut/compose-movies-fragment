package com.example.movies_showcase.feature.movies.details.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.movies_showcase.R
import com.example.movies_showcase.domain.model.movie.MovieDetails
import com.example.movies_showcase.ui.theme.Dimens

@Composable
fun MovieDetailsView(movieDetails: MovieDetails) {
    Column(
        modifier = Modifier
            .padding(horizontal = Dimens.baseHorizontalPadding)
            .verticalScroll(rememberScrollState())
    ) {
        with(movieDetails) {
            MovieDetailsToolbar(movieDetails)

            rating?.aggregate?.let { ratingAggregate ->
                MovieRating(rating = ratingAggregate, votesCount = rating.votesCount)
            }
            releaseYear?.let {
                MovieDetailsOverview(title = "Release year", description = releaseYear)
            }
            plot?.let {
                MovieDetailsOverview(
                    title = stringResource(R.string.overview),
                    description = it
                )
            }
            MovieDetailsOverview(
                title = stringResource(R.string.genres),
                description = genres.joinToString(", ")
            ).takeIf { genres.isNotEmpty() }
        }
    }
}
