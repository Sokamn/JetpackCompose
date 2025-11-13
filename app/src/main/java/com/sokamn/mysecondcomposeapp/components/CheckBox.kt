package com.sokamn.mysecondcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.sokamn.mysecondcomposeapp.components.states.CheckBoxState

@Composable
fun MyCheckBox(modifier: Modifier = Modifier) {

    var isTrollface by remember { mutableStateOf(true) }

    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { isTrollface = !isTrollface }) {
            Checkbox(
                isTrollface,
                { isTrollface = !isTrollface },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    checkmarkColor = Color.DarkGray,
                    uncheckedColor = Color.Blue, // COLOR DE BORDE AZUL
                    disabledCheckedColor = Color.Yellow,
                    disabledUncheckedColor = Color.Blue,
                    disabledIndeterminateColor = Color.Transparent// ES PARA OTRO TIPO DE CHECKBOX
                )
            )

            Spacer(Modifier.width(12.dp))

            Text("Acepto los términos y condiciones")
        }

    }
}

@Composable
fun ParentCheckBoxes(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(
        listOf(
                CheckBoxState("terms", "Aceptar los términos y condiciones"),
                CheckBoxState("newsletter", "Recibir las newsletter", true),
                CheckBoxState("updates", "Recibir actualizaciones"),

            )
        )
    }

    Column(modifier = modifier.fillMaxSize()) {
        state.forEach { myState ->
            MyCheckBoxWithText(checkBoxState =  myState) {

                state = state.map {
                    if(it.id == myState.id){
                        myState.copy(checked = !myState.checked)
                    }else{
                        it
                    }
                }

            }
        }
    }
}

@Composable
fun MyCheckBoxWithText(
    modifier: Modifier = Modifier,
    checkBoxState: CheckBoxState,
    onCheckedChange: (CheckBoxState) -> Unit
) {

    with(checkBoxState) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.clickable { onCheckedChange(this@with) }) {
            Checkbox(
                checked,
                { onCheckedChange(this@with) }
            )

            Spacer(Modifier.width(12.dp))

            Text(label)
        }
    }
}

@Composable
fun MyTriStateCheckBox(modifier: Modifier = Modifier) {

    var parentState by remember { mutableStateOf(ToggleableState.Off) }
    var child1 by remember { mutableStateOf(false) }
    var child2 by remember { mutableStateOf(false) }

    LaunchedEffect(child1, child2) {
        parentState = when{
            child1 && child2 -> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }

    Column(modifier.fillMaxSize()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(parentState, onClick = {
                val newState = parentState != ToggleableState.On
                child1 = newState
                child2 = newState
            })
            Text("Seleccionar Todo")
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 16.dp)) {
            Checkbox(child1, onCheckedChange = { child1 = it })
            Text("Ejemplo 1")
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 16.dp)) {
            Checkbox(child2, onCheckedChange = { child2 = it })
            Text("Ejemplo 1")
        }

    }
}