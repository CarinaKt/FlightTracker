package com.example.flightapp.flighttime.presentation.navigation

import android.app.Application
import androidx.compose.animation.ExperimentalAnimationApi
import com.example.flightapp.flighttime.presentation.senor.SensorScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flightapp.flighttime.presentation.senor.LightScreen
import dagger.hilt.android.qualifiers.ApplicationContext

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(
    applicationContext: Application,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.SensorScreen.route
) {
    NavHost(navController = navController, startDestination = startDestination, modifier = modifier) {
        composable(route = Screen.SensorScreen.route) {
            SensorScreen(applicationContext, navController)
        }
        composable(route = Screen.LightScreen.route) {
            LightScreen(navController = navController)
        }
    }
}