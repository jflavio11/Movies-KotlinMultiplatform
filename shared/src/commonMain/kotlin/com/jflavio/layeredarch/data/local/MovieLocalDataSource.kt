package com.jflavio.layeredarch.data.local

import com.jflavio.layeredarch.MoviesDb
import com.jflavio.layeredarch.domain.Movie

/**
 * MovieLocalDataSource
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  13/03/2022
 */
class MovieLocalDataSource(private val moviesDb: MoviesDb) {

    suspend fun saveMovies(list: List<Movie>) {

    }

    suspend fun getMovies(): List<Movie> {
        return moviesDb.movieTableQueries.selectAll().executeAsList().map {
            Movie(
                id = it.id.toString(),
                name = it.name,
                durationInMinutes = it.duration_in_minutes.toInt(),
                posterUrl = it.poster_url
            )
        }
    }
}