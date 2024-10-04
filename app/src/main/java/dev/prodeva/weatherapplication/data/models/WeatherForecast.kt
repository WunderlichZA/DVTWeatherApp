package dev.prodeva.weatherapplication.data.models

import androidx.compose.runtime.Stable
import dev.prodeva.weatherapplication.domain.model.WeatherType
import java.time.LocalDateTime

@Stable
data class WeatherForecast(
    val weatherDate : LocalDateTime,
    val weatherIcon : WeatherType,
    val weatherTemperature: Double
)