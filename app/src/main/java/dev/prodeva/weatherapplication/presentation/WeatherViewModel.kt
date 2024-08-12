package dev.prodeva.weatherapplication.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.prodeva.weatherapplication.core.Resource
import dev.prodeva.weatherapplication.core.resourceFlow
import dev.prodeva.weatherapplication.data.models.FiveDayWeatherForecast
import dev.prodeva.weatherapplication.domain.location.LocationTracker
import dev.prodeva.weatherapplication.domain.repositories.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

private const val DEFAULT_TIMEOUT = 5000L

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {
    private val _currentWeatherFlow =
        MutableStateFlow<CurrentWeatherUiState>(CurrentWeatherUiState.Loading)
    val currentWeatherFlow: StateFlow<CurrentWeatherUiState> = _currentWeatherFlow.asStateFlow()

    private val _weatherForecastFlow =
        MutableStateFlow<WeatherForecastUiState>(WeatherForecastUiState.Loading)
    val weatherForecastFlow: StateFlow<WeatherForecastUiState> = _weatherForecastFlow.asStateFlow()

    private val _weatherUpdateFlow =
        MutableStateFlow<WeatherUpdateUiState>(WeatherUpdateUiState.Loading)
    val weatherUpdateFlow: StateFlow<WeatherUpdateUiState> = _weatherUpdateFlow.asStateFlow()


    val visiblePermissionDialogQueue = mutableStateListOf<String>()


    fun dismissDialog() {
        visiblePermissionDialogQueue.removeLast()
    }

    fun onPermissionResult(
        permission: String,
        isGranted: Boolean
    ) {
        if (!isGranted) {
            visiblePermissionDialogQueue.add(permission)
        }
    }

    fun getCurrentWeather() {
        viewModelScope.launch {
            locationTracker.getCurrentLocation()?.let { location ->
                println("Latitude: ${location.latitude} \nLongitude: ${location.longitude}")
                weatherRepository.getWeatherUpdate(location.latitude, location.longitude)
                    .resourceFlow()
                    .collect { result ->
                        _currentWeatherFlow.update {
                            when (result) {
                                is Resource.Loading -> CurrentWeatherUiState.Loading
                                is Resource.Success -> CurrentWeatherUiState.CurrentWeather(result.data?.data)
                                is Resource.Error -> CurrentWeatherUiState.Error(result.message)
                            }
                        }
                    }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getFiveDayForecast() {
        viewModelScope.launch {
            locationTracker.getCurrentLocation()?.let { location ->
                println("Latitude: ${location.latitude} \nLongitude: ${location.longitude}")
                weatherRepository.getFiveDayForecast(location.latitude, location.longitude)
                    .resourceFlow()
                    .collect { result ->
                        _weatherForecastFlow.update {
                            when (result) {
                                is Resource.Loading -> WeatherForecastUiState.Loading
                                is Resource.Success -> WeatherForecastUiState.WeatherForecast(
                                    result.data?.data?.list?.map { weatherItem ->
                                        FiveDayWeatherForecast(
                                            dayOfWeek = LocalDate.parse(weatherItem.dtTxt.split(" ")[0]).dayOfWeek.toString(),
                                            weatherMain = weatherItem.weather[0].main,
                                            weatherItem.main.temp_max.toString()
                                        )
                                    }?.toSet()?.take(5)
                                )

                                is Resource.Error -> WeatherForecastUiState.Error(result.message)
                            }
                        }
                    }
            }
        }
    }
}

sealed interface CurrentWeatherUiState {
    data class CurrentWeather(val currentWeather: dev.prodeva.weatherapplication.domain.model.CurrentWeather?) :
        CurrentWeatherUiState

    data class Error(val errorMessage: String?) : CurrentWeatherUiState
    data object Loading : CurrentWeatherUiState
}

sealed interface WeatherForecastUiState {
    data class WeatherForecast(val weatherForecast: List<FiveDayWeatherForecast>?) :
        WeatherForecastUiState

    data class Error(val errorMessage: String?) : WeatherForecastUiState
    data object Loading : WeatherForecastUiState
}

sealed interface WeatherUpdateUiState {
    data class WeatherUpdate(
        val weatherForecast: List<FiveDayWeatherForecast>?
    ) : WeatherUpdateUiState

    data class Error(val errorMessage: String?) : WeatherUpdateUiState
    data object Loading : WeatherUpdateUiState
}