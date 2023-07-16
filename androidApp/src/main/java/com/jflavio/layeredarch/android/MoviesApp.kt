package com.jflavio.layeredarch.android

import android.app.Application
import com.jflavio.layeredarch.AppInjector

/**
 * MoviesApp
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  25/12/2021
 */
class MoviesApp : Application() {

    lateinit var appInjector: AppInjector

    override fun onCreate() {
        super.onCreate()
        this.appInjector = AppInjector(this)
    }
}