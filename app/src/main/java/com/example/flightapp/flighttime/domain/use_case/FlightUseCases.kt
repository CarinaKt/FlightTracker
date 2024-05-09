package com.example.flightapp.flighttime.domain.use_case

data class FlightUseCases(
    val getFlights: GetFlights,
    val deleteFlight: DeleteFlight,
    val addFlight: AddFlight,
    val getFlight: GetFlight
)