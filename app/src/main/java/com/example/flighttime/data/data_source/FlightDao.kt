package com.example.flighttime.data.data_source

import androidx.room.*
import com.example.flighttime.domain.model.Flight
import kotlinx.coroutines.flow.Flow

@Dao
interface FlightDao {

    @Query("SELECT * FROM flight")
    fun getFlight(): Flow<List<Flight>>

    @Query("SELECT * FROM flight WHERE id = :id")
    suspend fun getFlightById(id: Int): Flight?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlight(flight: Flight)

    @Delete
    suspend fun deleteFlight(flight: Flight)
}