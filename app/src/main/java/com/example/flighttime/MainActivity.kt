package com.example.flighttime

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.flighttime.ui.theme.FlightTimeTheme

class MainActivity : ComponentActivity(), SensorEventListener {
    private var altitude: Float? = null
    private var temp: Float? = null
    private var pressure: Float? = null
    private lateinit var sensorManager: SensorManager
    private var mSensor: Sensor? = null
    private var pressureS: Sensor? = null
    private var teperatureS: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            val gravSensors: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER)
            // Use the version 3 gravity sensor.
            mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE) != null) {
            pressureS = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE)
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null) {
            teperatureS = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
        }

    }

    override fun onSensorChanged(event: SensorEvent) {
        // The light sensor returns a single value.
        // Many sensors return 3 values, one for each axis.
        val sensorType = event.sensor.type
        if (sensorType == Sensor.TYPE_ACCELEROMETER) {
            val accelerationX = event.values[0]
            val accelerationY = event.values[1]
            val accelerationZ = event.values[2]
        }

        if (sensorType == Sensor.TYPE_AMBIENT_TEMPERATURE){
            temp = event.values[0]
        }

        if (sensorType == Sensor.TYPE_PRESSURE){
            pressure = event.values[0]
        }

        altitude = ( SensorManager.PRESSURE_STANDARD_ATMOSPHERE - pressure!! ) * 1000

        // Do something with this sensor value.
        setContent {
            FlightTimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SensorData( data = temp, data2 = pressure, data3 = altitude )
                }
            }
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onResume() {
        super.onResume()
        mSensor?.also { sensor ->
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
        pressureS?.also { sensor ->
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
        teperatureS?.also { sensor ->
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
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