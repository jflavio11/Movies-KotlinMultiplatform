package com.jflavio.layeredarch

import com.jflavio.layeredarch.data.MovieRepositoryImpl
import com.jflavio.layeredarch.data.TimeProvider
import com.jflavio.layeredarch.data.local.DatabaseDriverFactory
import com.jflavio.layeredarch.data.local.MovieLocalDataSource
import com.jflavio.layeredarch.data.local.createDatabase
import com.jflavio.layeredarch.data.remote.MovieRemoteDataSource
import com.jflavio.layeredarch.domain.GetMoviesInteractor
import com.jflavio.layeredarch.domain.GetMoviesInteractorImpl
import com.jflavio.layeredarch.domain.MovieRepository

/**
 * AppInjector
 *
 * @since 07/16/2023
 */
actual class AppInjector {
    actual val db: MoviesDb by lazy {
        createDatabase(DatabaseDriverFactory())
    }
    actual val getMoviesInteractor: GetMoviesInteractor by lazy {
        GetMoviesInteractorImpl(movieRepository)
    }

    actual val movieRepository: MovieRepository by lazy {
        MovieRepositoryImpl(movieLocalDataSource, movieRemoteDataSource, timeProvider, dispatcherProvider)
    }
    actual val movieLocalDataSource: MovieLocalDataSource by lazy {
        MovieLocalDataSource(db)
    }

    actual val movieRemoteDataSource: MovieRemoteDataSource by lazy {
        MovieRemoteDataSource()
    }
    actual val dispatcherProvider: DispatcherProvider by lazy {
        DispatcherProviderImpl()
    }
    actual val timeProvider: TimeProvider by lazy {
        TimeProvider()
    }

}