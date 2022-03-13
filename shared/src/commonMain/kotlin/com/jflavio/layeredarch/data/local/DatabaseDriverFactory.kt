package com.jflavio.layeredarch.data.local

import com.jflavio.layeredarch.MoviesDb
import com.squareup.sqldelight.db.SqlDriver

/**
 * DbDriverFactory
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  08/01/2022
 */
expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(databaseDriverFactory: DatabaseDriverFactory): MoviesDb {
    val driver = databaseDriverFactory.createDriver()
    return MoviesDb(driver)
}