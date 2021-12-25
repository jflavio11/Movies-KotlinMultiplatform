package com.jflavio.layeredarch.domain

/**
 * MovieLocalDataSource
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  24/12/2021
 */
expect class MovieLocalDataSource {
    suspend fun saveMovies(list: List<Movie>)
    suspend fun getMovies(): List<Movie>
}