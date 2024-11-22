package com.quotes.dev.presentation.theme

import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun QuoteOfTheDayTheme(
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val isDarkMode = isSystemInDarkTheme()
    val context = LocalContext.current as ComponentActivity
    val colorPalette: ColorPallet = getPalletColor(isDarkTheme = isDarkMode)

    val statusBarLight = lightPallet.backgroundColor
    val statusBarDark = darkPallet.backgroundColor
    val navigationBarLight = lightPallet.backgroundColor
    val navigationBarDark = darkPallet.backgroundColor

    DisposableEffect(isDarkMode) {
        context.enableEdgeToEdge(
            statusBarStyle = if (!isDarkMode) {
                SystemBarStyle.light(
                    statusBarLight.toArgb(),
                    statusBarDark.toArgb()
                )
            } else {
                SystemBarStyle.dark(
                    statusBarDark.toArgb()
                )
            },
            navigationBarStyle = if (!isDarkMode) {
                SystemBarStyle.light(
                    navigationBarLight.toArgb(),
                    navigationBarDark.toArgb()
                )
            } else {
                SystemBarStyle.dark(navigationBarDark.toArgb())
            }
        )



        onDispose { }
    }

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (isDarkMode) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        isDarkMode -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )

    CompositionLocalProvider(
        LocalPallet provides colorPalette
    ) {
        content()
    }
}

@Composable
fun CategoryMenuTheme(content: @Composable () -> Unit) =
    MaterialTheme(
        shapes = MaterialTheme.shapes.copy(
            extraSmall = RoundedCornerShape(8.dp)
        ),
        content = content
    )


val LocalPallet = staticCompositionLocalOf {
    getPalletColor()
}

private fun getPalletColor(
    isDarkTheme: Boolean = false
): ColorPallet {
    return if (isDarkTheme) ColorPallet(
        primaryTextColor = darkPallet.primaryTextColor,
        secondaryTextColor = darkPallet.secondaryTextColor,
        backgroundColor = darkPallet.backgroundColor,
        buttonBackgroundColor = darkPallet.buttonBackgroundColor,
        buttonTextColor = darkPallet.buttonTextColor,
        buttonLoadingBackgroundColor = darkPallet.buttonLoadingBackgroundColor,
        buttonLoadingTextColor = darkPallet.buttonLoadingTextColor,
        quoteBackgroundColor = darkPallet.quoteBackgroundColor
    ) else ColorPallet(
        primaryTextColor = lightPallet.primaryTextColor,
        secondaryTextColor = lightPallet.secondaryTextColor,
        backgroundColor = lightPallet.backgroundColor,
        buttonBackgroundColor = lightPallet.buttonBackgroundColor,
        buttonTextColor = lightPallet.buttonTextColor,
        buttonLoadingBackgroundColor = lightPallet.buttonLoadingBackgroundColor,
        buttonLoadingTextColor = lightPallet.buttonLoadingTextColor,
        quoteBackgroundColor = lightPallet.quoteBackgroundColor
    )
}