package com.example.movies_showcase.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Blue200,
    secondary = Blue700,
    onSurface = White,
    surface = Black800
)

private val LightColorScheme = lightColorScheme(
    primary = Blue200,
    secondary = Blue700,
    onSurface = Black800,
    surface = White
)

@Composable
fun MoviesShowcaseTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
