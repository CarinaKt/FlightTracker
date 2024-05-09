package com.example.flighttime.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Flight(
    val title: String,
    val content: String,
    val timestamp: Long,
    @PrimaryKey val id: Int? = null
)