package com.jflavio.layeredarch.data.remote

import com.jflavio.layeredarch.BuildKonfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


/**
 * MoviesApi
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  15/03/2022
 */

class MoviesApi {

    private val httpClient = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getMovies(): MoviesListResponse {
        return httpClient.get(MOVIES_LIST_ENDPOINT).body()
    }

    companion object {
        private val MOVIES_LIST_ENDPOINT = "https://api.themoviedb.org/3/movie/popular?api_key=${BuildKonfig.MOVIES_DB_API_KEY}"

    }
}