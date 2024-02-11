package com.ramo.ebuy.global.base

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red

data class Theme(
    val isDarkMode: Boolean,
    val isDarkStatusBarText: Boolean,
    val primary: Color,
    val secondary: Color,
    val background: Color,
    val backDark: Color,
    val backDarkSec: Color,
    val backGreyTrans: Color,
    val textColor: Color,
    val textForPrimaryColor: Color,
    val textGrayColor: Color,
    val error: Color,
    val textHintColor: Color,
    val pri: Color
) {
    val priAlpha: Color = pri.toArgb().let {
        Color(it.red, it.green, it.blue, 63)
    }
    val textHintAlpha = textHintColor.toArgb().let {
        Color(it.red, it.green, it.blue, 150)
    }
    val backDarkAlpha = backDark.toArgb().let {
        Color(it.red, it.green, it.blue, 150)
    }
}

fun generateTheme(isDarkMode: Boolean): Theme {
    return if (isDarkMode) {
        Theme(
            isDarkMode = true,
            isDarkStatusBarText = false,
            primary = Color(red = 109, green = 157, blue = 241),
            secondary = Color(red = 65, green = 130, blue = 237),
            background = Color.Black,
            backDark = Color(25, 25, 25),
            backDarkSec = Color(143, 143, 143),
            backGreyTrans = Color(85, 85, 85, 85),
            textColor = Color.White,
            textForPrimaryColor = Color.Black,
            textGrayColor = Color(143, 143, 143),
            error = Color(red = 255, green = 21, blue = 21),
            textHintColor = Color.LightGray,
            pri = Color(102, 158, 255)
        )
    } else {
        Theme(
            isDarkMode = false,
            isDarkStatusBarText = true,
            primary = Color(red = 109, green = 157, blue = 241),
            secondary = Color(red = 65, green = 130, blue = 237),
            background = Color.White,
            backDark = Color(230, 230, 230),
            backDarkSec = Color(112, 112, 112),
            backGreyTrans = Color(170, 170, 170, 85),
            textColor = Color.Black,
            textForPrimaryColor = Color.Black,
            textGrayColor = Color(112, 112, 112),
            error = Color(red = 155, green = 0, blue = 0),
            textHintColor = Color.DarkGray,
            pri = Color(102, 158, 255)
        )
    }
}


@Composable
fun MyApplicationTheme(
    theme: Theme,
    content: @Composable () -> Unit
) {
    val colors = if (isSystemInDarkTheme()) {
        darkColorScheme(
            primary = theme.primary,
            secondary = theme.secondary,
            background = theme.background,
            onBackground = theme.textHintColor,
        )
    } else {
        lightColorScheme(
            primary = theme.primary,
            secondary = theme.secondary,
            background = theme.background,
            onBackground = theme.textHintColor,
        )
    }
    val typography = Typography(
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )
    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
