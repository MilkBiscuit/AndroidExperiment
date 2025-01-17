package com.cheng.experimentapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cheng.experimentapp.ui.theme.ExperimentAppTheme
import com.cheng.experimentapp.usecase.CallJavaScriptUC

@Composable
fun InputModeDemoScreen() {
    Scaffold(
        topBar = {
            TopAppBar {
                Text("windowSoftInputMode demo")
            }
        }
    ) { padding ->
        ButtonDemoView(modifier = Modifier.padding(padding))
    }
}

@Composable
private fun InputModeDemoView(
    modifier: Modifier = Modifier,
) {
    Box(modifier.fillMaxSize()) {
        Column(
            modifier.align(Alignment.Center),
        ) {
            Text("Hello world")
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = "no need to input anything",
                onValueChange = {},
            )
        }
    }
}

@Composable
private fun ButtonDemoView(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Box(modifier.fillMaxSize()) {
        Column(
            modifier.align(Alignment.Center),
        ) {
            Text("Hello world")
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    CallJavaScriptUC.callFunction(context, "js/test.js", "helloFromJS")
                },
            ) {
                Text("Click me invoke JS code")
            }
        }
    }
}


////////////////////////////////////// Preview //////////////////////////////////////

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ExperimentAppTheme {
        InputModeDemoView()
    }
}
