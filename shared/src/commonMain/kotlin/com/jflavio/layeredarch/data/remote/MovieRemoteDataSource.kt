package com.jflavio.layeredarch.data.remote

import com.jflavio.layeredarch.domain.Movie

/**
 * MovieRemoteDataSource
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  24/12/2021
 */
expect class MovieRemoteDataSource {
    suspend fun getMovies(): List<Movie>
}