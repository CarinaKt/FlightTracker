package com.example.flightapp.flighttime.presentation.senor

import android.app.Application
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.flightapp.flighttime.data.sensors.SensorService
import com.example.flightapp.flighttime.presentation.SensorData
import com.example.flightapp.flighttime.presentation.navigation.Screen

@ExperimentalAnimationApi

@Composable
fun SensorScreen(
    applicationContext: Application,
    temp: Float,
    pressure: Float,
    accelerationX: Float
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp, 10.dp, 0.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top,
        ){
            SensorData(data = temp, data2 = pressure, data3 = accelerationX)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                shape = MaterialTheme.shapes.small,
                contentPadding = PaddingValues(25.dp, 15.dp, ),
                onClick = {
                    Intent(applicationContext, SensorService::class.java).also {
                        it.action = SensorService.Actions.START.toString()
                        applicationContext.startService(it)
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Start",
                    fontSize = 24.sp,
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Button(
                shape = MaterialTheme.shapes.small,
                contentPadding = PaddingValues(25.dp, 15.dp, ),
                onClick = {
                    Intent(applicationContext, SensorService::class.java).also {
                        it.action = SensorService.Actions.STOP.toString()
                        applicationContext.startService(it)
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Stop",
                    fontSize = 24.sp
                )
            }
        }

    }
}
