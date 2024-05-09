package com.example.flightapp.flighttime.presentation

import android.os.Bundle
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import com.example.flightapp.ui.theme.FlightTimeTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flightapp.flighttime.presentation.util.Screen
import com.example.flightapp.flighttime.presentation.senor.SensorScreen
import com.example.flightapp.flighttime.presentation.senor.SensorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlightTimeTheme {
                val viewModel = viewModel<SensorViewModel>()
                val isDark = viewModel.isDark
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            if (isDark) Color.DarkGray else Color.White
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if(isDark) {
                            "It's dark outside"
                        } else {
                            "It's bright outside"
                        },
                        color = if(isDark) Color.White else Color.DarkGray
                    )
                }
                /*
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {


                    /*val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.SensorScreen.route
                    ) {
                        composable(route = Screen.SensorScreen.route) {
                            SensorScreen(navController = navController)
                        }
                        composable(
                            route = Screen.SensorScreen.route
                        ) {
                        }
                    }*/
                }*/
            }
        }

    }

}

@Composable
fun SensorData(data: Float?, data2: Float?, data3: Float?) {
    Text(text = "temp: $data pressure: $data2 altitude: $data3")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FlightTimeTheme {
        //Greeting(0.0)
    }
}