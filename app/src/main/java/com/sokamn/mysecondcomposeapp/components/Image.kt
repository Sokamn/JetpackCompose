package com.sokamn.mysecondcomposeapp.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.sokamn.mysecondcomposeapp.R

@Preview
@Composable
fun MyImage() {
    Image(
        modifier = Modifier
            .width(300.dp)
            .height(30.dp),
        painter = painterResource(R.drawable.rayo),
        contentScale = ContentScale.FillWidth,
        contentDescription = "Avatar Image Profile"
    )
}

@Preview
@Composable
fun MyAdvancedImage() {
    Image(
        modifier = Modifier
            .size(300.dp)
            .clip(CircleShape)
            .border(
                width = 5.dp, shape = CircleShape,
                brush = Brush.linearGradient(colors = listOf(Color.Red, Color.White))
            ),
        painter = painterResource(R.drawable.rayo),
        contentScale = ContentScale.FillBounds,
        contentDescription = "Avatar Image Profile"
    )
}

@Composable
fun MyNetworkImage(modifier: Modifier) {
    AsyncImage(
        modifier = modifier.size(300.dp),
        model = "https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/cinefilia/por-que-ratatouille-nos-sigue-enamorando-10-anos-despues/136444706-1-esl-ES/Por-que-Ratatouille-nos-sigue-enamorando-10-anos-despues.jpg",
        contentDescription = "Image from Network",
        onError = { Log.i("AsyncImage", "Ha ocurrido un error: ${it.result.throwable.message}") }
    )
}

@Preview
@Composable
fun MyIcon(modifier: Modifier = Modifier) {
    Icon(
        modifier = modifier.size(300.dp),
        painter = painterResource(R.drawable.ic_fonito),
        contentDescription = null,
        tint = Color.Magenta
    )
}