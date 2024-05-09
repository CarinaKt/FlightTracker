package com.example.flightapp.flighttime.presentation.util

sealed class Screen(val route: String) {
    object SensorScreen: Screen("sensor_screen")
    //object FlightScreen: Screen("flight_screen")
}