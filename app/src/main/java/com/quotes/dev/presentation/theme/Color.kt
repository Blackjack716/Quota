package com.quotes.dev.presentation.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val lightPallet = ColorPallet(
    primaryTextColor = Color.Black,
    secondaryTextColor = Color.Gray,
    backgroundColor = Color(0xFFFFFBFE),
    buttonBackgroundColor = Color.LightGray,
    buttonTextColor = Color.White,
    buttonLoadingBackgroundColor = Color.Gray,
    buttonLoadingTextColor = Color.White,
    quoteBackgroundColor = Color(0xFF00FA9A)
)
val darkPallet = ColorPallet(
    primaryTextColor = Color.White,
    secondaryTextColor = Color.LightGray,
    backgroundColor = Color(0xFF1C1B20),
    buttonBackgroundColor = Color.LightGray,
    buttonTextColor = Color.Black,
    buttonLoadingBackgroundColor = Color(0xFF1A6B23),
    buttonLoadingTextColor = Color.Black,
    quoteBackgroundColor = Color(0xFF008000)
)

data class ColorPallet(
    val primaryTextColor: Color,
    val secondaryTextColor: Color,
    val backgroundColor: Color,
    val buttonBackgroundColor: Color,
    val buttonTextColor: Color,
    val buttonLoadingBackgroundColor: Color,
    val buttonLoadingTextColor: Color,
    val quoteBackgroundColor: Color
)