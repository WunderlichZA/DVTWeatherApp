package dev.prodeva.weatherapplication.data.repositories

import dev.prodeva.weatherapplication.core.Constants
import dev.prodeva.weatherapplication.core.Resource
import dev.prodeva.weatherapplication.data.remote.WeatherAPI
import dev.prodeva.weatherapplication.domain.model.CurrentWeather
import dev.prodeva.weatherapplication.domain.model.FiveDayForecast
import dev.prodeva.weatherapplication.domain.repositories.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherAPI: WeatherAPI
) : WeatherRepository {
    override suspend fun getWeatherUpdate(
        lat: Double,
        lon: Double
    ): Flow<Resource<CurrentWeather>> {
        return flow {
            try {
                emit(Resource.Loading(true))
                val response = weatherAPI.getWeatherUpdate(lat, lon, Constants.apiKey)
                println("WeatherRepositoryImpl" + response.errorBody())
                if (response.isSuccessful) {
                    emit(Resource.Loading(false))
                    emit(Resource.Success(response.body()))
                } else {
                    emit(Resource.Error(response.message()))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                println(e.message)
            }
        }
    }

    override suspend fun getFiveDayForecast(
        lat: Double,
        lon: Double
    ): Flow<Resource<FiveDayForecast>> {
        return flow {
            emit(Resource.Loading(true))
            val response = weatherAPI.getFiveDayForecast(lat, lon, Constants.apiKey)
            if(response.isSuccessful){
                emit(Resource.Loading(false))
                emit(Resource.Success(response.body()))
            }else{
                println(response.message())
                emit(Resource.Error(response.message()))
            }
        }
    }
}