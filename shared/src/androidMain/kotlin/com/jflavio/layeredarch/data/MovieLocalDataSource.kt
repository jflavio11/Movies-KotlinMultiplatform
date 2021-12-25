package com.jflavio.layeredarch.data

import com.jflavio.layeredarch.domain.Movie
import com.jflavio.layeredarch.domain.MovieDao
import com.jflavio.layeredarch.domain.MovieEntity

/**
 * MovieLocalDataSource
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  24/12/2021
 */
actual class MovieLocalDataSource(
    private val movieDao: MovieDao
) {
    actual suspend fun saveMovies(list: List<Movie>) {
        movieDao.insertAll(
            list.map {
                MovieEntity(
                    id = it.id,
                    name = it.name,
                    durationInMinutes = it.durationInMinutes,
                    posterUrl = it.posterUrl
                )
            }
        )
    }

    actual suspend fun getMovies(): List<Movie> {
        return movieDao.getAllMovies().map {
            Movie(
                id = it.id,
                name = it.name,
                durationInMinutes = it.durationInMinutes,
                posterUrl = it.posterUrl
            )
        }
    }
}