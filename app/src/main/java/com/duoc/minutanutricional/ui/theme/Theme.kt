package com.duoc.minutanutricional.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = GreenPrimary,
    onPrimary = NeutralSurface,
    primaryContainer = GreenContainer,
    onPrimaryContainer = GreenPrimaryDark,
    secondary = OrangeSecondary,
    onSecondary = NeutralSurface,
    secondaryContainer = OrangeContainer,
    onSecondaryContainer = OrangeSecondary,
    error = ErrorRed,
    background = NeutralBackground,
    onBackground = NeutralOnSurface,
    surface = NeutralSurface,
    onSurface = NeutralOnSurface,
    surfaceVariant = GreenContainer,
    onSurfaceVariant = NeutralOnSurfaceVariant
)

private val DarkColorScheme = darkColorScheme(
    primary = GreenLight,
    onPrimary = GreenPrimaryDark,
    primaryContainer = GreenPrimaryDark,
    onPrimaryContainer = GreenContainer,
    secondary = OrangeContainer,
    onSecondary = OrangeSecondary,
    error = ErrorRed
)

@Composable
fun MinutaNutricionalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
