package com.geekymusketeers.spendwise_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.geekymusketeers.spendwise_android.navigation.Navigation
import com.geekymusketeers.spendwise_android.ui.theme.SpendWiseandroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpendWiseandroidTheme {
                Navigation()
            }
        }
    }
}
