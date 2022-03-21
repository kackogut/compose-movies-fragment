package com.example.movies_showcase.feature.movies.movies_list.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movies_showcase.domain.model.movie.Movie
import com.example.movies_showcase.ui.theme.Dimens
import com.example.movies_showcase.ui.theme.Purple500
import com.example.movies_showcase.ui.theme.Purple700
import com.example.movies_showcase.ui.theme.Shapes

@Composable
fun MovieListItem(movie: Movie) {
    Row(
        modifier = Modifier
            .padding(top = Dimens.paddingMedium)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Purple500,
                        Purple700,
                    )
                ), shape = Shapes.large
            )
            .height(96.dp)
    ) {
        Spacer(modifier = Modifier.width(Dimens.paddingMedium))
        Poster(posterUrl = movie.posterUrl)

        Column(
            modifier = Modifier
                .padding(all = Dimens.paddingMedium)
                .weight(1F)
        ) {
            Title(title = movie.title)
            ReleaseYear(releaseYear = movie.releaseYear)
        }
    }
}

@Composable
fun Poster(posterUrl: String?) {
    AsyncImage(
        model = posterUrl,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(Dimens.smallImage)
            .padding(vertical = Dimens.paddingMedium)
            .clip(Shapes.large)
    )
}

@Composable
fun ColumnScope.Title(title: String) {
    Text(
        title,
        modifier = Modifier.weight(1F),
        style = MaterialTheme.typography.headlineSmall.copy(color = Color.White),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun ReleaseYear(releaseYear: String?) {
    Text(
        releaseYear ?: "",
        style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
        maxLines = 1
    )
}
