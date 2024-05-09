package com.example.flightapp.flighttime.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Flight(
    val start: String,
    val destination: String,
    val timestamp: Long,
    val startTime: Long,
    val landingTime: Long,
    @PrimaryKey val id: Int? = null
)