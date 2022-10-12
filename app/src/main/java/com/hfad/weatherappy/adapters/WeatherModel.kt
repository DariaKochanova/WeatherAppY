package com.hfad.weatherappy.adapters

data class WeatherModel(
    val city: String,
    val time: String,
    val condition: String,
    val correntTemp: String,
    val maxTemp: String,
    val minTemp: String,
    val imageUrl: String,
    val hours: String
)
