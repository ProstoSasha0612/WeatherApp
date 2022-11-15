package com.projectapp.weatherapp.composeui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.tooling.preview.Preview
import com.projectapp.weatherapp.ui.theme.GradientEndColor
import com.projectapp.weatherapp.ui.theme.GradientStartColor

@Composable
fun BackgroundGradientSurface(content: @Composable () -> Unit) {
    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(GradientStartColor, GradientEndColor),
                    start = Offset(0f, 0f),
                    tileMode = TileMode.Decal
                ),
            ),
    ) {
        content()
    }
}

@Preview
@Composable
fun BackGroundSurface() {
    BackgroundGradientSurface {

    }
}