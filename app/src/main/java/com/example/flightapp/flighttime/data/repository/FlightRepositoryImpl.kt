package com.example.flightapp.flighttime.data.repository

import com.example.flightapp.flighttime.data.data_source.FlightDao
import com.example.flightapp.flighttime.domain.model.Flight
import com.example.flightapp.flighttime.domain.repository.FlightRepository
import kotlinx.coroutines.flow.Flow

class FlightRepositoryImpl (
    private val flightDao: FlightDao
    ): FlightRepository {

    override fun getFlights(): Flow<List<Flight>> {
        return flightDao.getFlights()
    }

    override suspend fun getFlightById(id: Int): Flight? {
        return flightDao.getFlightById(id)
    }

    override suspend fun insertFlight(flight: Flight) {
        return flightDao.insertFlight(flight)
    }

    override suspend fun deleteFlight(flight: Flight) {
        return flightDao.deleteFlight(flight)
    }

}