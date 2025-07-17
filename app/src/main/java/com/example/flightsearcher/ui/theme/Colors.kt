package com.example.flightsearcher.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class CustomTheme(
    val surface: Color,
    val surfaceLight: Color,
    val textPrimary: Color,
    val textInverse: Color,
    val iconPrimary: Color,
    val iconInverse: Color,
    val borderPrimary: Color,
    val borderError: Color,
    val buttonPrimary: Color,
    val buttonDisabled: Color,
    val isLight: Boolean
)

val lightThemeColors = CustomTheme(
    surface = Color.White,               // screen/card backgrounds
    surfaceLight = Color(0xFFF5F7FA),    // lighter variant for layers
    textPrimary = Color.Black,           // primary text
    textInverse = Color.White,           // text on dark/blue backgrounds
    iconPrimary = Color.Black,           // normal icons
    iconInverse = Color.White,           // icons on blue backgrounds
    borderPrimary = Color(0xFF999999),   // subtle border/outline
    borderError = Color(0xFFB00020),     // standard error red
    buttonPrimary = Color(0xFF0031B6),   // strong blue
    buttonDisabled = Color(0xFFBDBDBD),  // gray for disabled states
    isLight = true
)

val darkThemeColors = CustomTheme(
    surface = Color.Black,                   // main background
    surfaceLight = Color(0xFF121212),        // elevated surfaces/cards
    textPrimary = Color.White,               // default text
    textInverse = Color.Black,               // for light buttons/surfaces
    iconPrimary = Color.White,               // regular icons
    iconInverse = Color.Black,               // icons on light buttons
    borderPrimary = Color(0xFF555555),       // soft border for cards/inputs
    borderError = Color(0xFFCF6679),         // Material dark error color
    buttonPrimary = Color(0xFF0031B6),       // vibrant blue for action buttons
    buttonDisabled = Color(0xFF555555),      // muted gray for disabled states
    isLight = false
)

val LocalTheme = staticCompositionLocalOf<CustomTheme> {
    error("No colors provided.")
}