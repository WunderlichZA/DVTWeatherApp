package dev.prodeva.weatherapplication.domain.model

import com.squareup.moshi.Json

data class Rain(
    @field:Json(name = "3h")
    val `3h`: Double
)