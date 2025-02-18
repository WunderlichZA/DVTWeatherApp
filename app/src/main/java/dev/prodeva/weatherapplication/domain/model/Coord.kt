package dev.prodeva.weatherapplication.domain.model

import com.squareup.moshi.Json

data class Coord(
    @field:Json(name = "lat")
    val lat: Double,
    @field:Json(name = "lon")
    val lon: Double
)