package com.jflavio.layeredarch.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jflavio.layeredarch.data.entity.MovieEntity

/**
 * MovieDao
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  25/12/2021
 */
@Dao
interface MovieDao {
    @Query("SELECT * FROM MovieEntity")
    fun getAllMovies(): List<MovieEntity>

    @Insert
    fun insertAll(movies: List<MovieEntity>)
}