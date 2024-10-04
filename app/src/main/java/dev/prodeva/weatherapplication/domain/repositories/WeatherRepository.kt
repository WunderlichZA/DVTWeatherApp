package dev.prodeva.weatherapplication.domain.repositories

import dev.prodeva.weatherapplication.core.Resource
import dev.prodeva.weatherapplication.data.models.WeatherForecast
import dev.prodeva.weatherapplication.domain.model.CurrentWeather
import dev.prodeva.weatherapplication.domain.model.FiveDayForecast
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun getWeatherUpdate(lat : Double, lon: Double) :
            Flow<Resource<CurrentWeather>>

    suspend fun getFiveDayForecast(lat : Double, lon: Double) :
            Flow<Resource<FiveDayForecast>>
}