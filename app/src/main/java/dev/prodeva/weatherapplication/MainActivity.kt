package dev.prodeva.weatherapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import dev.prodeva.weatherapplication.presentation.weather.WeatherForecastScreen
import dev.prodeva.weatherapplication.presentation.CoarseLocationPermissionTextProvider
import dev.prodeva.weatherapplication.presentation.FineLocationPermissionTextProvider
import dev.prodeva.weatherapplication.presentation.LoadingIndicator
import dev.prodeva.weatherapplication.presentation.PermissionDialog
import dev.prodeva.weatherapplication.presentation.WeatherForecastUiState
import dev.prodeva.weatherapplication.presentation.WeatherViewModel
import dev.prodeva.weatherapplication.ui.theme.WeatherApplicationTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val permissionsToRequest = arrayOf(
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_COARSE_LOCATION,
    )

    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    private val weatherViewModel: WeatherViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            weatherViewModel.getFiveDayForecast()
        }

        permissionLauncher.launch(
            arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
            )
        )

        setContent {
            WeatherApplicationTheme {

                val weatherForecastUiState by weatherViewModel.weatherForecastFlow.collectAsStateWithLifecycle()

                val dialogQueue = weatherViewModel.visiblePermissionDialogQueue

                val multiplePermissionResultLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestMultiplePermissions(),
                    onResult = { perms ->
                        permissionsToRequest.forEach { permission ->
                            weatherViewModel.onPermissionResult(
                                permission = permission,
                                isGranted = perms[permission] == true
                            )
                        }
                    }
                )

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when (weatherForecastUiState) {
                        WeatherForecastUiState.Loading -> LoadingIndicator()
                        is WeatherForecastUiState.WeatherForecast -> {
                            (weatherForecastUiState as WeatherForecastUiState.WeatherForecast).weatherForecast?.let { weatherList ->
                                WeatherForecastScreen(
                                    fiveDayForecastList = weatherList,
                                    modifier = Modifier.padding(innerPadding),
                                )
                            }
                        }

                        is WeatherForecastUiState.Error -> {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "${(weatherForecastUiState as WeatherForecastUiState.Error).errorMessage}")
                            }
                        }

                    }
                }

                dialogQueue
                    .reversed()
                    .forEach { permission ->
                        PermissionDialog(
                            permissionTextProvider = when (permission) {
                                android.Manifest.permission.ACCESS_FINE_LOCATION -> {
                                    FineLocationPermissionTextProvider()
                                }

                                android.Manifest.permission.ACCESS_COARSE_LOCATION -> {
                                    CoarseLocationPermissionTextProvider()
                                }

                                else -> return@forEach
                            },
                            isPermanentlyDeclined = !shouldShowRequestPermissionRationale(
                                permission
                            ),
                            onDismiss = weatherViewModel::dismissDialog,
                            onOkClick = {
                                weatherViewModel.dismissDialog()
                                multiplePermissionResultLauncher.launch(
                                    arrayOf(permission)
                                )
                            },
                            onGoToAppSettingsClick = ::openAppSettings
                        )
                    }
            }
        }
    }
}

fun Activity.openAppSettings() {
    Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", packageName, null)
    ).also(::startActivity)
}