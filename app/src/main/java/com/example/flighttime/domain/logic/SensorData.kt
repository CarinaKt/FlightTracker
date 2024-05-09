package com.example.flighttime.domain.logic

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.flighttime.ui.theme.FlightTimeTheme
import android.app.Activity

class SensorData constructor(private val context: Context): SensorEventListener {
    private var altitude: Float? = null
    private var temp: Float? = null
    private var pressure: Float? = null
    private lateinit var sensorManager: SensorManager
    private var mSensor: Sensor? = null
    private var pressureS: Sensor? = null
    private var teperatureS: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

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
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }


    override fun onReceive() {
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