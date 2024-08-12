package dev.prodeva.weatherapplication.domain.model

import com.squareup.moshi.Json

data class Main(
    @field:Json(name = "feels_like")
    val feels_like: Double,
    @field:Json(name = "grnd_level")
    val grnd_level: Int,
    @field:Json(name = "humidity")
    val humidity: Int,
    @field:Json(name = "pressure")
    val pressure: Int,
    @field:Json(name = "sea_level")
    val sea_level: Int,
    @field:Json(name = "temp")
    val temp: Double,
    @field:Json(name = "temp_kf")
    val temp_kf: Double,
    @field:Json(name = "temp_max")
    val temp_max: Double,
    @field:Json(name = "temp_min")
    val temp_min: Double
)