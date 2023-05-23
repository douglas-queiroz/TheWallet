package com.douglasqueiroz.thewallet.feature.settings

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = "Settings"
    )
}

@Preview
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}