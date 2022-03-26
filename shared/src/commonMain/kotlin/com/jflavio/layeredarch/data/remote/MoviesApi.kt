package com.jflavio.layeredarch.data.remote

import com.jflavio.layeredarch.data.PropertiesProvider
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get

/**
 * MoviesApi
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  15/03/2022
 */

class MoviesApi {

    private val httpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getMovies(): MoviesListResponse {
        return httpClient.get(MOVIES_LIST_ENDPOINT)
    }

    companion object {
        private val MOVIES_LIST_ENDPOINT = "https://api.themoviedb.org/3/movie/popular?api_key=${PropertiesProvider().getApiKey()}"

    }
}