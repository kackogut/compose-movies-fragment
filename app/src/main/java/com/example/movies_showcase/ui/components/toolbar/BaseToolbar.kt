package com.example.movies_showcase.ui.components.toolbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.example.movies_showcase.ui.theme.Dimens

@Composable
fun BaseToolbar(title: String) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(
                vertical = Dimens.paddingMedium,
                horizontal = Dimens.baseHorizontalPadding
            )
        )
    }
}
