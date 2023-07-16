package com.jflavio.layeredarch

import android.content.Context
import com.jflavio.layeredarch.data.MovieRepositoryImpl
import com.jflavio.layeredarch.data.TimeProvider
import com.jflavio.layeredarch.data.local.DatabaseDriverFactory
import com.jflavio.layeredarch.data.local.MovieLocalDataSource
import com.jflavio.layeredarch.data.local.createDatabase
import com.jflavio.layeredarch.data.remote.MovieRemoteDataSource
import com.jflavio.layeredarch.domain.GetMoviesInteractor
import com.jflavio.layeredarch.domain.GetMoviesInteractorImpl
import com.jflavio.layeredarch.domain.MovieRepository

actual class AppInjector(private val context: Context) {

    actual val db: MoviesDb by lazy {
        createDatabase(DatabaseDriverFactory(context))
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