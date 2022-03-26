package com.jflavio.layeredarch.data

import com.jflavio.layeredarch.BuildConfig

/**
 * PropertiesProvider
 *
 * @since 26/03/2022
 */
actual class PropertiesProvider {
    actual fun getApiKey(): String {
        return BuildConfig.MOVIES_DB_API_KEY
    }
}