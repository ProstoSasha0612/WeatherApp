package com.projectapp.weatherapp.presentation.ui.composeelements

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projectapp.weatherapp.presentation.ui.theme.DeepBlueColor
import com.projectapp.weatherapp.presentation.ui.theme.GrayDefaultColor
import com.projectapp.weatherapp.presentation.ui.theme.LightDarkParamCardColor
import com.projectapp.weatherapp.presentation.ui.theme.StrongGrayColor
import com.projectapp.wetherapp.R

@Composable
fun WeatherParamCard(@DrawableRes parameterIconRes: Int, parameterName: String, value: String) {
    Card(backgroundColor = LightDarkParamCardColor, shape = RoundedCornerShape(8.dp)) {
        Column(
            Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = parameterIconRes),
                contentDescription = parameterName,
                tint = DeepBlueColor,
                modifier = Modifier.size(32.dp)
            )
            Text(text = parameterName, color = StrongGrayColor, fontSize = 8.sp)
            Text(text = value, color = GrayDefaultColor)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherParamCardPreview() {
    WeatherParamCard(R.drawable.ic_sunnycloudy, "humidity", "24%")
}