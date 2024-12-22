package com.geekymusketeers.spendwise_android.presentation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.geekymusketeers.spendwise_android.R

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier
) {

    var animation by remember {
        mutableStateOf(false)
    }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (animation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1000
        ),
        label = ""
    )

    LaunchedEffect(Unit) {
        animation = true

        // Check if the user is new or old and navigate to diff screens
    }

    Surface {
        Column(
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .alpha(alphaAnimation.value)
                    .size(120.dp),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "uncrack_logo"
            )
        }
    }
}