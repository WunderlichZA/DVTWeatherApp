package dev.prodeva.weatherapplication.domain.model

import com.squareup.moshi.Json

data class WeatherItem(
    @field:Json(name = "clouds")
    val clouds: Clouds,
    @field:Json(name = "dt")
    val dt: Int,
    @field:Json(name = "dtTxt")
    val dtTxt: String,
    @field:Json(name = "main")
    val main: Main,
    @field:Json(name = "pop")
    val pop: Double,
    @field:Json(name = "sys")
    val sys: Sys,
    @field:Json(name = "visibility")
    val visibility: Int,
    @field:Json(name = "weather")
    val weather: List<Weather>,
    @field:Json(name = "wind")
    val wind: Wind
)
