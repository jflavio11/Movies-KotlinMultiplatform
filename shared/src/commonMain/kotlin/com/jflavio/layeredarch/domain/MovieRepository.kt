package com.jflavio.layeredarch.domain

/**
 * MovieRepository
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  24/12/2021
 */
interface MovieRepository {

    suspend fun getMovies(): List<Movie>

}