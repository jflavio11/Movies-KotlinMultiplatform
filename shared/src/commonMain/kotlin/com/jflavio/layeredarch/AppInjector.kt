package com.jflavio.layeredarch

import com.jflavio.layeredarch.data.TimeProvider
import com.jflavio.layeredarch.data.local.MovieLocalDataSource
import com.jflavio.layeredarch.data.remote.MovieRemoteDataSource
import com.jflavio.layeredarch.domain.GetMoviesInteractor
import com.jflavio.layeredarch.domain.MovieRepository

/**
 * AppInjector
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  25/12/2021
 */
expect class AppInjector {
    val db: MoviesDb
    val getMoviesInteractor: GetMoviesInteractor
    val movieRepository: MovieRepository
    val movieLocalDataSource: MovieLocalDataSource
    val movieRemoteDataSource: MovieRemoteDataSource
    val dispatcherProvider: DispatcherProvider
    val timeProvider: TimeProvider
}