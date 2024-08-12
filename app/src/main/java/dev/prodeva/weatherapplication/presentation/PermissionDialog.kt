@file:OptIn(ExperimentalMaterial3Api::class)

package dev.prodeva.weatherapplication.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun PermissionDialog(
    permissionTextProvider: PermissionTextProvider,
    isPermanentlyDeclined: Boolean,
    onDismiss: () -> Unit,
    onOkClick: () -> Unit,
    onGoToAppSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                if (isPermanentlyDeclined) {
                    onGoToAppSettingsClick()
                } else {
                    onOkClick()
                }
            }) {
                Text(
                    text = if (isPermanentlyDeclined) {
                        "Grant"
                    } else {
                        "Ok"
                    },
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
            }
        },
        title = {
            Text(text = "Permissions Required")
        },
        text = {
            Text(
                text = permissionTextProvider.getDescription(
                    isPermanentlyDeclined = isPermanentlyDeclined
                )
            )
        }
    )
   /* AlertDialog(
        onDismissRequest = onDismiss,
        modifier = modifier,

        content = {
            //DialogContent(isPermanentlyDeclined)
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Permission required",
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = permissionTextProvider.getDescription(
                        isPermanentlyDeclined = isPermanentlyDeclined
                    ),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {
                    if (isPermanentlyDeclined) {
                        onGoToAppSettingsClick()
                    } else {
                        onOkClick()
                    }
                }) {
                    Text(
                        text = if (isPermanentlyDeclined) {
                            "Grant permission"
                        } else {
                            "Ok"
                        },
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        },
    )*/
}


@Composable
fun DialogContent(isPermanentlyDeclined: Boolean) {
    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        Text(text = "Boikanyo", modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Gavin Wuderlich Hersteller", modifier = Modifier.fillMaxWidth())
        Divider()
        Button(onClick = {
        }) {
            Text(
                text = if (isPermanentlyDeclined) {
                    "Grant permission"
                } else {
                    "Ok"
                },
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

interface PermissionTextProvider {
    fun getDescription(isPermanentlyDeclined: Boolean): String
}

class FineLocationPermissionTextProvider : PermissionTextProvider {
    override fun getDescription(isPermanentlyDeclined: Boolean): String {
        return if (isPermanentlyDeclined) {
            "It seems you permanently declined approximate location permission. " +
                    "You can go to the app settings to grant it."
        } else {
            "This app needs access to your location so that your friends " +
                    "are able to find you where you are."
        }
    }
}

class CoarseLocationPermissionTextProvider : PermissionTextProvider {
    override fun getDescription(isPermanentlyDeclined: Boolean): String {
        return if (isPermanentlyDeclined) {
            "It seems you permanently declined exact location permission. " +
                    "You can go to the app settings to grant it."
        } else {
            "This app needs access to your location so that your friends " +
                    "are able to find you where you are."
        }
    }
}