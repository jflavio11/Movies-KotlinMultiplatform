package com.jflavio.layeredarch.android

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.jflavio.layeredarch.domain.GetMoviesInteractor
import com.jflavio.layeredarch.domain.Movie
import kotlinx.coroutines.launch

/**
 * MainViewModel
 *
 * @author Jose Flavio - jflavio90@gmail.com
 * @since  25/12/2021
 */
class MainViewModel(private val getMoviesInteractor: GetMoviesInteractor) : ViewModel() {

    private val uiState: MutableState<MainUiState> = mutableStateOf(MainUiState())
    val _uiState : State<MainUiState> = uiState

    fun getMovies() {
        viewModelScope.launch {
            uiState.value = uiState.value.copy(movies = getMoviesInteractor.execute())
        }
    }

}

data class MainUiState(
    var movies: List<Movie> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)

class MainViewModelFactory(private val getMoviesInteractor: GetMoviesInteractor) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(getMoviesInteractor) as T
    }
}