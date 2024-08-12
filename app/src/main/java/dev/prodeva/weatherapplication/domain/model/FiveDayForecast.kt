package dev.prodeva.weatherapplication.domain.model

import com.squareup.moshi.Json

data class FiveDayForecast(
    @field:Json(name = "city")
    val city: City,
    @field:Json(name = "cnt")
    val cnt: Int,
    @field:Json(name = "cod")
    val cod: String,
    @field:Json(name = "list")
    val list: List<WeatherItem>,
    @field:Json(name = "message")
    val message: Int
)