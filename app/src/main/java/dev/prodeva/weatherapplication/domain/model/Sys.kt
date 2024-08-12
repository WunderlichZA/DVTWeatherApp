package dev.prodeva.weatherapplication.domain.model

import com.squareup.moshi.Json

data class Sys(
    @field:Json(name = "pod")
    val pod: String
)