package com.example.movies_showcase.ui.components.error

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.movies_showcase.ui.components.NetworkErrorView
import com.example.movies_showcase.ui.theme.MoviesShowcaseTheme

@Preview(widthDp = 340, name = "340 width")
@Composable
fun NetworkErrorViewPreview340() {
    MoviesShowcaseTheme {
        NetworkErrorView(onTryAgain = {})
    }
}
