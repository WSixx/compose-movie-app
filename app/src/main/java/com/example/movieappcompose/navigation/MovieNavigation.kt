package com.example.movieappcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappcompose.screens.details.DetailsScreen
import com.example.movieappcompose.screens.home.HomeScreen

/**
 *
 *
 *
 * created on 18/11/2022
 * @author Lucas Goncalves
 */

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name) {
        composable(MovieScreens.HomeScreen.name) {
            //here we pass where this should lead us to
            HomeScreen(navController)
        }
        composable(
            MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(
                navArgument(name = "movie") {
                    type = NavType.StringType
                },
            ),
        ) {
            backStackEntry ->
            DetailsScreen(navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}