package com.cheng.experimentapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cheng.experimentapp.ui.AnimatedVectorDrawableDemoScreen
import com.cheng.experimentapp.ui.theme.ExperimentAppTheme

class JetpackComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExperimentAppTheme {
                // A surface container using the 'background' color from the theme
                AnimatedVectorDrawableDemoScreen()
            }
        }
    }
}
