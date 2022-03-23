package com.example.movies_showcase.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.movies_showcase.R
import com.example.movies_showcase.ui.theme.Dimens

@Composable
fun NetworkErrorView(onTryAgain: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.network_error_description),
            modifier = Modifier.padding(bottom = Dimens.paddingMedium),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        OutlinedButton(onClick = onTryAgain) {
            Text(text = stringResource(id = R.string.try_again))
        }
    }
}
