package com.jflavio.layeredarch.data

import com.jflavio.layeredarch.domain.Movie
import com.jflavio.layeredarch.data.local.MovieLocalDataSource
import com.jflavio.layeredarch.data.remote.MovieRemoteDataSource
import com.jflavio.layeredarch.domain.MovieRepository

/**
 * MovieRepositoryImpl
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  24/12/2021
 */
class MovieRepositoryImpl(
    private val localDataSource: MovieLocalDataSource,
    private val remoteDataSource: MovieRemoteDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        var localMovies = localDataSource.getMovies()
        if (localMovies.isEmpty()) {
            localMovies = remoteDataSource.getMovies()
        }
        localDataSource.saveMovies(localMovies)
        return localMovies
    }

}