package com.example.movies_showcase.feature.movies.details.ui.components

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import com.example.movies_showcase.R
import com.example.movies_showcase.domain.model.movie.MovieDetails
import com.example.movies_showcase.ui.theme.Dimens

@Composable
fun MovieDetailsToolbar(movieDetails: MovieDetails) {
    val dispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    Column {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .padding(vertical = Dimens.paddingMedium)
                .clickable {
                    dispatcher?.onBackPressed()
                },
        )
        Row {
            AsyncImage(
                model = movieDetails.posterUrl,
                contentDescription = stringResource(id = R.string.content_description_image_poster),
                modifier = Modifier
                    .width(Dimens.smallImage)
                    .height(Dimens.smallImage)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
            )

            Text(
                text = movieDetails.title,
                style = MaterialTheme.typography.titleLarge.copy(color = Color.White),
                modifier = Modifier.padding(start = Dimens.paddingMedium)
            )
        }
    }
}
