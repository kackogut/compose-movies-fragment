package com.example.movies_showcase.feature.movies.movies_list.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.movies_showcase.domain.model.movie.Movie
import com.example.movies_showcase.feature.movies.movies_list.ui.components.MoviesList
import com.example.movies_showcase.ui.theme.MoviesShowcaseTheme

@Preview(widthDp = 340, name = "340 width")
@Composable
fun MovieListPreview340() {
    MoviesShowcaseTheme {
        MoviesList(mockedMoviesList)
    }
}

val mockedMoviesList = listOf(
    Movie(
        id = "id",
        title = "Movie title",
        posterUrl = "https://m.media-amazon.com/images/M/MV5BNDk0NjcyMGUtNjZhOC00NDRmLWFhNGMtYzNlMDc2NTA2YjVmXkEyXkFqcGdeQXV",
        releaseYear = "1994"
    )
)
