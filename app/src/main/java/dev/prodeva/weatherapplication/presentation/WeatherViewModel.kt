package dev.prodeva.weatherapplication.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.prodeva.weatherapplication.core.Resource
import dev.prodeva.weatherapplication.core.resourceFlow
import dev.prodeva.weatherapplication.domain.location.LocationTracker
import dev.prodeva.weatherapplication.domain.usecases.GetWeatherForecastUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherForecastUseCase: GetWeatherForecastUseCase,
    private val locationTracker: LocationTracker
) : ViewModel() {

    private val _weatherForecastFlow =
        MutableStateFlow<WeatherForecastUiState>(WeatherForecastUiState.Loading)
    val weatherForecastFlow: StateFlow<WeatherForecastUiState> = _weatherForecastFlow.asStateFlow()


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

    @RequiresApi(Build.VERSION_CODES.O)
    fun getFiveDayForecast() {
        viewModelScope.launch {
            locationTracker.getCurrentLocation()?.let { location ->
                println("Latitude: ${location.latitude} \nLongitude: ${location.longitude}")
                getWeatherForecastUseCase(location.latitude, location.longitude)
                    .resourceFlow()
                    .collect { result ->
                        _weatherForecastFlow.update {
                            when (result) {
                                is Resource.Loading -> {
                                    println("getFiveDayForecast(): Loading")
                                    WeatherForecastUiState.Loading
                                }

                                is Resource.Success -> {
                                    println("ViewModel: getFiveDayForecast(): Success -> ${result.data?.data?.size}")
                                    WeatherForecastUiState.WeatherForecast(
                                        result.data?.data
                                    )

                                }

                                is Resource.Error -> WeatherForecastUiState.Error(result.message)
                            }
                        }
                    }
            }
        }
    }

}

sealed interface WeatherForecastUiState {
    data class WeatherForecast(val weatherForecast: List<dev.prodeva.weatherapplication.data.models.WeatherForecast>?) :
        WeatherForecastUiState

    data class Error(val errorMessage: String?) : WeatherForecastUiState
    data object Loading : WeatherForecastUiState
}