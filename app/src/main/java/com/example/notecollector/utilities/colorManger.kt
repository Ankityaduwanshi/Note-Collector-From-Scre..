package com.example.notecollector.utilities

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.notecollector.ui.theme.md_theme_dark_CardColorBlueContainer
import com.example.notecollector.ui.theme.md_theme_dark_CardColorLavenderContainer
import com.example.notecollector.ui.theme.md_theme_dark_CardColorLightCoralContainer
import com.example.notecollector.ui.theme.md_theme_dark_CardColorMIntGreenContainer
import com.example.notecollector.ui.theme.md_theme_dark_CardColorOrangeContainer
import com.example.notecollector.ui.theme.md_theme_light_CardColorBlueContainer
import com.example.notecollector.ui.theme.md_theme_light_CardColorLavenderContainer
import com.example.notecollector.ui.theme.md_theme_light_CardColorLightCoralContainer
import com.example.notecollector.ui.theme.md_theme_light_CardColorMIntGreenContainer
import com.example.notecollector.ui.theme.md_theme_light_CardColorOrangeContainer





@Composable
fun colorManger(colorManager:Int) :Color{
    var choicedColor : Color = Color.Transparent
    // For manage  is theme is light or dark
    val useDarkTheme: Boolean = isSystemInDarkTheme()
    if (!useDarkTheme) {

        if (colorManager == 1) {
            choicedColor = md_theme_light_CardColorBlueContainer
        } else if (colorManager == 2) {
            choicedColor = md_theme_light_CardColorLightCoralContainer
        } else if (colorManager == 3) {
            choicedColor = md_theme_light_CardColorLavenderContainer
        } else if (colorManager == 4) {
            choicedColor = MaterialTheme.colorScheme.secondaryContainer
        }


    } else {

        if (colorManager == 1) {
            choicedColor = md_theme_dark_CardColorBlueContainer
        } else if (colorManager == 2) {
            choicedColor = md_theme_dark_CardColorLightCoralContainer
        } else if (colorManager == 3) {
            choicedColor = md_theme_dark_CardColorLavenderContainer
        } else if (colorManager == 4) {
            choicedColor = MaterialTheme.colorScheme.secondaryContainer
        }
    }
    return choicedColor
}


