package com.jflavio.layeredarch.domain

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jflavio.layeredarch.data.entity.MovieEntity
import com.jflavio.layeredarch.data.local.dao.MovieDao

/**
 * DatabaseConfig
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  24/12/2021
 */
@Database(
    entities = [MovieEntity::class],
    version = 1
)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}

object DatabaseInjector {

    private var db: MoviesDatabase? = null

    fun getDb(context: Context): MoviesDatabase {
        if (db == null) {
            db = Room.databaseBuilder(
                context,
                MoviesDatabase::class.java, "movies-database"
            ).build()
        }
        return db!!
    }

}