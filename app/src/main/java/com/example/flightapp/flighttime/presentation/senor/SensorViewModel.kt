package com.example.flightapp.flighttime.presentation.senor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.flightapp.flighttime.data.MeasurableSensor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class SensorViewModel @Inject constructor(
    @Named("LightSensor")lightSensor: MeasurableSensor,
    @Named("TemperatureSensor")temperatureSensor: MeasurableSensor,
    @Named("BarometerSensor")barometerSensor: MeasurableSensor,
    @Named("AcceleratorSensor")accelerometerSensor: MeasurableSensor
    ) : ViewModel() {

    //private val _sensorData = MutableStateFlow<SensorData?>(null)
    //val sensorData: MutableStateFlow<SensorData?> = _sensorData
    var isDark by mutableStateOf(false)
    var temp by mutableStateOf(0.0f)
    var pressure by mutableStateOf(0.0f)
    var accelerationX by mutableStateOf(0.0f)

    init {
        lightSensor.startListening()
        lightSensor.setOnSensorValuesChangedListener { values ->
            val lux = values[0]
            isDark = lux < 60f
        }
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
    }
    /*
    fun getSensorData() {
        _sensorData.value = sensorRepository.getSensorData().value
    }
    */
}