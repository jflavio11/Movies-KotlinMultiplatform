package com.jflavio.layeredarch.android

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Surface
import com.jflavio.layeredarch.MoviesAppTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesAppTheme {
                Surface {
                    App((application as MoviesApp).appInjector)
                }
            }
        }
    }
}