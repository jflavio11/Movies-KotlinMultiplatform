package com.jflavio.layeredarch

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * DispatcherProvider
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  25/12/2021
 */
interface DispatcherProvider {
    val io: CoroutineContext
    val ui: CoroutineContext
}

class DispatcherProviderImpl : DispatcherProvider {
    override val io: CoroutineContext = Dispatchers.Default
    override val ui: CoroutineContext = Dispatchers.Main
}