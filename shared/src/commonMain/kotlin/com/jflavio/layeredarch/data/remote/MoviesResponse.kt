package com.jflavio.layeredarch.data.remote

import kotlinx.serialization.*

/**
 * MoviesResponse
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  15/03/2022
 */
@Serializable
data class MoviesListResponse(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: List<MovieEntityResponse>
)

@Serializable
data class MovieEntityResponse(
    val id: Int,
    val title: String,
    val poster_path: String,
    val overview: String
)