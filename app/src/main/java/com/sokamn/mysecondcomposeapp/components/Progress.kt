package com.sokamn.mysecondcomposeapp.components

import android.widget.Button
import android.widget.Space
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
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
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.DefaultStrokeLineCap
import androidx.compose.ui.graphics.vector.DefaultStrokeLineJoin
import androidx.compose.ui.graphics.vector.DefaultStrokeLineMiter
import androidx.compose.ui.graphics.vector.DefaultStrokeLineWidth
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.sokamn.mysecondcomposeapp.R

@Composable
fun MyProgress(modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyCircularProgress()
        Spacer(Modifier.height(24.dp))
        MyLinearProgress()
    }
}

@Composable
fun MyAdvancedProgress(modifier: Modifier = Modifier) {
    var progress by remember { mutableFloatStateOf(0.5f) }
    var isLoading by remember { mutableStateOf(false) }
    val animatedProgress by animateFloatAsState(targetValue = progress)

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                progress = { animatedProgress },
                Modifier.size(140.dp),
                color = Color.Red,
                strokeWidth = 10.dp,
                trackColor = Color.Blue,
                strokeCap = StrokeCap.Round
            )
        }


        Row(Modifier.padding(24.dp)) {
            Button(onClick = { progress += 0.1f }) { Text("<-") }
            Spacer(Modifier.width(24.dp))
            Button(onClick = { progress -= 0.1f }) { Text("->") }
        }

        Button(onClick = {
            isLoading = !isLoading
        }) { if (isLoading) Text("Ocultar") else Text("Mostrar") }
    }
}

@Composable
fun MyCircularProgress() {
    CircularProgressIndicator(
        Modifier.size(140.dp),
        color = Color.Red,
        strokeWidth = 10.dp,
        trackColor = Color.Blue,
        strokeCap = StrokeCap.Round
    )
}

@Composable
fun MyLinearProgress() {
    LinearProgressIndicator(
        Modifier.width(300.dp),
        color = Color.Magenta,
        trackColor = Color.Black,
        strokeCap = StrokeCap.Round,
        gapSize = 10.dp
    )
}

@Composable
fun MyLottieProgress(modifier: Modifier = Modifier) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))

    var progress by remember { mutableFloatStateOf(0.5f) }
    var isLoading by remember { mutableStateOf(false) }
    val animatedProgress by animateFloatAsState(targetValue = progress)

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            LottieAnimation(composition, iterations = LottieConstants.IterateForever)
        }


        Row(Modifier.padding(24.dp)) {
            Button(onClick = { progress += 0.1f }) { Text("<-") }
            Spacer(Modifier.width(24.dp))
            Button(onClick = { progress -= 0.1f }) { Text("->") }
        }

        Button(onClick = {
            isLoading = !isLoading
        }) { if (isLoading) Text("Ocultar") else Text("Mostrar") }
    }
}