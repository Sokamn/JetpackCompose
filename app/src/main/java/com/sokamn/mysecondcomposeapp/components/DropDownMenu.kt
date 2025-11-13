@file:OptIn(ExperimentalMaterial3Api::class)

package com.sokamn.mysecondcomposeapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.sokamn.mysecondcomposeapp.R
import org.w3c.dom.Text

@Composable
fun MyExposedDropDownMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf("") }
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }) {
        TextField(
            value = selected,
            onValueChange = { },
            readOnly = true,
            label = { Text("Idioma") },
            modifier = Modifier
                .menuAnchor(MenuAnchorType.PrimaryEditable, true)
                .fillMaxWidth(),
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) } // AGREGA LA FLECHITA INTERACTIVA
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(text = { Text("Opcion 1") }, onClick = {
                expanded = false
                selected = "Opcion 1"
            })
            DropdownMenuItem(text = { Text("Opcion 2") }, onClick = {
                expanded = false
                selected = "Opcion 2"
            })
            DropdownMenuItem(text = { Text("Opcion 3") }, onClick = {
                expanded = false
                selected = "Opcion 3"
            })
            DropdownMenuItem(text = { Text("Opcion 4") }, onClick = {
                expanded = false
                selected = "Opcion 4"
            })

        }
    }


}

@Composable
fun MyDropDownMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier) {
        Button(onClick = { expanded = true }) { Text("Ver opciones") }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(16.dp, 16.dp),
            properties = PopupProperties(
                focusable = true,
                dismissOnClickOutside = false,
                dismissOnBackPress = false,
                clippingEnabled = false // EVITA QUE SE SALGA DE LA PANTALLA SI ES TRUE
            )
        ) {

            DropdownMenuItem(text = { Text("Opcion 1") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text("Opcion 2") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text("Opcion 3") }, onClick = { expanded = false })
            DropdownMenuItem(text = { Text("Opcion 4") }, onClick = { expanded = false })

        }

    }
}

@Composable
fun MyDropDownItem(modifier: Modifier = Modifier) {
    Column(modifier) {
        DropdownMenuItem(
            modifier = Modifier.fillMaxWidth(),
            text = {
                Text("Ejemplo 1")
            },
            leadingIcon = {
                Icon(
                    painterResource(R.drawable.ic_fonito),
                    contentDescription = null
                )
            },
            trailingIcon = {
                Icon(
                    painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
            },
            contentPadding = PaddingValues(16.dp),
            colors = MenuDefaults.itemColors(
                textColor = Color.Red,
                leadingIconColor = Color.Magenta,
                trailingIconColor = Color.Green,
                disabledTextColor = Color.Gray,
                disabledLeadingIconColor = Color.Gray,
                disabledTrailingIconColor = Color.Gray,
            ),
            enabled = true,
            onClick = {})
    }
}

