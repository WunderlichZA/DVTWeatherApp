package dev.prodeva.weatherapplication.presentation.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.prodeva.weatherapplication.R
import dev.prodeva.weatherapplication.data.models.FiveDayWeatherForecast

@Composable
fun WeatherListItem(
    modifier: Modifier = Modifier,
    weather : FiveDayWeatherForecast
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = modifier
                .fillMaxWidth()
                .height(145.dp)
        ) {
            Text(
                text = weather.dayOfWeek,
                modifier = modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            )

            Row(
                modifier = modifier.fillMaxWidth().padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = displayWeatherIcon(weather.weatherMain)),
                    contentDescription = "Weather Icon",
                    modifier = modifier
                        .padding(start = 12.dp)
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = weather.weatherTemperature + 0x00B0.toChar(),
                    style = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.Bold)
                )
            }
        }
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