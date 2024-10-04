package dev.prodeva.weatherapplication.presentation.weather


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import dev.prodeva.weatherapplication.data.models.WeatherForecast


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherForecastScreen(
    fiveDayForecastList: List<WeatherForecast>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painterResource(id = fiveDayForecastList[0].weatherIcon.backgroundImage),
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
        HorizontalDivider(
            thickness = 2.dp,
            modifier = Modifier.padding(top = 16.dp),
            color = Color.Red
        )

        ForecastListContent(
            forecastList = fiveDayForecastList
        )
    }
}