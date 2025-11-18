package com.sokamn.mysecondcomposeapp.components.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sokamn.mysecondcomposeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onNavSelected: ()-> Unit) {
    TopAppBar(
        title = { Text("Mi Aplicación") },
        navigationIcon = { Icon(modifier = Modifier.clickable{
            onNavSelected()
        }, painter = painterResource(R.drawable.ic_fonito), contentDescription = null) },
        actions = {
            Icon(painterResource(R.drawable.ic_launcher_foreground), null, tint = Color.Cyan)
            Icon(painterResource(R.drawable.ic_launcher_foreground), null, tint = Color.Yellow)
            Icon(painterResource(R.drawable.ic_launcher_foreground), null, tint = Color.Cyan)

        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue,
            scrolledContainerColor = Color.Black,
                navigationIconContentColor = Color.White,
                titleContentColor = Color.DarkGray,
                actionIconContentColor = Color.White,
        )
    )
}