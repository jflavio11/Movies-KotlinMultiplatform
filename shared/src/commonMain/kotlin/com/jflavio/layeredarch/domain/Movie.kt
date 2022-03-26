package com.jflavio.layeredarch.domain

/**
 * Movie
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  24/12/2021
 */
data class Movie(
    val id: String,
    val name: String,
    val overview: String,
    val posterUrl: String
)
