package dev.prodeva.weatherapplication.data.models

data class FiveDayWeatherForecast(
    val dayOfWeek : String,
    val weatherMain : String,
    val weatherTemperature: String
)