package com.example.flightapp.flighttime.presentation.senor

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import com.example.flightapp.flighttime.data.AndroidSensor

class LightSensor(
    context: Context
): AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_LIGHT,
    sensorType = Sensor.TYPE_LIGHT
)