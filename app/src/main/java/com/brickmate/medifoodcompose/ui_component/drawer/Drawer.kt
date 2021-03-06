package com.brickmate.medifoodcompose.ui_component.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brickmate.medifoodcompose.ui.theme.*
import com.brickmate.medifoodcompose.R
import com.brickmate.medifoodcompose.ui.theme.AppTextStyle.regular12
import com.brickmate.medifoodcompose.ui.theme.AppTextStyle.semiBold16
import com.brickmate.medifoodcompose.ui.theme.AppTextStyle.semiBold24Blue


@Composable
fun NavDrawer() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        NavHeader()
        NavBody()

    }
}

@Composable
fun NavHeader() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(270.dp)
            .background(MainBackGround)
    ) {
        Row() {
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(
                    id =
                    R.drawable.img_doctor_left_menu
                ), "",
                modifier = Modifier
                    .height(270.dp)
                    .width(200.dp),
                contentScale = ContentScale.FillBounds,
                alignment = Alignment.Center

            )
        }
        Column(
            modifier = Modifier
                .padding(top = 30.dp, start = 30.dp),
            horizontalAlignment = Alignment.Start

        ) {

            Image(

                painter = painterResource(id = R.drawable.image_avatar),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .size(94.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Martin Odegard",
                style = semiBold24Blue,
                textAlign = TextAlign.Start,
                modifier = Modifier.width(200.dp)
            )
            Text(
                text = "72kg ??? ??? ??? ??????",
                style = regular12,
                textAlign = TextAlign.Start,
                modifier = Modifier.width(200.dp)
            )

        }


    }
}

@Composable
fun NavBody(modifier: Modifier = Modifier) {
    Column(
        modifier
            .padding(top = 250.dp)
            .background(Color.White)
    ) {
        listDrawerItem.forEach {
            NavItem(
                painterResource = it.imageResource,
                title = it.title
            )
        }
    }

}

@Composable
fun NavItem(modifier: Modifier = Modifier, painterResource: Int, title: String) {

    Row(
        modifier = Modifier
            .clickable {

            }
            .fillMaxWidth()
            .padding(start = 24.dp)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(id = painterResource),
            contentDescription = "",
            Modifier.width(27.dp)
        )
        Spacer(modifier = Modifier.width(40.5.dp))
        Text(text = title, style = semiBold16)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(0.5.dp)
            .background(Color.LightGray)
    )

}


val listDrawerItem = listOf(
    DrawerItem(R.drawable.ic_document, "?????? ?????? ??????"),
    DrawerItem(R.drawable.ic_setting, "1:1 ?????? ????????? ???????????? ?????????"),
    DrawerItem(R.drawable.ic_health_check, "??????"),
    DrawerItem(R.drawable.ic_qa, "??????"),
)


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DrawerPreview() {
    MedifoodComposeTheme {
        NavDrawer()

    }
}



