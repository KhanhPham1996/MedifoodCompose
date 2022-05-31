package com.brickmate.medifoodcompose.ui.theme

import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalTextApi::class)
object AppTextStyle {

    val semiBold16 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )
    val regular12 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )
    val medium12 = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )
    val semiBold24Blue = TextStyle(
        fontFamily = noSanFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        color = MainBlue,
        platformStyle = PlatformTextStyle(includeFontPadding = false)

    )
}
