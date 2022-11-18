package com.projectapp.weatherapp.presentation.ui.composeelements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.projectapp.weatherapp.presentation.ui.theme.GrayDefaultColor
import com.projectapp.weatherapp.presentation.ui.theme.Shapes
import com.projectapp.wetherapp.R

@Composable
fun CurrentCityBar(onClick: () -> Unit) {
    Row(Modifier
        .padding(start = DEFAULT_PADDING.dp, end = DEFAULT_PADDING.dp, top = DEFAULT_PADDING.dp)
        .height(40.dp)
        .fillMaxWidth()
        .border(BorderStroke(1.dp, GrayDefaultColor), Shapes.medium)
        .clickable { onClick() },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_location_on_24),
            contentDescription = "", tint = GrayDefaultColor,
            modifier = Modifier
                .padding(start = 8.dp)
        )
        Row() {
            Text(
                text = "Tbilisi",
                textAlign = TextAlign.Center,
                color = GrayDefaultColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = DEFAULT_PADDING.dp, end = DEFAULT_PADDING.dp),
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xff121524, widthDp = 320)
@Composable
fun CurrentCityBarPreview() {
    MaterialTheme() {
        CurrentCityBar(onClick = {})
    }
}