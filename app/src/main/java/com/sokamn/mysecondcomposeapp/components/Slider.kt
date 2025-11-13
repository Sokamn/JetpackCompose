@file:OptIn(ExperimentalMaterial3Api::class)

package com.sokamn.mysecondcomposeapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MySlider(modifier: Modifier = Modifier) {

    var myValue by remember { mutableFloatStateOf(0.5f) }

    Column(
        modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Slider(
            value = myValue,
            onValueChange = { myValue = it },
            enabled = true,
            colors = SliderDefaults.colors(
                thumbColor = Color.Green,
                activeTrackColor = Color.Green,
                activeTickColor = Color.Yellow,
                inactiveTrackColor = Color.Blue,
                inactiveTickColor = Color.Blue,
                disabledThumbColor = Color.Red,
                disabledActiveTrackColor = Color.Red,
                disabledActiveTickColor = Color.Red,
                disabledInactiveTrackColor = Color.Yellow,
                disabledInactiveTickColor = Color.Yellow
            )
        )
        Text(myValue.toString())
    }
}

@Composable
fun MySliderAdvanced(modifier: Modifier = Modifier) {

    val state = remember {
        SliderState(
            value = 5f,
            valueRange = 0f..10f,
            steps = 9,
            onValueChangeFinished = {  }
        )
    }

    Column(
        modifier.padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Slider(state) // thumb = {  }, track = {  }
        Text(state.value.toString())
    }
}

@Composable
fun MyRangeSlider(modifier: Modifier = Modifier) {

    val state = remember { RangeSliderState(
        activeRangeStart = 3f,
        activeRangeEnd = 6f,
        valueRange = 0f..10f,
        onValueChangeFinished = {  }

    ) }

    Column(modifier.fillMaxSize().padding(horizontal = 32.dp)) {
        RangeSlider(state = state)
    }
}