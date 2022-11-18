package com.projectapp.weatherapp.presentation.ui.composeelements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projectapp.weatherapp.presentation.ui.theme.GrayDefaultColor
import com.projectapp.weatherapp.presentation.ui.theme.PinkColor
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun CurrentTimeBar(time: LocalDateTime, onClick: () -> Unit) {
    val dateText =
        time.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM").withLocale(Locale.ENGLISH))

    Column(Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)) {
        Box(Modifier.fillMaxWidth()) {
            Text(
                text = "Today",
                fontSize = 24.sp,
                color = GrayDefaultColor,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Text(
                text = "7 days >",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .clickable {
                        onClick()
                    },
                color = GrayDefaultColor,
                fontSize = 24.sp,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        TodayCardWithText(text = dateText)
    }

}

@Composable
fun TodayCardWithText(text: String) {
    Card(backgroundColor = PinkColor,
        shape = RoundedCornerShape(50)) {
        Text(text = text, Modifier.padding(8.dp))
    }
}

@Preview
@Composable
fun CurrentTimeBarPreview() {
    CurrentTimeBar(LocalDateTime.parse("2022-07-01T00:00")){

    }
}