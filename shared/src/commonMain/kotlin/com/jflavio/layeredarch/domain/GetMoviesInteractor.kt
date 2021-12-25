package com.jflavio.layeredarch.domain

/**
 * GetMoviesInteractor
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  24/12/2021
 */
class GetMoviesInteractor(private val repo: MovieRepository) {
    suspend fun execute(): List<Movie> {
        return repo.getMovies()
    }
}