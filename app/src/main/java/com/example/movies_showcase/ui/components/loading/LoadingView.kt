package com.example.movies_showcase.ui.components.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.movies_showcase.ui.theme.Dimens

@Composable
fun LoadingView(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Card(elevation = Dimens.elevationMedium) {
            CircularProgressIndicator(modifier = Modifier.padding(Dimens.paddingLarge))
        }
    }
}
