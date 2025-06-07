package com.example.soccergpsapp.model

data class GpsData(
    val ID: String,
    val lat: Double,
    val lng: Double,
    val alt: Double,
    val sats: Int,
    val hdop: Double,
    val speed: Double,
    val course: Double,
    val date: String,
    val time: String
)
