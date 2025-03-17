package com.devaeon.todoCompose.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    secondary = Secondary,
    tertiary = Tertiary
)

@Composable
fun TodoTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = LightColorScheme) {
        content()
    }
}
