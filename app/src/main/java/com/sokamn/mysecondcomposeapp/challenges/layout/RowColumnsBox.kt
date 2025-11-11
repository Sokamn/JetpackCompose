package com.sokamn.mysecondcomposeapp.challenges.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyRowColumnBox(modifier: Modifier) {
    Column(modifier.fillMaxSize()) {
        Box(Modifier.background(Color.Cyan).weight(1f).fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text("Ejemplo 1")
        }
        Spacer(Modifier.height(10.dp))
        Row(Modifier.weight(1f).fillMaxWidth()) {
            Box(Modifier.fillMaxHeight().weight(1f).background(Color.Red), contentAlignment = Alignment.Center){
                Text("Ejemplo 2")
            }
            Spacer(Modifier.width(10.dp))
            Box(Modifier.fillMaxHeight().weight(1f).background(Color.Green), contentAlignment = Alignment.Center){
                Text("Ejemplo 3")
            }
        }
        Spacer(Modifier.height(10.dp))
        Box(Modifier.background(Color.Magenta).weight(1f).fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text("Ejemplo 4")
        }
    }
}