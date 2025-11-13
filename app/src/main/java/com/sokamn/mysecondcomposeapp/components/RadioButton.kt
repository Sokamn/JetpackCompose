package com.sokamn.mysecondcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyRadioButton(modifier: Modifier = Modifier) {

    var state by remember { mutableStateOf(false) }

    Column(modifier.fillMaxSize()) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            RadioButton(selected = state,
                { state = true },
                enabled = true,
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Green,
                    unselectedColor = Color.Green,
                    disabledSelectedColor = Color.Red,
                    disabledUnselectedColor = Color.Red
                )
            )

            Text("Nose que poner acá")
        }

    }
}
@Composable
fun MyRadioButtonList(modifier: Modifier = Modifier) {

    var selectedName by remember { mutableStateOf("") }

    Column(modifier.fillMaxSize()) {
        RadioButtonComponent(name = "Matías", selectedName =  selectedName){ selectedName = it }
        RadioButtonComponent(name = "Renzo", selectedName =  selectedName){ selectedName = it }
        RadioButtonComponent(name = "Diego", selectedName =  selectedName){ selectedName = it }
        RadioButtonComponent(name = "Camila", selectedName =  selectedName){ selectedName = it }


    }
}

@Composable
fun RadioButtonComponent(name: String, selectedName: String, onItemSelected: (String)-> Unit) {

    Row(modifier = Modifier.fillMaxWidth().clickable{ onItemSelected(name) }, verticalAlignment = Alignment.CenterVertically) {

        RadioButton(selected = name == selectedName,
            { onItemSelected(name) },
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Green,
                unselectedColor = Color.Green,
                disabledSelectedColor = Color.Red,
                disabledUnselectedColor = Color.Red
            )
        )

        Text(name)
    }
}
