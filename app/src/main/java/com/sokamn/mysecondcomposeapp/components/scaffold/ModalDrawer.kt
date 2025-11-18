package com.sokamn.mysecondcomposeapp.components.scaffold

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sokamn.mysecondcomposeapp.components.model.DrawerItem

@Composable
fun MyModalDrawer(drawerState: DrawerState, onCloseNav: () -> Unit, content:@Composable () -> Unit) {

    val drawerItems = listOf(
        DrawerItem("Ejemplo 1", Icons.Default.AddCircle, "1"),
        DrawerItem("Ejemplo 2", Icons.Default.CheckCircle, "3"),
        DrawerItem("Ejemplo 3", Icons.Default.Face, "2"),
        DrawerItem("Salir", Icons.Default.Close, "")
    )
    var selectedIndex by remember { mutableIntStateOf(0) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp),
                drawerContentColor = Color.Red,
                drawerContainerColor = Color.LightGray
            ) {
                drawerItems.forEachIndexed { index, item ->
                    Spacer(Modifier.fillMaxWidth().height(32.dp))
                    MyNavDrawerItem(item, selectedIndex == index, onCloseNav){ selectedIndex = index }
                }
            }
        },
        scrimColor = Color.Red
    ) {
        content()
    }

}

@Composable
fun MyNavDrawerItem(item: DrawerItem, isSelected: Boolean, onCloseNav: ()-> Unit, onClick: ()-> Unit) {
    NavigationDrawerItem(
        label = { Text(item.title) },
        selected = isSelected,
        onClick = { if(item.title == "Salir"){ onCloseNav() } else{ onClick() } },
        icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null) },
        badge = { Badge(contentColor = Color.White , containerColor = if(isSelected) Color.DarkGray else Color.LightGray){ Text(item.badge) } },
        shape = RoundedCornerShape(20.dp),
        colors = NavigationDrawerItemDefaults.colors()
    )
}