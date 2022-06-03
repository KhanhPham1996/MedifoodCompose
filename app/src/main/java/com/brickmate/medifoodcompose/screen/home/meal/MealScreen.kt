package com.brickmate.medifoodcompose.screen.home.meal

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brickmate.medifoodcompose.R
import com.brickmate.medifoodcompose.screen.home.OneWeekSchedule
import com.brickmate.medifoodcompose.ui.theme.*
import com.brickmate.medifoodcompose.ui.theme.AppTextStyle.medium10
import com.brickmate.medifoodcompose.ui.theme.AppTextStyle.semiBold16

@Composable
fun MealScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize()) {
        OneWeekSchedule()
        ProgressMeal(modifier = Modifier.padding(top = 15.dp))
        Spacer(modifier = Modifier.height(24.dp))
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            ItemMealTab(mealTabUI = MealTabUI.Morning)
            Spacer(modifier = Modifier.height(40.dp))
            ItemMealTab(mealTabUI = MealTabUI.Launch)
            Spacer(modifier = Modifier.height(40.dp))
            ItemMealTab(mealTabUI = MealTabUI.Dinner)
            Spacer(modifier = Modifier.height(100.dp))
        }

    }
}


@Composable
fun ProgressMeal(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 11.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_target),
                contentDescription = "",
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "1일 사용가능 포인트", style = AppTextStyle.medium16)
            Spacer(modifier = Modifier.width(11.dp))
            Text(text = "60/150", style = AppTextStyle.bold20)
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier.padding(end = 4.dp),
                painter = painterResource(id = R.drawable.ic_qa_circle),
                contentDescription = ""
            )

        }
        Spacer(modifier = Modifier.height(5.dp))
        LinearProgressIndicator(
            modifier = Modifier
                .clip(RoundedCornerShape(2.dp))
                .fillMaxWidth(), progress = 0.7f, color = MainBlue, backgroundColor = MainGray
        )
        Spacer(modifier = Modifier.height(8.dp))
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(Color.LightGray)
        )

    }
}


@Preview()
@Composable
fun PreviewProgress() {
    MealScreen()
}


@Composable
fun TimeTab(modifier: Modifier = Modifier, mealTabUI: MealTabUI) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(BlueMealTab)
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = mealTabUI.imageResource), contentDescription = "")
        Spacer(modifier = modifier.width(5.dp))
        Text(text = mealTabUI.title, style = semiBold16, color = MainMoreBlue)
        Spacer(modifier = modifier.width(10.dp))
        Image(painter = painterResource(id = R.drawable.ic_clock), contentDescription = "")
        Spacer(modifier = modifier.width(8.dp))
        Text(text = mealTabUI.time, style = medium10)

    }
}

@Composable
fun PointTab(modifier: Modifier = Modifier) {
    Row(
        modifier
            .clip(RoundedCornerShape(20.dp))
            .background(LightRed)
            .padding(vertical =  4.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = R.drawable.ic_target), contentDescription = "")
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "30 points", style = medium10)
    }
}

@Composable
fun CalorieTab(modifier: Modifier = Modifier) {
    Row(
        modifier
        .clip(RoundedCornerShape(20.dp))
            .background(LightYellow)
            .padding(vertical =  4.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = R.drawable.ic_klor), contentDescription = "")
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "30 points", style = medium10)
    }
}

@Composable
fun MealTab(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()

            .padding(start = 17.dp, top = 12.dp),
        elevation = 4.dp,
        color = MaterialTheme.colors.surface,
        shape = Shapes.medium,
    ) {

        Row(
            modifier = Modifier
                .padding(top = 48.dp, bottom = 17.dp, start = 20.dp)
        ) {
            Image(

                painter = painterResource(id = R.drawable.image_avatar),
                contentDescription = "",
                modifier
                    .size(84.dp)
                    .clip(RoundedCornerShape(5.dp)),
                contentScale = ContentScale.FillBounds
            )

        }
    }

}


@Composable
fun ItemMealTab(modifier: Modifier = Modifier, mealTabUI: MealTabUI) {
    Box(modifier = Modifier.defaultMinSize()) {
        MealTab()
        Row() {
            TimeTab(mealTabUI = mealTabUI)
            PointTab(modifier = Modifier.padding(start = 4.dp, top = 4.dp))
            CalorieTab(modifier = Modifier.padding(start = 4.dp, top = 4.dp))
        }
    }
}


sealed class MealTabUI(val imageResource: Int, val title: String, val time: String) {
    object Morning : MealTabUI(R.drawable.ic_morning, "아침", "09:30")
    object Launch : MealTabUI(R.drawable.ic_launch, "점심", "12:30")
    object Dinner : MealTabUI(R.drawable.ic_dinner, "저녁", "19:20")
}