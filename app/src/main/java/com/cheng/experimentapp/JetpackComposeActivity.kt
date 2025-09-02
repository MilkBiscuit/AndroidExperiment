package com.cheng.experimentapp

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.cheng.experimentapp.ui.InputModeDemoScreen
import com.cheng.experimentapp.ui.LocationPickerScreen
import com.cheng.experimentapp.ui.theme.ExperimentAppTheme


class JetpackComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val hasFineLocationPermission = ContextCompat.checkSelfPermission(
            this, android.Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val hasCoarseLocationPermission = ContextCompat.checkSelfPermission(
            this, android.Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (!hasFineLocationPermission && !hasCoarseLocationPermission) {
            ActivityCompat.requestPermissions(
                this, arrayOf<String?>(
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION,
                ),
                100
            )
        }
        setContent {
            ExperimentAppTheme {
                if (hasFineLocationPermission || hasCoarseLocationPermission) {
                    LocationPickerScreen()
                } else {
                    InputModeDemoScreen()
                }
            }
        }
    }
}
