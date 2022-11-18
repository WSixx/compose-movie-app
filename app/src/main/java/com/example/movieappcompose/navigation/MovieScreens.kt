package com.example.movieappcompose.navigation

/**
 *
 *
 *
 * created on 18/11/2022
 * @author Lucas Goncalves
 */
enum class MovieScreens {
    HomeScreen,
    DetailsScreen;
    companion object{
        fun fromRoute(route: String?): MovieScreens
        = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw java.lang.IllegalArgumentException("Route $route not found")
        }
    }
}