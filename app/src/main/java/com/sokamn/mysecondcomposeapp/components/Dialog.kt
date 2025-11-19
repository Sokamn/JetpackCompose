package com.sokamn.mysecondcomposeapp.components

import android.icu.util.Calendar
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.sokamn.mysecondcomposeapp.components.model.PokemonCombat

@Composable
fun MyDialog() {
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = { Button(onClick = { showDialog = false }) { Text("Entendido") } },
            dismissButton = { TextButton(onClick = { showDialog = false }) { Text("Cancelar") } },
            text = { Text("Esta es mi descripción") },
            title = { Text("¿Deseas hacer esta acción?") },
            icon = {
                Icon(
                    modifier = Modifier.size(52.dp),
                    imageVector = Icons.Default.Info,
                    contentDescription = null
                )
            },
            shape = RoundedCornerShape(12.dp),
            containerColor = Color.White,
            iconContentColor = Color.Red,
            titleContentColor = Color.Red,
            textContentColor = Color.Red,
            tonalElevation = 12.dp,
            properties = DialogProperties(
                dismissOnBackPress = true, // Si voy para atrás en el móvil, sale del dialog
                dismissOnClickOutside = true, // Si le doy click por fuera, sale del dialog
                securePolicy = SecureFlagPolicy.SecureOn,
                usePlatformDefaultWidth = true,
                decorFitsSystemWindows = true
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDateDialog() {
    var showDialog by remember { mutableStateOf(true) }

    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, +1)
    calendar.set(Calendar.MONTH, Calendar.JANUARY)

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = calendar.timeInMillis,
        initialDisplayedMonthMillis = calendar.timeInMillis,
        yearRange = 2024..2025,
        initialDisplayMode = DisplayMode.Picker,
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val filterCalendar = Calendar.getInstance().apply { timeInMillis = utcTimeMillis }
                val day = filterCalendar.get(Calendar.DAY_OF_YEAR)
                return day % 2 == 0
            }
        }
    )

    if (showDialog) {
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    showDialog = false
                    val result = datePickerState.selectedDateMillis
                    if (result != null) {
                        val newCalendar = Calendar.getInstance().apply { timeInMillis = result }
                        val day = newCalendar.get(Calendar.DAY_OF_MONTH)
                        val month = newCalendar.get(Calendar.MONTH) + 1
                        val year = newCalendar.get(Calendar.YEAR)
                        Log.i("FECHA", "$day/$month/$year")

                    }
                }) { Text("Confirmar") }
            }) {
            DatePicker(state = datePickerState)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTimePicker(modifier: Modifier = Modifier) {
    var showTimePicker by remember { mutableStateOf(true) }
    val timePickerState = rememberTimePickerState(
        initialHour = 10,
        initialMinute = 25,
        is24Hour = true

    )

    if (showTimePicker) {
        Dialog(onDismissRequest = { showTimePicker = false }) {
            Column(
                modifier = Modifier.background(Color.White),
                horizontalAlignment = Alignment.End
            ) {
                TimePicker(
                    timePickerState,
                    layoutType = TimePickerLayoutType.Vertical,
                    colors = TimePickerDefaults.colors()
                )
                TextButton(onClick = {
                    showTimePicker = false
                    val hour = timePickerState.hour
                    val minutes = timePickerState.minute
                    Log.i("HORA", "$hour:$minutes")
                }) { Text("Confirmar hora") }
            }
        }
    }
}

@Composable
fun MyCustomDialog(
    modifier: Modifier = Modifier,
    pokemonCombat: PokemonCombat,
    showDialog: Boolean,
    onStartCombat: () -> Unit,
    onDismiss: () -> Unit
) {
    if (showDialog) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(24))
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(pokemonCombat.pokemonA, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Spacer(Modifier.width(4.dp))
                    Text("VS")
                    Spacer(Modifier.width(4.dp))
                    Text(pokemonCombat.pokemonB, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }

                Button(onClick = { onStartCombat() }) { Text("¡A LUCHAR!") }
                TextButton(onClick = { onDismiss() }) { Text("Cancelar") }
            }
        }
    }
}