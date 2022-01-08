package com.jflavio.layeredarch.android

import android.content.Context
import com.jflavio.layeredarch.DispatcherProvider
import com.jflavio.layeredarch.DispatcherProviderImpl
import com.jflavio.layeredarch.data.MovieRepositoryImpl
import com.jflavio.layeredarch.data.local.MovieLocalDataSource
import com.jflavio.layeredarch.data.remote.MovieRemoteDataSource
import com.jflavio.layeredarch.data.local.DatabaseInjector
import com.jflavio.layeredarch.domain.GetMoviesInteractor
import com.jflavio.layeredarch.domain.GetMoviesInteractorImpl
import com.jflavio.layeredarch.domain.MovieRepository
import com.jflavio.layeredarch.data.local.MoviesDatabase

/**
 * AppInjector
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  25/12/2021
 */
interface AppInjector {
    val db: MoviesDatabase
    val getMoviesInteractor: GetMoviesInteractor
    val movieRepository: MovieRepository
    val movieLocalDataSource: MovieLocalDataSource
    val movieRemoteDataSource: MovieRemoteDataSource
    val dispatcherProvider : DispatcherProvider
}

class AppInjectorImpl(private val context: Context) : AppInjector {

    override val db: MoviesDatabase by lazy {
        DatabaseInjector(context).db
    }
    override val getMoviesInteractor: GetMoviesInteractor by lazy {
        GetMoviesInteractorImpl(movieRepository)
    }

    override val movieRepository: MovieRepository by lazy {
        MovieRepositoryImpl(movieLocalDataSource, movieRemoteDataSource, dispatcherProvider)
    }
    override val movieLocalDataSource: MovieLocalDataSource by lazy {
        MovieLocalDataSource(db)
    }

    override val movieRemoteDataSource: MovieRemoteDataSource by lazy {
        MovieRemoteDataSource()
    }
    override val dispatcherProvider: DispatcherProvider by lazy {
        DispatcherProviderImpl()
    }

}