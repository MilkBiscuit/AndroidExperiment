package com.cheng.experimentapp.ui

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.cheng.experimentapp.R
import kotlinx.coroutines.delay


@Composable
fun AnimatedVectorDrawableDemoScreen() {
    Scaffold(
        topBar = {
            TopAppBar {
                Text("AnimatedVectorDrawable demo")
            }
        }
    ) {
        AnimatedVectorDrawableDemoView()
    }
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun AnimatedVectorDrawableDemoView() {
    /*
    val image = AnimatedImageVector.animatedVectorResource(id = R.drawable.anim_contactless)
    var atEnd by remember { mutableStateOf(false) }
    Image(
        painter = rememberAnimatedVectorPainter(animatedImageVector = image, atEnd = atEnd),
        contentDescription = null,
        modifier = Modifier.wrapContentSize(align = Alignment.Center),
    )
    LaunchedEffect(Unit) {
        while (true) {
            delay(1000L)
            atEnd = !atEnd
        }
    }
    */
}
