package com.sokamn.mysecondcomposeapp.components.animation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sokamn.mysecondcomposeapp.components.navigation.Detail
import com.sokamn.mysecondcomposeapp.components.navigation.examples.DetailScreen
import com.sokamn.mysecondcomposeapp.components.navigation.examples.HomeScreen
import com.sokamn.mysecondcomposeapp.components.navigation.examples.LoginScreen
import com.sokamn.mysecondcomposeapp.components.navigation.examples.model.SettingModel

@Composable
fun MyCrossFade(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf("Home") }

    Column(modifier.fillMaxSize()) {
        Row(modifier = Modifier.padding(top = 32.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Text(modifier = Modifier.clickable { currentScreen = "Home" }, text = "Home")
            Text(modifier = Modifier.clickable { currentScreen = "Detail" }, text = "Detail")
            Text(modifier = Modifier.clickable { currentScreen = "Login" }, text = "Login")
        }

        Crossfade(
            targetState = currentScreen
        ) { screen ->
            when (screen) {
                "Home" -> HomeScreen(navigateToDetail = { _, _ -> }, navigateToLogin = {})
                "Detail" -> DetailScreen(
                    id = "",
                    navigateToSettings = { _ -> },
                    test = true
                )
                "Login" -> LoginScreen {  }
            }
        }
    }
}