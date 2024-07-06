package com.example.flightapp.flighttime.presentation

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import com.example.flightapp.ui.theme.FlightTimeTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flightapp.flighttime.data.sensors.SensorService
import com.example.flightapp.flighttime.presentation.navigation.NavGraph
import com.example.flightapp.flighttime.presentation.navigation.Screen
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
                val temp = viewModel.temp
                val pressure = viewModel.pressure
                val accelerationX = viewModel.accelerationX

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Flight Tracker") }
                        )
                    },
                ) {
                    NavGraph(this.application, temp, pressure, accelerationX)
                    /*Main(
                        applicationContext = this.application,
                        temp, pressure, accelerationX
                    )*/
                }
/*              Column(
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
                                    startService(it)
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
                                    startService(it)
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

                } */


            }
        }

    }

}

@Composable
fun Main(
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


@Composable
fun SensorData(data: Float?, data2: Float?, data3: Float?) {
    // data as lit and draw it with for
    Column() {
        Text(
            text = "temp: $data",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "pressure: $data2",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "altitude: $data3",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FlightTimeTheme {
        SensorData(data = 1.5f, data2 = 6.6f, data3 = 657.9878f)
    }
}