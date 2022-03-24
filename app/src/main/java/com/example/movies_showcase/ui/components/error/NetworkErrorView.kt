package com.example.movies_showcase.ui.components.error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.movies_showcase.R
import com.example.movies_showcase.ui.theme.Dimens

@Composable
fun NetworkErrorView(
    onTryAgain: () -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colorScheme.onSurface
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.network_error_description),
            modifier = Modifier.padding(bottom = Dimens.paddingMedium),
            style = MaterialTheme.typography.bodyLarge.copy(color = textColor),
            textAlign = TextAlign.Center
        )
        OutlinedButton(onClick = onTryAgain) {
            Text(
                text = stringResource(id = R.string.try_again),
                style = MaterialTheme.typography.bodyLarge.copy(color = textColor)
            )
        }
    }
}
