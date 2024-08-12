package dev.prodeva.weatherapplication.data.remote

import dev.prodeva.weatherapplication.domain.model.CurrentWeather
import dev.prodeva.weatherapplication.domain.model.FiveDayForecast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("weather?")
    suspend fun getWeatherUpdate(@Query("lat") lat : Double, @Query("lon") lon: Double,
                                 @Query("appid") apikey : String) : Response<CurrentWeather>

    @GET("forecast?")
    suspend fun getFiveDayForecast(@Query("lat") lat : Double, @Query("lon") lon: Double,
                                   @Query("appid") apikey : String) : Response<FiveDayForecast>
}
