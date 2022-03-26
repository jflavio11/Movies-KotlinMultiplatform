package com.jflavio.layeredarch.data

/**
 * PropertiesProvider
 *
 * @since 26/03/2022
 */
actual class PropertiesProvider {
    actual fun getApiKey(): String {
        throw UnsupportedOperationException()
    }
}