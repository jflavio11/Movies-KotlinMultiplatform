package com.jflavio.layeredarch.data.remote

import com.jflavio.layeredarch.domain.Movie

/**
 * MovieRemoteDataSource
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  13/03/2022
 */
class MovieRemoteDataSource {

    suspend fun getMovies(): List<Movie> {
        return emptyList()
    }

}