package com.sokamn.mysecondcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.sokamn.mysecondcomposeapp.components.navigation.examples.DetailScreen
import com.sokamn.mysecondcomposeapp.components.navigation.examples.HomeScreen
import com.sokamn.mysecondcomposeapp.components.navigation.examples.LoginScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Home){
        composable<Login>{
            LoginScreen(navigateBack = { navController.popBackStack() })
        }

        composable<Home>{
            HomeScreen(
                navigateToLogin = { navController.navigate(Login) },
                navigateToDetail = { id, test -> navController.navigate(Detail(id = id, test = test)) }
            )
        }

        composable<Detail> { navBackStackEntry ->
            val detail = navBackStackEntry.toRoute<Detail>()

            DetailScreen(detail.id, detail.test, navigateBack = { navController.popBackStack() })
        }

    }
}