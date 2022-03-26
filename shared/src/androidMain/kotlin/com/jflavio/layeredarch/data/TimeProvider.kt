package com.jflavio.layeredarch.data

/**
 * TimeProvider
 *
 * @since 26/03/2022
 */
actual class TimeProvider {
    actual var timestamp: Long = System.currentTimeMillis()
}