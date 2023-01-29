package com.example.mvvm.Navigation




sealed class AppScreen (val route:String){

    object Login: AppScreen("LoginScreen")
    object Register: AppScreen("RegisterScreen")

}