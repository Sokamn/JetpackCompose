package com.sokamn.mysecondcomposeapp.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    showBackground = true
)
@Composable
fun ExamplePreview(){
    Example("EL MÁS PRO")
}

@Composable
fun Example(sufijo: String) {
    Text(text = "Sokamn es $sufijo", modifier = Modifier
        .padding()
        .background(Color.Red)
    )

}