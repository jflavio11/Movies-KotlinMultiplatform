package com.jflavio.layeredarch

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.jflavio.layeredarch.domain.GetMoviesInteractor
import com.jflavio.layeredarch.domain.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * MainViewModel
 *
 * @since 07/16/2023
 */
class MainViewModel(private val getMoviesInteractor: GetMoviesInteractor) {

    var uiState by mutableStateOf(MainUiState())
        private set

    fun getMovies() {
        //viewModelScope.launch {
        val job = Job()
        CoroutineScope(job).launch {
            uiState = uiState.copy(loading = true)
            delay(1500)
            uiState = uiState.copy(movies = getMoviesInteractor.execute(), loading = false)
        }
        //}
    }

}

data class MainUiState(
    var movies: List<Movie> = emptyList(),
    var loading: Boolean = true,
    val error: String? = null
)
