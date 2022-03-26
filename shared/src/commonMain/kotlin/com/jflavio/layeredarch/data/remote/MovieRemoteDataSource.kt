package com.jflavio.layeredarch.data.remote

import com.jflavio.layeredarch.domain.Movie

/**
 * MovieRemoteDataSource
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  13/03/2022
 */
class MovieRemoteDataSource(private val api: MoviesApi = MoviesApi()) {

    suspend fun getMovies(): List<Movie> {
        return api.getMovies().results.map {
            Movie(id = it.id.toString(), name = it.title, overview = it.overview, posterUrl = it.poster_path)
        }
    }

}