package com.brickmate.medifoodcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brickmate.medifoodcompose.ui.theme.AppTextStyle.regular12
import com.brickmate.medifoodcompose.ui.theme.MainBackGround
import com.brickmate.medifoodcompose.ui.theme.MedifoodComposeTheme
import com.brickmate.medifoodcompose.ui_component.bottom_navigation.BottomNavItem

val listItemMenu = listOf<String>("식사", "혈당", "혈압", "운동", "몸무게", "기타")



@Composable
fun TopBar(
    buttonIcon: ImageVector = Icons.Default.Menu,
    onButtonClicked: () -> Unit,
    navRoot: String?
) {
    Box(Modifier.height(45.dp).background(MainBackGround)) {

        Image(
            painter = painterResource(id = R.drawable.img_top_bg),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxWidth()
        )

        Row(

            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                onButtonClicked.invoke()
            })
            {
                Icon(buttonIcon, contentDescription = "", tint = Color.White)
            }
            if (navRoot == null || navRoot == BottomNavItem.Home.screen_route) {
                CustomAppBar()

            }
        }
        if(navRoot!=null && navRoot != BottomNavItem.Home.screen_route){
            Row(
                Modifier.fillMaxHeight().fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(text = navRoot, color = Color.White, textAlign = TextAlign.Center)

            }

        }

    }

}

@Composable
fun CustomAppBar() {
    Box() {

        Row() {
            listItemMenu.forEach {

                Text(
                    text = it,
                    color = Color.White,
                    style = regular12,
                    modifier = Modifier
                        .border(1.dp, Color.White, RoundedCornerShape(5.dp))
                        .weight(1f)
                        .background(color = Color.Transparent)
                        .clickable {
                        }
                        .padding(vertical = 5.dp),
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
        TopBar(navRoot = "Khanh", onButtonClicked = {

        })
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyButton(text: String = "", modifier: Modifier = Modifier, onButtonClicked: () -> Unit) {


}




