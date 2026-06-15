package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = BrightSky,
    secondary = BrightGreen,
    tertiary = BrightClay,
    background = DarkNavy,
    surface = DarkCard,
    onPrimary = PrimaryNavy,
    onSecondary = PrimaryNavy,
    onTertiary = PrimaryNavy,
    onBackground = OffWhiteSlate,
    onSurface = OffWhiteSlate
)

private val LightColorScheme = lightColorScheme(
    primary = BentoPrimary,
    secondary = BentoSecondary,
    tertiary = BentoGold,
    background = BentoBackground,
    surface = BentoSurface,
    onPrimary = Color.White,
    onSecondary = BentoOnSurface,
    onTertiary = Color.White,
    onBackground = BentoTextDark,
    onSurface = BentoTextDark
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Set to false to force our distinctive physical-geography brand
    content: @Composable () -> Unit,
) {
  val colorScheme =
    when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }

      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
