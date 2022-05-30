package com.brickmate.medifoodcompose.extention

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.TextStyle

//fun Modifier.removeFontPadding(
//    textStyle: TextStyle
//) = layout { measurable, constraints ->
//    val placeable = measurable.measure(constraints)
//    val heightWithoutPadding = placeable.height - placeable.height.mod(textStyle.lineHeight.roundToPx())
//    layout(placeable.width, heightWithoutPadding) {
//        placeable.placeRelative(0, 0)
//    }
//}