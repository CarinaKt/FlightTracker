package com.example.flightapp.flighttime.presentation.senor

import android.content.Context
import android.content.Intent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.flightapp.flighttime.data.sensors.SensorService

@ExperimentalAnimationApi
@Composable
fun SensorScreen(
    navController: NavController,
    viewModel: SensorViewModel = hiltViewModel()
) {
    //val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val isDark = viewModel.isDark

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    //navController.navigate(Screen.FlightScreen.route)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Flights")
            }
        },
        scaffoldState = scaffoldState
    ){
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
    }
 /*   Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    //navController.navigate(Screen.FlightScreen.route)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Flights")
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        // viewModel.onEvent()
                    }) {
                    Text(text = "Flights")
                }
            }

        }
    }*/
}