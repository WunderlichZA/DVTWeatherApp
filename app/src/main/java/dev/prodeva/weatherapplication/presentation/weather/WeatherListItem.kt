package dev.prodeva.weatherapplication.presentation.weather

import android.os.Build
import androidx.annotation.RequiresApi
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
import dev.prodeva.weatherapplication.data.models.WeatherForecast

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherListItem(
    modifier: Modifier = Modifier,
    weather : WeatherForecast
){
    println("WeatherListItem: ${weather.weatherDate.toLocalDate()} ")
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(145.dp)
            .padding(top = 12.dp)
    ) {
        Text(
            text = weather.weatherDate.dayOfWeek.name,
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
                painter = painterResource(id = weather.weatherIcon.iconRes),
                contentDescription = "Weather Icon",
                modifier = modifier
                    .padding(start = 12.dp)
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Text(
                text = weather.weatherTemperature.toString() + 0x00B0.toChar(),
                style = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.Bold)
            )
        }
    }
}