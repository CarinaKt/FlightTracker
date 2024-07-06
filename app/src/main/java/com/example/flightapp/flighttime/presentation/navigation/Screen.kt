package com.example.flightapp.flighttime.presentation.navigation

sealed class Screen(val route: String) {
    object SensorScreen: Screen("sensor_screen")
    object LightScreen: Screen("light_screen")
    //object FlightScreen: Screen("flight_screen")
}