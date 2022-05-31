package com.brickmate.medifoodcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.brickmate.medifoodcompose.R

// Set of Material typography styles to start with
val noSanFamily = FontFamily(
    Font(R.font.noto_san_bold, FontWeight.Bold),
    Font(R.font.noto_san_medium, FontWeight.Medium),
    Font(R.font.noto_san_regular, FontWeight.Normal),

    )

@OptIn(ExperimentalTextApi::class)
val Typography = Typography(

    body1 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    ),
    h3 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    ),
    h4 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 9.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    ),
    body2 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

        ),
    h1 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        color = MainBlue,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    ),

    h2 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    ),

    button = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)

