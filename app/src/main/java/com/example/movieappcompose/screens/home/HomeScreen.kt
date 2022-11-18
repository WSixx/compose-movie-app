package com.example.movieappcompose.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappcompose.model.Movie
import com.example.movieappcompose.model.getMovies
import com.example.movieappcompose.navigation.MovieScreens
import com.example.movieappcompose.widgets.MovieRow

/**
 *
 *
 *
 * created on 18/11/2022
 * @author Lucas Goncalves
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.LightGray, elevation = 5.dp) {
                Text(text = "Movies")
            }
        },
    ) {
        MainContent(navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(it){ movieTitle ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movieTitle")
                }
            }
        }
    }
}

