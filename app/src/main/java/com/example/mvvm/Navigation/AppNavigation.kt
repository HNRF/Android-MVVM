package com.example.mvvm.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.uii.*

@Composable
fun AppNavigation(){

    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = AppScreen.Login.route)

    {
       composable(AppScreen.Login.route){ LoginScreen(navigationController, LoginViewModel()) }
        composable(AppScreen.Register.route){ ResgisterScreen(navigationController, RegisterViewModel()) }
    }


}


