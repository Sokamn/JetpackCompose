package com.sokamn.mysecondcomposeapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyBadge() {
    Badge(
        containerColor = Color.Red,
        contentColor = Color.White
    ) {
        Text("5")
    }
}

@Preview
@Composable
fun MyBadgeBox() {
    BadgedBox(modifier = Modifier, badge = { MyBadge() } ) {
        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Carrito")
    }
}