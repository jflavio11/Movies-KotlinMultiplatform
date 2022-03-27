package com.jflavio.layeredarch.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jflavio.layeredarch.domain.Movie
import com.skydoves.landscapist.coil.CoilImage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appInjector: AppInjector = (application as MoviesApp).appInjector
            val viewModel = viewModels<MainViewModel> {
                MainViewModelFactory(appInjector.getMoviesInteractor)
            }.value
            MainScreen(viewModel)
        }
    }
}

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    LaunchedEffect(key1 = Unit) {
        mainViewModel.getMovies()
    }
    Box(modifier = Modifier.fillMaxSize().background(Color.LightGray)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
            Text(
                text = "The Movies",
                style = MaterialTheme.typography.h4
            )
            LazyColumn(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            ) {
                items(mainViewModel._uiState.value.movies) { movie ->
                    MovieItem(movie = movie)
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
        Spacer(
            Modifier
                .fillMaxWidth()
                .height(32.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.LightGray
                        )
                    )
                )
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun MovieItem(movie: Movie) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.heightIn(max = 150.dp)) {
        MoviePic(picUrl = movie.posterUrl)
        Spacer(modifier = Modifier.width(12.dp))
        Column(verticalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxHeight()) {
            Text(text = movie.name, style = MaterialTheme.typography.h6)
            Text(
                text = movie.overview,
                style = MaterialTheme.typography.caption,
                overflow = TextOverflow.Ellipsis,
                maxLines = 7
            )
        }
    }
}

@Composable
fun MoviePic(modifier: Modifier = Modifier, picUrl: String) {
    CoilImage(
        imageModel = picUrl,
        modifier = modifier
            .height(200.dp)
            .width(150.dp)
            .clip(RoundedCornerShape(8.dp)),
        // shows a progress indicator when loading an image.
        loading = {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        },

        // shows an error text message when request failed.
        failure = {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .width(150.dp), imageVector = Icons.Default.Face, contentDescription = "MoviePicture"
            )
        })
}

@Preview(name = "Movie Item", showBackground = true)
@Composable
fun MovieItemPreview() {
    MovieItem(
        movie = Movie(
            id = "123",
            name = "Harry Potter",
            overview = "Adaptation of the first of J.K. Rowling's popular children's novels about Harry Potter, a boy who learns on his eleventh birthday that he is the orphaned son of two powerful wizards and possesses unique magical powers of his own. This is a sample of a large text to test if the ellipsis is being shown correctly. You know what I mean, lol. It seems that is not working.",
            posterUrl = "https://cdn.europosters.eu/image/1300/posters/harry-potter-deathly-hallows-i104624.jpg"
        )
    )
}
