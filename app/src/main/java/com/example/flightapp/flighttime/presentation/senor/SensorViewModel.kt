package com.example.flightapp.flighttime.presentation.senor

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.flightapp.flighttime.data.MeasurableSensor
import com.example.flightapp.flighttime.domain.model.SensorData
// import com.example.flightapp.flighttime.domain.repository.SensorRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SensorViewModel @Inject constructor(
    private val lightSensor: MeasurableSensor
    ) : ViewModel() {

    //private val _sensorData = MutableStateFlow<SensorData?>(null)
    //val sensorData: MutableStateFlow<SensorData?> = _sensorData
    var isDark by mutableStateOf(false)

    init {
        lightSensor.startListening()
        lightSensor.setOnSensorValuesChangedListener { values ->
            val lux = values[0]
            isDark = lux < 60f
        }
    }
    /*
    fun getSensorData() {
        _sensorData.value = sensorRepository.getSensorData().value
    }
    */
}