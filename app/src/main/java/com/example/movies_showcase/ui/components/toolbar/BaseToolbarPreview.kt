package com.example.movies_showcase.ui.components.toolbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.movies_showcase.ui.theme.MoviesShowcaseTheme

@Preview(widthDp = 340, name = "340 width")
@Composable
fun BaseToolbarPreview340() {
    MoviesShowcaseTheme {
        BaseToolbar(title = "Small title")
    }
}

@Preview(widthDp = 340, name = "340 width")
@Composable
fun BaseToolbarLongTitlePreview340() {
    MoviesShowcaseTheme {
        BaseToolbar(title = "Very very long title, it should not be that long, but still")
    }
}
