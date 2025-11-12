package com.sokamn.mysecondcomposeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sokamn.mysecondcomposeapp.R

@Preview
@Composable
fun MyImage() {
    Image(
        modifier = Modifier.width(300.dp).height(30.dp),
        painter = painterResource(R.drawable.rayo),
        contentScale = ContentScale.FillWidth,
        contentDescription = "Avatar Image Profile"
    )
}