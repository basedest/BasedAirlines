package com.basedest.airlines.data

data class Ticket(
    val id: String = java.util.UUID.randomUUID().toString(),
    val passengerName: String,
    val isChild: Boolean,
    val departureCity: String,
    val arrivalCity: String,
    val price: Double,
    val date: String
)