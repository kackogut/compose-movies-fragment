package com.example.movies_showcase.feature.movies.details.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.movies_showcase.R
import com.example.movies_showcase.ui.theme.Dimens

@Composable
fun MovieRating(rating: Float, votesCount: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = Dimens.paddingMedium)
    ) {
        Icon(
            imageVector = Icons.Outlined.Star,
            contentDescription = stringResource(id = R.string.content_description_rating_star),
            tint = Color.Yellow,
            modifier = Modifier
                .padding(end = Dimens.paddingSmall)
                .size(Dimens.largeIconSize)
        )

        Text(rating.toString(), style = MaterialTheme.typography.headlineLarge)

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(start = Dimens.paddingSmall)
        ) {
            Text(votesCount.toString(), style = MaterialTheme.typography.bodySmall)
            Text(stringResource(R.string.votes), style = MaterialTheme.typography.bodySmall)
        }
    }
}
