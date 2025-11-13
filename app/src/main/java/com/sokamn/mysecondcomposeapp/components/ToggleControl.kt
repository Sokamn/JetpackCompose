package com.sokamn.mysecondcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sokamn.mysecondcomposeapp.R

@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    
    var isTrollface by remember { mutableStateOf(true) }
    
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Switch(isTrollface, { isTrollface = !isTrollface },
            thumbContent = { Icon(painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Icono") },
            enabled = false,
            colors = SwitchDefaults.colors(checkedThumbColor = Color.Green, uncheckedThumbColor = Color.Red,
                disabledCheckedThumbColor = Color.Yellow, disabledUncheckedThumbColor = Color.Magenta))

    }
}