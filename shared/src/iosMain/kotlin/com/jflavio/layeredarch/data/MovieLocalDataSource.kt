package com.jflavio.layeredarch.data

import com.jflavio.layeredarch.domain.Movie

/**
 * MovieLocalDataSource
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  24/12/2021
 */
actual class MovieLocalDataSource {
    actual suspend fun saveMovies(list: List<Movie>) {

    }

    actual suspend fun getMovies(): List<Movie> {
        return listOf(
            Movie(id = "123", name = "Spirderman 1", durationInMinutes = 161, posterUrl = ""),
            Movie(id = "433", name = "Spirderman 2", durationInMinutes = 178, posterUrl = ""),
            Movie(id = "930", name = "Avengers", durationInMinutes = 220, posterUrl = "")
        )
    }
}