package com.sokamn.mysecondcomposeapp.components.scaffold

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sokamn.mysecondcomposeapp.R
import com.sokamn.mysecondcomposeapp.components.model.NavItem

@Composable
fun MyNavigationBar(modifier: Modifier = Modifier) {

    val itemList = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Home", Icons.Default.Call),
        NavItem("Home", Icons.Default.Person),
    )

    var selectedIndex by remember { mutableIntStateOf(0) }

    NavigationBar(modifier, containerColor = Color.White, tonalElevation = 10.dp) {

        itemList.forEachIndexed { index, item ->
            SokamnDevItem(item, isSelected = index == selectedIndex){ selectedIndex = index }
        }

    }
}

@Composable
fun RowScope.SokamnDevItem(navItem: NavItem, isSelected: Boolean, onClick: () -> Unit) {

    NavigationBarItem(
        selected = isSelected,
        onClick = { onClick() },
        icon = { Icon(imageVector = navItem.icon, contentDescription = navItem.name) },
        label = { Text(navItem.name) },
        alwaysShowLabel = false,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.White,
            selectedTextColor = Color.Red,
            indicatorColor = Color.Red,
            unselectedIconColor = Color.Gray,
            unselectedTextColor = Color.Gray,
            disabledIconColor = Color.Gray,
            disabledTextColor = Color.Gray
        )
    )
}