package com.jflavio.layeredarch.data

import platform.Foundation.NSDate
import platform.Foundation.timeIntervalSince1970
import platform.darwin.SYSTEM_CLOCK

/**
 * TimeProvider
 *
 * @since 26/03/2022
 */
actual class TimeProvider {
    actual var timestamp: Long = NSDate().timeIntervalSince1970.toLong()
}