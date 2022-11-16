package com.projectapp.weatherapp.composeui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projectapp.weatherapp.ui.theme.LightDarkCardColor
import com.projectapp.weatherapp.ui.theme.GrayDefaultColor
import com.projectapp.wetherapp.R

@Composable
fun CurrentWeatherCard(modifier: Modifier = Modifier) {
    Card(
        backgroundColor = LightDarkCardColor,
        modifier = Modifier
            .padding(DEFAULT_PADDING.dp),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column() {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                //TODO
                Icon(
                    painter = painterResource(id = R.drawable.cloudy),
                    contentDescription = "weather type icon",
                    modifier = modifier.size(96.dp),
                    tint = Color.Unspecified,
                )
                Text(
                    text = stringResource(id = R.string.temperature_degree),
                    color = GrayDefaultColor,
                    fontSize = 80.sp
                )
            }
            Spacer(modifier = modifier.height(32.dp))
            Row(modifier.fillMaxWidth().padding(bottom = 24.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
                WeatherParamCard(parameterIconRes = R.drawable.rain,
                    parameterName = "humidity",
                    value = "24%"
                )
                WeatherParamCard(parameterIconRes = R.drawable.rain,
                    parameterName = "humidity",
                    value = "24%"
                )
                WeatherParamCard(parameterIconRes = R.drawable.rain,
                    parameterName = "humidity",
                    value = "24%"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CurrentWeatherCardPreview() {
    CurrentWeatherCard()
}