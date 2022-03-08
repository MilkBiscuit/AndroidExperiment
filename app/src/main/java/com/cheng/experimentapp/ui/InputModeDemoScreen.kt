package com.cheng.experimentapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cheng.experimentapp.ui.theme.ExperimentAppTheme

@Composable
fun InputModeDemoScreen() {
    Scaffold(
        topBar = {
            TopAppBar {
                Text("windowSoftInputMode demo")
            }
        }
    ) {
        InputModeDemoView()
    }
}

@Composable
fun InputModeDemoView() {
    Column(
        Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier.weight(1f).fillMaxWidth().background(color = Color.Red)
        )
        Box(
            modifier = Modifier.weight(1f).fillMaxWidth().background(color = Color.Yellow)
        )
        Box(
            modifier = Modifier.weight(1f).fillMaxWidth().background(color = Color.Green)
        )
        TextField(
            value = "no need to input",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}


////////////////////////////////////// Preview //////////////////////////////////////

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExperimentAppTheme {
        InputModeDemoView()
    }
}
