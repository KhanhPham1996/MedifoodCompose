package com.brickmate.medifoodcompose.ui_component

import android.graphics.Typeface
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brickmate.medifoodcompose.ui.theme.*
import com.brickmate.medifoodcompose.R
import com.walnash.navigationdrawer.ui_component.DrawerItem


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
                contentDescription ="",
                contentScale= ContentScale.Crop,
                alignment = Alignment.Center,
                modifier= Modifier
                    .size(94.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(4.dp))
             Text(text = "Martin Odegard", style = MaterialTheme.typography.h1 ,textAlign = TextAlign.Start,modifier = Modifier.width(200.dp))
             Text(text = "72kg ∙ 남 ∙ 정상", style = MaterialTheme.typography.h3 ,textAlign = TextAlign.Start,modifier = Modifier.width(200.dp))

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
        Text(text = title, style = MaterialTheme.typography.body1 )
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(0.5.dp)
            .background(Color.LightGray)
    )

}


val listDrawerItem = listOf(
    DrawerItem(R.drawable.ic_document, "영양 평가 결과"),
    DrawerItem(R.drawable.ic_setting, "1:1 개인 맞춤형 식이요법 클리닉"),
    DrawerItem(R.drawable.ic_health_check, "문의"),
    DrawerItem(R.drawable.ic_qa, "설정"),
)


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DrawerPreview() {
    MedifoodComposeTheme{
        NavDrawer()

    }
}



