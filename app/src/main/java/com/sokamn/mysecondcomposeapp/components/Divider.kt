package com.sokamn.mysecondcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyDivider(modifier: Modifier = Modifier) {
    Column (modifier, horizontalAlignment = Alignment.CenterHorizontally){
        Text("Parte de arriba")
        HorizontalDivider(thickness = 3.dp, color = Color.Red)
        Text("Parte de abajo")
    }

    Row (modifier.height(100.dp), verticalAlignment = Alignment.CenterVertically){
        Text("Parte de Izquierda")
        VerticalDivider(thickness = 6.dp, color = Color.Green)
        Text("Parte de Derecha")
    }
}