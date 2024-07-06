package com.example.flightapp.flighttime.presentation

import android.R
import android.content.Intent
import android.os.Bundle
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import com.example.flightapp.ui.theme.FlightTimeTheme
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flightapp.flighttime.data.sensors.SensorService
import com.example.flightapp.flighttime.presentation.util.Screen
import com.example.flightapp.flighttime.presentation.senor.SensorScreen
import com.example.flightapp.flighttime.presentation.senor.SensorViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.modules.ApplicationContextModule
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import org.intellij.lang.annotations.JdkConstants

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlightTimeTheme {
                
                val viewModel = viewModel<SensorViewModel>()
                val isDark = viewModel.isDark
                val temp = viewModel.temp
                val pressure = viewModel.pressure
                val accelerationX = viewModel.accelerationX

                /*
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
                    )*/
                    // Text(text = "Temp: $temp")
                    //Text(text = "Pressure: $pressure")
                    //Text(text = "AcelerationX: $accelerationX")

                //}

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
                            .padding(10.dp,0.dp,10.dp,0.dp),
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