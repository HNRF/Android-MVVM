package com.example.mvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.uii.*
import com.example.mvvm.uii.screens.CreateScreen
import com.example.mvvm.uii.viewmodel.CreateViewModel
import com.example.mvvm.uii.viewmodel.LoginViewModel
import com.example.mvvm.uii.viewmodel.RegisterViewModel

@Composable
fun AppNavigation(){

    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = AppScreen.Login.route)

    {
       composable(AppScreen.Login.route){ LoginScreen(navigationController, LoginViewModel()) }
        composable(AppScreen.Register.route){ ResgisterScreen(navigationController, RegisterViewModel()) }
        composable(AppScreen.Home.route){ HomeScreen(navigationController) }
        composable(AppScreen.Create.route){ CreateScreen(navigationController, CreateViewModel()) }
    }


}


