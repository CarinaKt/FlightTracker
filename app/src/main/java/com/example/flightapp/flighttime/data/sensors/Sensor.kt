package com.example.flightapp.flighttime.presentation.senor

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import com.example.flightapp.flighttime.data.sensors.AndroidSensor


class LightSensor(
    context: Context
): AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_LIGHT,
    sensorType = Sensor.TYPE_LIGHT
)

class BarometerSensor(
    context: Context
): AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_BAROMETER,
    sensorType = Sensor.TYPE_PRESSURE
)


class TemperatureSensor(
    context: Context
): AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_AMBIENT_TEMPERATURE,
    sensorType = Sensor.TYPE_AMBIENT_TEMPERATURE
)


class AccelerometerSensor(
    context: Context
): AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_ACCELEROMETER,
    sensorType = Sensor.TYPE_LINEAR_ACCELERATION
)
