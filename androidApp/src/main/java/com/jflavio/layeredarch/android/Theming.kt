package com.jflavio.layeredarch.android

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Theming
 *
 * @since 02/04/2022
 */

private val colors = darkColors(
    primary = Color(0xFF173592),
    onPrimary = Color(0xFFD6D6D6),
    primaryVariant = Color(0xFF4162D8),
    secondary = Color(0xFFAA4F4F),
    onSecondary = Color(0xFFD6D6D6),
    background = Color(0xFF0E1016),
    onBackground = Color(0xFFD6D6D6),
    onError = Color(0xF8B12D2D)
)

@Composable
fun MoviesAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = colors,
        content = content
    )
}