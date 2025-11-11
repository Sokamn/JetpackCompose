package com.sokamn.mysecondcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun MyTextFieldParent(modifier: Modifier) {
    var user by rememberSaveable { mutableStateOf("Sokamn") }
    var value by rememberSaveable { mutableStateOf("") }
    var advancedValue by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(modifier) {
        MyTextField(user = user) { user = it }
        MySecondTextField(value = value) { value = it }
        MyAdvancedTextField(value = advancedValue) { advancedValue = it }
        MyPasswordTextField(pass = password) { password = it }
        MyOutlinedTextField(value = value) { value = it }
    }
}

@Composable
fun MyTextField(user: String, onUserChange: (String) -> Unit) {
    TextField(user, onValueChange = { onUserChange(it) }, readOnly = true)
}

@Composable
fun MySecondTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value,
        onValueChange = { onValueChange(it) },
        placeholder = { Text("Ingrese su nombre") },
        label = { Text("Sokamnodes") })
}

@Composable
fun MyAdvancedTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(value, onValueChange = {
//        if(it.contains("a")){
        onValueChange(it.replace("a", ""))
//        }else{
//            onValueChange(it)
//        }
    })
}

@Composable
fun MyPasswordTextField(pass: String, onPassChange: (String) -> Unit) {

    var passwordHidden by remember { mutableStateOf(false) }

    TextField(
        value = pass,
        onValueChange = { onPassChange(it) },
        singleLine = true,
        label = { Text("Ingrese su contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Text(if (passwordHidden) "Mostrar" else "Ocultar",
                modifier = Modifier.clickable { passwordHidden = !passwordHidden })
        }
    )
}

@Composable
fun MyOutlinedTextField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value,
        onValueChange = { onValueChange(it) },
        placeholder = { Text("Ingrese su nombre") },
        label = { Text("Sokamnodes") })

    //BasicTextField(
    //    value,
    //    onValueChange = { onValueChange(it) })
}
