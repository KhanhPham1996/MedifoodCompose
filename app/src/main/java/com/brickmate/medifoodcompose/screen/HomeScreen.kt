package com.brickmate.medifoodcompose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brickmate.medifoodcompose.data_model.ScheduleDate
import com.brickmate.medifoodcompose.extention.getDateFormat
import com.brickmate.medifoodcompose.extention.getDateOfWeek
import com.brickmate.medifoodcompose.ui.theme.AppTextStyle.medium12
import com.brickmate.medifoodcompose.R
import com.brickmate.medifoodcompose.extention.addDate

import com.brickmate.medifoodcompose.ui.theme.AppTextStyle.semiBold16
import com.brickmate.medifoodcompose.ui.theme.MainBackGround
import com.brickmate.medifoodcompose.ui.theme.SelectedBackGround
import com.brickmate.medifoodcompose.util.DateTimeUtil.getSevenDateOfWeek
import java.util.*

@Composable
fun HomeScreen(openDrawer: () -> Unit) {
    Surface(modifier = Modifier.background(MainBackGround)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MainBackGround)
        ) {
            OneWeekSchedule()

        }
    }
}
@Composable
fun OneWeekSchedule(modifier: Modifier = Modifier) {
    var today by remember {
        mutableStateOf(Date())
    }
    var selectedDate by remember {
        mutableStateOf(Date())
    }

    val currentWeekList = getSevenDateOfWeek(today)
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, start = 10.dp, end = 10.dp)
            .background(Color.White),
        elevation = 5.dp
    ) {
        Row(
            Modifier
                .padding(vertical = 5.dp)
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Image(
                painter = painterResource(id = R.drawable.ic_navigate_back),
                contentDescription = "",
                modifier = Modifier
                    .size(16.dp)
                    .clickable {
                        today = today.addDate(-7)
                    },
            )
            Row(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .weight(1f), horizontalArrangement = Arrangement.Center
            ) {

                currentWeekList.forEachIndexed { position, it ->
                    Box(modifier = Modifier.weight(1f)) {
                        ItemDate(
                            scheduleDate = ScheduleDate(it, false),
                            selectedDate = selectedDate,
                            onSelectDate = {
                                selectedDate = it
                            })

                    }
                }
            }
            Image(
                painter = painterResource(id = R.drawable.ic_navigate_next),
                contentDescription = "",
                modifier = Modifier
                    .size(16.dp)
                    .clickable {
                        today = today.addDate(7)
                    },
            )
        }
    }

}

@Composable
fun ItemDate(scheduleDate: ScheduleDate, selectedDate: Date, onSelectDate: (Date) -> Unit) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(if (scheduleDate.date == selectedDate) SelectedBackGround else Color.White)
            .clickable {
                onSelectDate.invoke(scheduleDate.date)
            }
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = scheduleDate.date.getDateOfWeek(), style = medium12)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = scheduleDate.date.getDateFormat(), style = medium12)
    }
}
@Preview
@Composable
fun PreviewItemDate() {
    HomeScreen {
    }
}


