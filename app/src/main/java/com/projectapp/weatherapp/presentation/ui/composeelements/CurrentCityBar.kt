package com.projectapp.weatherapp.presentation.ui.composeelements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.projectapp.weatherapp.presentation.ui.theme.GrayDefaultColor
import com.projectapp.weatherapp.presentation.ui.theme.PinkColor
import com.projectapp.weatherapp.presentation.ui.theme.Shapes
import com.projectapp.wetherapp.R

//@Composable
//fun CurrentCityBar(cityName: String, onClick: () -> Unit) {
//    Row(Modifier
//        .padding(start = DEFAULT_PADDING.dp, end = DEFAULT_PADDING.dp, top = DEFAULT_PADDING.dp)
////        .height(40.dp)
//        .fillMaxWidth()
//        .border(BorderStroke(1.dp, GrayDefaultColor), Shapes.medium)
//        .clickable { onClick() },
//        horizontalArrangement = Arrangement.Center,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Icon(
//            painter = painterResource(id = R.drawable.ic_baseline_location_on_24),
//            contentDescription = "", tint = GrayDefaultColor,
//            modifier = Modifier
//                .padding(start = 8.dp)
//        )
//        Row() {
////            Text(
////                text = cityName,
////                textAlign = TextAlign.Center,
////                color = GrayDefaultColor,
////                modifier = Modifier
////                    .fillMaxWidth()
////                    .padding(start = DEFAULT_PADDING.dp, end = DEFAULT_PADDING.dp),
////            )
//            val textFieldStyle = androidx.compose.ui.text.TextStyle(
//                textAlign = TextAlign.Center,
//                color = GrayDefaultColor,
//            )
//            TextField(
//                value = cityName,
//                textStyle = textFieldStyle,
//                onValueChange = {},
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = DEFAULT_PADDING.dp, end = DEFAULT_PADDING.dp)
//            )
//        }
//    }
//}

@Composable
fun CurrentCityBar(cityName: String, onClick: () -> Unit) {
    val textFieldStyle = androidx.compose.ui.text.TextStyle(
        textAlign = TextAlign.Center,
        color = GrayDefaultColor,
    )
    OutlinedTextField(
        value = cityName,
        onValueChange = {},
        modifier = Modifier
            .padding(start = DEFAULT_PADDING.dp, end = DEFAULT_PADDING.dp, )
//        .height(40.dp)
            .fillMaxWidth()
            .border(BorderStroke(1.dp, GrayDefaultColor), RoundedCornerShape(20))
            .clickable { onClick() },
        textStyle = textFieldStyle,
        maxLines = 1,
        leadingIcon = {
            Icon(painter = painterResource(id = R.drawable.ic_baseline_location_on_24),
                contentDescription = "",
                tint = GrayDefaultColor,
//                modifier = Modifier.padding(start = 8.dp)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = PinkColor,
            focusedLabelColor = GrayDefaultColor,
            unfocusedIndicatorColor = GrayDefaultColor,

            disabledTrailingIconColor = PinkColor,
            unfocusedLabelColor = GrayDefaultColor
        )
    )

}

@Preview(showBackground = true, backgroundColor = 0xff121524, widthDp = 320)
@Composable
fun CurrentCityBarPreview() {
    MaterialTheme() {
        CurrentCityBar("Tbilsi", onClick = {})
    }
}