package com.jflavio.layeredarch.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appInjector: AppInjector = (application as MoviesApp).appInjector
            val viewModel = viewModels<MainViewModel> {
                MainViewModelFactory(appInjector.getMoviesInteractor)
            }.value
            MainScreen(appInjector, viewModel)
        }
    }
}

@Composable
fun MainScreen(appInjector: AppInjector, mainViewModel: MainViewModel) {
    LazyColumn {
        items(mainViewModel._uiState.value.movies) { movie ->
            Text(text = movie.name)
        }
    }
    mainViewModel.getMovies()
}
