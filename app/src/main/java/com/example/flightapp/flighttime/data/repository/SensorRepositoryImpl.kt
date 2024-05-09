/*
package com.example.flightapp.flighttime.data.repository

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import com.example.flightapp.MainApplication
import com.example.flightapp.flighttime.domain.model.SensorData
import com.example.flightapp.flighttime.domain.repository.SensorRepository
import kotlinx.coroutines.flow.MutableStateFlow

class SensorRepositoryImpl(private val sensorManager: SensorManager) : SensorRepository {

    private val sensorData = MutableStateFlow<SensorData?>(null)

    init {
        sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY).also { sensor ->
            sensorManager.registerListener(object : SensorEventListener {
                override fun onSensorChanged(event: SensorEvent) {
                    val proximity = event.values[0]
                    sensorData.value = SensorData(proximity)
                }

                override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
            }, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun getSensorData(): MutableStateFlow<SensorData?> = sensorData
}*/
