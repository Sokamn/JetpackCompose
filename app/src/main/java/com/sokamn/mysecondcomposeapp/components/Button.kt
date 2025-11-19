package com.sokamn.mysecondcomposeapp.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sokamn.mysecondcomposeapp.R

@Composable
fun MyButtons(modifier: Modifier){
    Column(modifier){
        MyButton()
        MyOutlinedButton()
        MyTextButton()
        MyElevatedButton()
        MyFilledTonalButton()
    }

}


@Composable
fun MyButton(){
    Button(onClick = { Log.i("Sokamn", "Botón Presionado") },
        enabled = false, shape = RoundedCornerShape(30.dp),
        border = BorderStroke(1.dp, Color.Red),
        colors = ButtonDefaults.buttonColors(contentColor = Color.Red, containerColor = Color.White,
            disabledContainerColor = Color.Yellow, disabledContentColor = Color.Green)
    ) { Text("Presioname") }

}

@Composable
fun MyOutlinedButton(){
    OutlinedButton(onClick = {  }, colors = ButtonDefaults.outlinedButtonColors(
        containerColor = Color.Transparent
    )) { Text("Outlined") }
}

@Composable
fun MyTextButton(){
    TextButton(onClick = {  }){ Text("TextButton") }
}

@Composable
fun MyElevatedButton(){
    ElevatedButton(onClick = {  }, elevation = ButtonDefaults.elevatedButtonElevation()) { Text("ElevatedButton") }
}

@Composable
fun MyFilledTonalButton(){
    FilledTonalButton(onClick = {  }) { Text("FilledTonalButton") }
}

@Composable
fun MyFAB(modifier: Modifier = Modifier, showCombat:() -> Unit) {

    FloatingActionButton(
        onClick = { showCombat() },
        shape = CircleShape,
        contentColor = Color.White,
        containerColor = Color.Red,
        elevation = FloatingActionButtonDefaults.elevation(12.dp)
    ) {
        Icon(painterResource(R.drawable.ic_add), contentDescription = "Fonito")
    }
}