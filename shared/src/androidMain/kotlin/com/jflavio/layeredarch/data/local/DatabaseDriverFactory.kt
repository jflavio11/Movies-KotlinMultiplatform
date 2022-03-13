package com.jflavio.layeredarch.data.local

import android.content.Context
import com.jflavio.layeredarch.MoviesDb
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

/**
 * DatabaseDriverFactory
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  08/01/2022
 */
actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(MoviesDb.Schema, context, "movies.db")
    }
}