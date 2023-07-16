package com.jflavio.layeredarch.data

import App
import androidx.compose.ui.window.ComposeUIViewController
import com.jflavio.layeredarch.AppInjector

/**
 * App
 *
 * @since 07/16/2023
 */
fun MainViewController() = ComposeUIViewController { App(AppInjector()) }