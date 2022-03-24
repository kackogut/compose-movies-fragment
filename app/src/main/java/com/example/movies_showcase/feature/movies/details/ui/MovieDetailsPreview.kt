package com.example.movies_showcase.feature.movies.details.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.movies_showcase.domain.model.movie.MovieDetails
import com.example.movies_showcase.domain.model.movie.ratings.Rating
import com.example.movies_showcase.feature.movies.details.ui.components.MovieDetailsView
import com.example.movies_showcase.ui.theme.MoviesShowcaseTheme

@Preview(widthDp = 340, name = "340 width", showBackground = true, backgroundColor = 0x000000)
@Composable
fun MovieDetailsPreview340() {
    MoviesShowcaseTheme {
        MovieDetailsView(mockedMovieDetails)
    }
}

@Preview(
    widthDp = 340,
    name = "340 width long title",
    showBackground = true,
    backgroundColor = 0x000000
)
@Composable
fun MovieDetailsPreviewLongTitle340() {
    MoviesShowcaseTheme {
        MovieDetailsView(
            mockedMovieDetails.copy(
                title = "Very very very very very very very very very very very very very very very long title"
            )
        )
    }
}

private val mockedMovieDetails = MovieDetails(
    title = "Movie title",
    plot = "This is plot of the movie, it's very interesting movie, you can't miss it",
    rating = Rating(
        votesCount = 1234,
        aggregate = 6.3F
    ),
    genres = listOf("Action", "Adventure"),
    releaseYear = "2012",
    posterUrl = ""
)
