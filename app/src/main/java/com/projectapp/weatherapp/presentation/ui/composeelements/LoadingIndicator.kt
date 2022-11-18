package com.projectapp.weatherapp.presentation.ui.composeelements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.projectapp.weatherapp.presentation.ui.theme.DeepBlueColor

@Composable
fun LoadingIndicator() {
    //TODO change style
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        CircularProgressIndicator(Modifier.size(96.dp), color = DeepBlueColor)
    }

}