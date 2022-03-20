package com.example.movies_showcase.feature.movies.movies_list.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movies_showcase.domain.model.movie.Movie
import com.example.movies_showcase.ui.theme.Dimens
import com.example.movies_showcase.ui.theme.Shapes

@Composable
fun MovieListItem(movie: Movie) {
    Row(
        modifier = Modifier
            .padding(top = Dimens.paddingMedium)
            .background(color = MaterialTheme.colorScheme.primary, shape = Shapes.large)
            .height(96.dp)
    ) {
        Spacer(modifier = Modifier.width(Dimens.paddingMedium))

        AsyncImage(
            model = movie.posterUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(Dimens.smallImage)
                .padding(vertical = Dimens.paddingMedium)
                .clip(Shapes.large)
        )

        Column(
            modifier = Modifier
                .padding(all = Dimens.paddingMedium)
                .weight(1F)
        ) {
            Text(
                movie.title,
                modifier = Modifier.weight(1F),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                movie.releaseYear ?: "",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color.White
                )
            )
        }
    }
}
