package com.example.flightapp.flighttime.domain.repository

import com.example.flightapp.flighttime.domain.model.Flight
import kotlinx.coroutines.flow.Flow

interface FlightRepository {

    fun getFlights(): Flow<List<Flight>>

    suspend fun getFlightById(id: Int): Flight?

    suspend fun insertFlight(flight: Flight)

    suspend fun deleteFlight(flight: Flight)
}