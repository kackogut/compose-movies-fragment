package com.example.movies_showcase.ui.components.error

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.movies_showcase.ui.theme.MoviesShowcaseTheme
import com.example.movies_showcase.ui.theme.baseGradient

@Preview(widthDp = 340, name = "340 width", showBackground = true)
@Composable
fun NetworkErrorViewPreview340OnBackground() {
    MoviesShowcaseTheme {
        NetworkErrorView(onTryAgain = {}, textColor = MaterialTheme.colorScheme.onSurface)
    }
}

@Preview(widthDp = 340, name = "340 width")
@Composable
fun NetworkErrorViewPreview340OnGradient() {
    MoviesShowcaseTheme {
        Box(Modifier.background(brush = baseGradient)) {
            NetworkErrorView(
                onTryAgain = {},
                textColor = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
