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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.sokamn.mysecondcomposeapp.components.navigation.examples.model.SettingModel

@Composable
fun SettingScreen(settingModel: SettingModel, navigateToHome: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .background(if (settingModel.darkMode) Color.Black else Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))
        Text(
            text = "OPCIONES ACTIVADAS: ${settingModel.id}",
            fontSize = 30.sp,
            color = if (settingModel.darkMode) Color.White else Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.weight(1f))
        if (settingModel.darkMode) {
            Text(
                text = "TEMA OSCURO",
                fontSize = 30.sp,
                color = Color.White
            )
        } else {
            Text(text = "TEMA CLARO", fontSize = 30.sp, color = Color.Black)
        }
        Spacer(Modifier.weight(1f))
        Button(onClick = { navigateToHome() }) {
            Text("Volver")
        }
        Spacer(Modifier.weight(1f))
    }
}