package com.projectapp.weatherapp.presentation.ui.composeelements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ErrorIndicator(errorMessage: String?) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = errorMessage ?: "An unknown error occurred!", color = Color.Red)
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun ErrorIndicatorPreview() {
    ErrorIndicator(errorMessage = "An error occurred!")
}