package dev.prodeva.weatherapplication.domain.usecases

import android.os.Build
import androidx.annotation.RequiresApi
import dev.prodeva.weatherapplication.core.Resource
import dev.prodeva.weatherapplication.data.models.WeatherForecast
import dev.prodeva.weatherapplication.domain.model.WeatherType
import dev.prodeva.weatherapplication.domain.repositories.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.inject.Inject

class GetWeatherForecastUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    @RequiresApi(Build.VERSION_CODES.O)
    suspend operator fun invoke(
        latitude: Double,
        longitude: Double
    ): Flow<Resource<List<WeatherForecast>>> {
        return flow {
            repository.getFiveDayForecast(latitude, longitude).collect { weather ->
                when (weather) {
                    is Resource.Error -> {
                        emit(Resource.Error(weather.message.toString()))
                    }

                    is Resource.Success -> {
                        val now = LocalDateTime.now()
                        val hour = if (now.minute < 30) now.hour else now.hour + 1
                        emit(Resource.Success(weather.data?.list?.map { weatherItem ->
                            println(
                                "GetWeatherForecastUseCase: " +
                                        LocalDateTime.ofEpochSecond(
                                            weatherItem.dt.toLong(),
                                            0,
                                            ZoneOffset.UTC
                                        ).hour

                            )
                            WeatherForecast(
                                weatherDate = LocalDateTime.ofEpochSecond(
                                    weatherItem.dt.toLong(),
                                    0,
                                    ZoneOffset.UTC
                                ),
                                weatherIcon = WeatherType.fromWMO(weatherItem.weather[0].id),
                                weatherTemperature = weatherItem.main.temp_max
                            )
                        }?.filter {
                            println("Local time hour = $hour")
                            it.weatherDate.hour == hour / 24
                        }?.take(5)
                        )
                        )
                    }

                    is Resource.Loading -> {
                        emit(Resource.Loading(true))
                    }
                }
            }
        }
    }
}