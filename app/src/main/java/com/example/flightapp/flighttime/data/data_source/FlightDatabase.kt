package com.example.flightapp.flighttime.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.flightapp.flighttime.domain.model.Flight

@Database(
    entities = [Flight::class],
    version = 1
)
abstract class FlightDatabase: RoomDatabase() {

    abstract val flightDao: FlightDao

    companion object {
        const val DATABASE_NAME = "flight_db"
    }
}