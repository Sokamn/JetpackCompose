package com.sokamn.mysecondcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyComplexLayout(modifier: Modifier) {
    Column(modifier) {
        Box(Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color.Red)) {}
        Box(Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color.Green)) {
            Row {
                Box(Modifier
                    .weight(1f)
                    .height(125.dp)
                    .background(Color.Cyan)) {}
                Box(Modifier
                    .weight(1f)
                    .height(180.dp)
                    .background(Color.Magenta), contentAlignment = Alignment.Center) {
                    Text("Hola")
                }

            }
        }
        Box(Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color.Yellow)) {}

    }
}