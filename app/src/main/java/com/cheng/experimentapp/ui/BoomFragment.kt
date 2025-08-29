package com.cheng.experimentapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment

class BoomFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val composeView = ComposeView(requireContext()).apply {
            setContent {
                var showRed: Boolean by remember { mutableStateOf(true) }
                var showBlack: Boolean by remember { mutableStateOf(false) }
                Column {
                    Box(modifier = Modifier.safeContentPadding())

                    Button(
                        onClick = {
                            showRed = !showRed
                            showBlack = !showBlack
                        },
                    ) {
                        Text("Change visibility")
                    }

                    LazyColumnContent(showRed, showBlack)
                }
            }
        }

        return composeView
    }
}

@Composable
private fun LazyColumnContent(showRed: Boolean, showBlack: Boolean) {
    val numberList = (0 until 100).toList()
    val colorList = listOf(
        Color.Red,
        Color.Green,
        Color.Blue,
        Color.Cyan,
        Color.Gray,
        Color.Black,
        Color.LightGray,
        Color.Magenta,
        Color.Yellow,
    )

    LazyColumn(
        Modifier
            .padding(20.dp)
            .testTag("ERROR_CONTENT"),
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        items(numberList) { i ->
            val colorIndex = i % colorList.size
            val color = colorList[colorIndex]
            val isRed = colorIndex == 0
            val isBlack = colorIndex == 5
            val isVisible = isRed && showRed || isBlack && showBlack || !isRed && !isBlack
            AnimatedVisibility(isVisible) {
                Box(modifier = Modifier.height(100.dp).fillMaxWidth().background(color))
            }
        }
    }
}
