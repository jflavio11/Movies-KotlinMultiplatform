package com.jflavio.layeredarch.domain

/**
 * GetMoviesInteractor
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  24/12/2021
 */
interface GetMoviesInteractor {
    suspend fun execute(): List<Movie>
}

class GetMoviesInteractorImpl(private val repo: MovieRepository) : GetMoviesInteractor {
    override suspend fun execute(): List<Movie> {
        return repo.getMovies()
    }
}