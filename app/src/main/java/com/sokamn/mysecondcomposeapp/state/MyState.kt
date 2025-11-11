package com.sokamn.mysecondcomposeapp.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun MyState(modifier: Modifier) {
    var number by rememberSaveable { mutableStateOf(0) }


    //* by -> StateProperties
    Column(modifier) {
        // ES EXACTAMENTE LO MISMO, LOS PARAMS LAMBDA PODEMOS LLAMARLO DESPUÉS DEL PARENTESIS
        // SI ES EL ÚLTIMO PARAMETRO
        StateExample1(number){ number += 1 }
        StateExample2(number, onClick = { number += 2 })
    }

}

@Composable
fun StateExample1(number: Int, onClick:() -> Unit){
    Text("Púlsame: ${number}", modifier = Modifier.clickable { onClick() })
}

@Composable
fun StateExample2(number: Int, onClick:() -> Unit){
    Text("Púlsame: ${number}", modifier = Modifier.clickable { onClick() })
}

@Composable
fun StateExample3(){
    var number by rememberSaveable { mutableStateOf(0) }
    Text("Púlsame: ${number}", modifier = Modifier.clickable { number += 1 })
}
