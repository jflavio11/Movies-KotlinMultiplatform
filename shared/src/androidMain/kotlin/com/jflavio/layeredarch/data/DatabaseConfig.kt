package com.jflavio.layeredarch.domain

import android.content.Context
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase

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

@Dao
interface MovieDao {
    @Query("SELECT * FROM MovieEntity")
    fun getAllMovies(): List<MovieEntity>

    @Insert
    fun insertAll(vararg movies: List<MovieEntity>)
}

@Entity
class MovieEntity(
    @PrimaryKey val localId: Int = -1,
    @ColumnInfo(name = "id", index = true) val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "durationInMinutes") val durationInMinutes: Int,
    @ColumnInfo(name = "posterUrl") val posterUrl: String
)

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