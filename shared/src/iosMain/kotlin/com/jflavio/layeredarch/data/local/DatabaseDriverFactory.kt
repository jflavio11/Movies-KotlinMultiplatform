package com.jflavio.layeredarch.data.local

import com.jflavio.layeredarch.MoviesDb
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

/**
 * DatabaseDriverFactory
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  13/03/2022
 */
actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(MoviesDb.Schema, "movies.db")
    }
}