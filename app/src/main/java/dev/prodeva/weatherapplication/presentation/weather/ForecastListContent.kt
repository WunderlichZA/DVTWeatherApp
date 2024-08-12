import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import dev.prodeva.weatherapplication.data.models.FiveDayWeatherForecast
import dev.prodeva.weatherapplication.presentation.weather.WeatherListItem

@Composable
fun ForecastListContent(
    forecastList: List<FiveDayWeatherForecast>?,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.fillMaxHeight()
    ) {
        val scrollableState = rememberLazyListState()
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .testTag("Forecast:daysoftheweek"),
            contentPadding = PaddingValues(vertical = 16.dp),
            state = scrollableState,
        ) {
            forecastList?.forEach { weather ->
                item {
                    WeatherListItem(weather = weather)
                }
            }
        }
    }
}