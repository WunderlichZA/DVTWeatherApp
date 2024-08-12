package dev.prodeva.dvtweatherapp.feature_weather.presentation.compose


import ForecastListContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import dev.prodeva.weatherapplication.R
import dev.prodeva.weatherapplication.data.models.FiveDayWeatherForecast


@Composable
fun WeatherForecastScreen(
    //weatherForecastUiState: WeatherForecastUiState,
    modifier: Modifier = Modifier
) {

    var setBackgroundImage by rememberSaveable {
        mutableIntStateOf(R.drawable.weather_icon_sun_light)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background_image_sunny),
                contentScale = ContentScale.FillBounds
            )

    ) {
        Text(
            text = "5 Day Forecast",
            Modifier.padding(top = 24.dp, start = 16.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 28.em,
                color = Color.Black
            )
        )
        HorizontalDivider(thickness = 2.dp, modifier = Modifier.padding(top = 16.dp), color = Color.Red)

        ForecastListContent(
            forecastList = forecast,
            modifier = modifier,
        )

        /*when(weatherForecastUiState){
            WeatherForecastUiState.Loading -> LoadingIndicator()
            is WeatherForecastUiState.WeatherForecast -> {
                //setBackgroundImage = displayWeatherIcon(weatherForecastUiState.weatherForecast?.get(0)!!.weatherMain)
                ForecastListContent(
                    forecastList = weatherForecastUiState.weatherForecast,
                    modifier = modifier,
                )
            }
            is WeatherForecastUiState.Error -> Text(text = "${weatherForecastUiState.errorMessage}")

        }*/
    }
}

private fun displayWeatherIcon(weatherMain : String) : Int{
    return when(weatherMain){
        "Clear" -> R.drawable.weather_icon_sun_light
        "Cloudy" -> R.drawable.weather_icon_mostly_cloudy_light
        "Rain" -> R.drawable.weather_icon_rain_light
        else -> 0
    }
}

val forecast = listOf(
    FiveDayWeatherForecast(
        dayOfWeek = "Monday",
        weatherMain = "Clear",
        weatherTemperature = "16"
    ),
    FiveDayWeatherForecast(
        dayOfWeek = "Monday",
        weatherMain = "Clear",
        weatherTemperature = "16"
    ),
    FiveDayWeatherForecast(
        dayOfWeek = "Monday",
        weatherMain = "Clear",
        weatherTemperature = "16"
    ),
    FiveDayWeatherForecast(
        dayOfWeek = "Monday",
        weatherMain = "Clear",
        weatherTemperature = "16"
    ),
    FiveDayWeatherForecast(
        dayOfWeek = "Monday",
        weatherMain = "Clear",
        weatherTemperature = "16"
    ),
    FiveDayWeatherForecast(
        dayOfWeek = "Monday",
        weatherMain = "Clear",
        weatherTemperature = "16"
    ),
    FiveDayWeatherForecast(
        dayOfWeek = "Monday",
        weatherMain = "Clear",
        weatherTemperature = "16"
    )
)