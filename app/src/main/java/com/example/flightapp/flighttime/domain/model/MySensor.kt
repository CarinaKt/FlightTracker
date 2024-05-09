package com.example.flightapp.flighttime.domain.model

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class MySensor(private val context: Context): SensorEventListener {
    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private var mSensor: Sensor? = null
    private var pressureS: Sensor? = null
    private var teperatureS: Sensor? = null

    init {
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            mSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE) != null) {
            pressureS = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE)
        }

        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null) {
            teperatureS = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
        }
    }

    fun registerListeners() {
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

    fun unregisterListeners() {
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent) {
        val sensorType = event.sensor.type
        when (sensorType) {
            Sensor.TYPE_ACCELEROMETER -> {
                // Handle accelerometer data
            }
            Sensor.TYPE_AMBIENT_TEMPERATURE -> {
                // Handle temperature data
            }
            Sensor.TYPE_PRESSURE -> {
                // Handle pressure data
            }
        }
    }

    override fun onAccuracyChanged(p0: android.hardware.Sensor?, p1: Int) {
        TODO("Not yet implemented")
    }
}