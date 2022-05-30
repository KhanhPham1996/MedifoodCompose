package com.brickmate.medifoodcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brickmate.medifoodcompose.ui.theme.MainBackGround
import com.brickmate.medifoodcompose.ui.theme.MainBlue
import com.brickmate.medifoodcompose.ui.theme.MedifoodComposeTheme

val listItemMenu = listOf<String>("식사", "혈당", "혈압", "운동", "몸무게", "기타")

val cornerRadius = CornerRadius(10f, 10f)
val path = Path().apply {
    addRoundRect(
        RoundRect(
            rect = Rect(
                offset = Offset(0f, 0f),
                size = Size(100f, 100f),
            ),
            bottomLeft = cornerRadius,
            bottomRight = cornerRadius,
        )
    )
}
@Composable
fun TopBar(
    title: String = "",
    buttonIcon: ImageVector = Icons.Default.Menu,
    onButtonClicked: () -> Unit
) {
    Box(modifier = Modifier.background(MainBlue)) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                onButtonClicked.invoke()
            })
            {
                Icon(buttonIcon, contentDescription = "", tint = Color.White)
            }
            CustomAppBar()

        }
    }

}

@Composable
fun CustomAppBar() {
    Box( ) {

        Row() {
            listItemMenu.forEach {

                Text(
                    text = it,
                    color = Color.White,
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier

                        .border(1.dp, Color.White, RoundedCornerShape(5.dp))
                        .weight(1f)
                        .background(color = Color.Transparent)
                        .padding(vertical = 5.dp)
                        .clickable {

                        },
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.width(5.dp))

            }
        }
    }

}

@Preview
@Composable
fun PreviewTopAppBar() {
    MedifoodComposeTheme() {
        TopBar() {

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyButton(text: String = "", modifier: Modifier = Modifier, onButtonClicked: () -> Unit) {


}




