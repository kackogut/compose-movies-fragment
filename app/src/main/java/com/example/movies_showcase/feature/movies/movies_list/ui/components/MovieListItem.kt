package com.example.movies_showcase.feature.movies.movies_list.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movies_showcase.R
import com.example.movies_showcase.domain.model.movie.Movie
import com.example.movies_showcase.ui.theme.Dimens
import com.example.movies_showcase.ui.theme.Shapes
import com.example.movies_showcase.ui.theme.baseGradient

@Composable
fun MovieListItem(movie: Movie, onMovieClick: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = Dimens.paddingMedium)
            .background(
                brush = baseGradient,
                shape = Shapes.large
            )
            .clip(shape = Shapes.large)
            .height(122.dp)
            .clickable(
                onClick = {
                    onMovieClick(movie.id)
                }
            )
    ) {
        Spacer(modifier = Modifier.width(Dimens.paddingLarge))
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
private fun Poster(posterUrl: String?) {
    if (posterUrl == null) {
        Icon(
            imageVector = Icons.Outlined.Movie,
            contentDescription = stringResource(id = R.string.content_description_image_poster),
            tint = Color.White,
            modifier = Modifier
                .padding(vertical = Dimens.paddingMedium)
                .background(color = Color.Gray, shape = Shapes.medium)
                .width(Dimens.mediumImage)
                .fillMaxHeight()
        )
    } else {
        AsyncImage(
            model = posterUrl,
            contentDescription = stringResource(id = R.string.content_description_image_poster),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(Dimens.mediumImage)
                .padding(vertical = Dimens.paddingMedium)
                .clip(Shapes.medium)
        )
    }
}

@Composable
private fun ColumnScope.Title(title: String) {
    Text(
        title,
        modifier = Modifier.weight(1F),
        style = MaterialTheme.typography.titleSmall,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
private fun ReleaseYear(releaseYear: String?) {
    Text(
        releaseYear ?: "",
        style = MaterialTheme.typography.bodySmall,
        maxLines = 1
    )
}
