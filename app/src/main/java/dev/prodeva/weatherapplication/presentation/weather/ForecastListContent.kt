package dev.prodeva.weatherapplication.presentation.weather

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import dev.prodeva.weatherapplication.data.models.WeatherForecast

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ForecastListContent(
    forecastList: List<WeatherForecast>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .testTag("Forecast:daysOfTheWeek"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        println(
            "ForecastListContent: ${
                forecastList[0].weatherDate
            }"
        )
        items(
            items = forecastList,
            key = {
                it.weatherDate
            }
        ) { weather ->
            WeatherListItem(weather = weather)
        }
    }
}