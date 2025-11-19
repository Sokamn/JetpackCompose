package com.sokamn.mysecondcomposeapp.components

import android.widget.Button
import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MyBasicList(modifier: Modifier = Modifier, onItemClick: (String) -> Unit) {
    val names = listOf(
        "Matias",
        "Alex",
        "Luis",
        "Susana",
        "Matias",
        "Alex",
        "Luis",
        "Susana",
        "Matias",
        "Alex",
        "Luis",
        "Susana"
    )

    LazyColumn {
        items(names) {
            Text(
                it, Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .clickable { onItemClick(it) }, textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun MyAdvancedList(modifier: Modifier = Modifier) {
    var items by remember {
        mutableStateOf(
            List(100) { "item número $it" }
        )
    }

    LazyColumn {
        item {
            Button(onClick = { items = items.toMutableList().apply { add(0, "Hola") } }){ Text("Añadir") }
        }
        itemsIndexed(items, key = {_, item -> item  }) { index, item ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("$item indice: $index")
                TextButton({
                    items = items.toMutableList().apply {
                        remove(item)
                        // removeAt(index)
                    }
                }) { Text("Borrar") }
            }
        }
    }

}