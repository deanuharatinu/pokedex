package com.deanuharatinu.pokedex.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
  primary = PrimaryColor,
  primaryVariant = PrimaryColorVariant,
  secondary = ColorAccent
)

private val LightColorPalette = lightColors(
  primary = PrimaryColor,
  primaryVariant = PrimaryColorVariant,
  secondary = ColorAccent
)

@Composable
fun AppTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {
  val colors = if (darkTheme) {
    DarkColorPalette
  } else {
    LightColorPalette
  }

  MaterialTheme(
    colors = colors,
    typography = Typography,
    shapes = Shapes,
    content = content
  )
}
