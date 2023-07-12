package com.jflavio.layeredarch.android

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.jflavio.layeredarch.domain.GetMoviesInteractor
import com.jflavio.layeredarch.domain.Movie
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * MainViewModel
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  25/12/2021
 */
class MainViewModel(private val getMoviesInteractor: GetMoviesInteractor) : ViewModel() {

    var uiState by mutableStateOf(MainUiState())
        private set

    fun getMovies() {
        viewModelScope.launch {
            uiState = uiState.copy(loading = true)
            delay(1500)
            uiState = uiState.copy(movies = getMoviesInteractor.execute(), loading = false)
        }
    }

}

data class MainUiState(
    var movies: List<Movie> = emptyList(),
    var loading: Boolean = true,
    val error: String? = null
)

class MainViewModelFactory(private val getMoviesInteractor: GetMoviesInteractor) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getMoviesInteractor) as T
    }
}