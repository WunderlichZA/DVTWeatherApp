package dev.prodeva.weatherapplication.presentation

import android.content.Context
import android.content.Intent
import android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.prodeva.weatherapplication.extensions.hasLocationPermission

@Composable
fun RevokedPermissions(modifier: Modifier = Modifier, context: Context) {
    Column(
        modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("We need permissions to use this app")
        Button(
            onClick = {
                context.startActivity(Intent(ACTION_LOCATION_SOURCE_SETTINGS))
            },
            enabled = !context.hasLocationPermission()
        ) {
            if (context.hasLocationPermission()) CircularProgressIndicator(
                modifier.size(14.dp),
                color = Color.White
            )
            else Text("Settings")
        }
    }
}