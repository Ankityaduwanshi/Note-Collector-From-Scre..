package com.example.notecollector.utilities

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.notecollector.ui.theme.md_theme_dark_CardColorBlueContainer
import com.example.notecollector.ui.theme.md_theme_light_CardColorBlueContainer

@Composable
fun ColorManger():Color {
    // For manage or fide is theme is light or dark
    val useDarkTheme: Boolean = isSystemInDarkTheme()
    if (!useDarkTheme) {
   return md_theme_light_CardColorBlueContainer
} else {
   return md_theme_dark_CardColorBlueContainer
}
}