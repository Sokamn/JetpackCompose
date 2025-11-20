package com.sokamn.mysecondcomposeapp.components.navigation.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(navigateBack: () -> Unit) {
    Column(Modifier.fillMaxSize().background(Color.Red), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.weight(1f))
        Text(text = "LOGIN", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Button(onClick = { navigateBack() }) {
            Text("Navegar")
        }
        Spacer(Modifier.weight(1f))
    }
}
