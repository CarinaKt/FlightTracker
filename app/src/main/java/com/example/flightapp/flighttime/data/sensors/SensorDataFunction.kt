package com.example.flightapp.flighttime.data.sensors

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.flightapp.flighttime.data.MeasurableSensor
import com.example.flightapp.flighttime.presentation.senor.HumiditySensor
import javax.inject.Inject
import javax.inject.Named

class SensorDataFunction @Inject constructor(
    @Named("TemperatureSensor")temperatureSensor: MeasurableSensor,
    @Named("BarometerSensor")barometerSensor: MeasurableSensor,
    @Named("AcceleratorSensor")accelerometerSensor: MeasurableSensor,
    @Named("AcceleratorSensor")humiditySensor: MeasurableSensor
) {

    var temp by mutableStateOf(0.0f)
    var pressure by mutableStateOf(0.0f)
    var accelerationX by mutableStateOf(0.0f)
    var humidity by mutableStateOf(0.0f)

    init {
        temperatureSensor.startListening()
        temperatureSensor.setOnSensorValuesChangedListener { values ->
            temp = values[0]
        }
        accelerometerSensor.startListening()
        accelerometerSensor.setOnSensorValuesChangedListener { values ->
            accelerationX = values[0]
        }
        barometerSensor.startListening()
        barometerSensor.setOnSensorValuesChangedListener { values ->
            pressure = values[0]
        }
        humiditySensor.startListening()
        humiditySensor.setOnSensorValuesChangedListener { values ->
            humidity = values[0]
        }
    }

    val seaPressure = 1013.25f
    val expTable = doubleArrayOf(
        0.190265, 0.255755, 0.328094, 0.408282, 0.500000, 0.610402,
        0.745356, 0.911043, 1.120434, 1.400000, 1.800000
    )

    fun getAltitudeOptimized(): Float {
        val tempCorr = 1.0f - 0.0000225577f * humidity * (temp - 15.0f) // temperature correction factor
        val exp = expTable[(pressure / 100.0f).toInt()] // lookup table for exponent value
        return (((Math.pow((seaPressure / pressure).toDouble(), exp) - 1.0f) * (tempCorr * (temp + 273.15f))) / 0.0065f).toFloat()
    }

    private fun speed(){

    }

    // TODO: self updating Data
    private fun acceleration(): Float {
        return accelerationX
    }
}