package com.example.mvvm.navigation

sealed class AppScreen (val route:String){

    object Login: AppScreen("LoginScreen")
    object Register: AppScreen("RegisterScreen")
    object Home: AppScreen("HomeScreen")
    object Create: AppScreen("CreateScreen")

}