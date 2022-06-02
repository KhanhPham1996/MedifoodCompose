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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brickmate.medifoodcompose.screen.home.HomeScreenItem
import com.brickmate.medifoodcompose.ui.theme.AppTextStyle.regular12
import com.brickmate.medifoodcompose.ui.theme.MainBackGround
import com.brickmate.medifoodcompose.ui.theme.MainBlue
import com.brickmate.medifoodcompose.ui.theme.MedifoodComposeTheme
import com.brickmate.medifoodcompose.ui_component.bottom_navigation.BottomNavItem
import java.lang.Exception




@Composable
fun TopBar(
    buttonIcon: ImageVector = Icons.Default.Menu,
    onNavigationButtonClick: () -> Unit,
    navRoot: String?,
    selectedHomeScreenItem : HomeScreenItem,
    onTopBarItemClick: (HomeScreenItem) -> Unit
) {

    Box(
        Modifier
            .height(45.dp)
            .background(MainBackGround)
    ) {

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
                onNavigationButtonClick.invoke()
            })
            {
                Icon(buttonIcon, contentDescription = "", tint = Color.White)
            }
            if (navRoot == null || navRoot == BottomNavItem.Home.screen_route) {
                CustomAppBar(onTopBarItemClick = onTopBarItemClick, selectedHomeScreenItem = selectedHomeScreenItem)

            }
        }
        if (navRoot != null && navRoot != BottomNavItem.Home.screen_route) {
            Row(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = getTileFromRoot(navRoot),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )

            }

        }

    }

}

fun getTileFromRoot(screenRoot: String?): String {
    try {
        return if (screenRoot == null) {
            ""
        } else {
            when (screenRoot) {
                BottomNavItem.Home.screen_route -> BottomNavItem.Home.title
                BottomNavItem.Analytics.screen_route -> BottomNavItem.Analytics.title
                BottomNavItem.Shopping.screen_route -> BottomNavItem.Shopping.title
                BottomNavItem.Map.screen_route -> BottomNavItem.Map.title
                else -> {
                    ""
                }
            }
        }

    } catch (ex: Exception) {
        return ""
    }

}

@Composable
fun CustomAppBar(modifier: Modifier = Modifier, onTopBarItemClick: (HomeScreenItem) -> Unit,selectedHomeScreenItem : HomeScreenItem) {

    Box() {

        Row() {
            HomeScreenItem.listHomeScreenItem.forEach {

                Text(
                    text = it.title,
                    color = if(selectedHomeScreenItem == it) MainBlue else Color.White,
                    style = regular12,
                    modifier = Modifier
                        .border(1.dp, Color.White, RoundedCornerShape(5.dp))
                        .weight(1f)
                        .padding(1.dp)
                        .background(if(selectedHomeScreenItem == it) Color.White else Color.Transparent)
                        .clickable {
                            onTopBarItemClick.invoke(it)

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
        TopBar(navRoot = "Khanh",
            onNavigationButtonClick = {

            },
            onTopBarItemClick = {

            }, selectedHomeScreenItem = HomeScreenItem.Meal
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyButton(text: String = "", modifier: Modifier = Modifier, onButtonClicked: () -> Unit) {


}




