package com.onurkaragunlu.feature_movie_impl.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.onurkaragunlu.feature_movie_api.navigation.MovieNavigation
import com.onurkaragunlu.feature_movie_impl.screen.MovieListScreen


fun NavGraphBuilder.addMovieGraph(navController: NavController) {
    //navigation(route = "movie", startDestination = MovieNavigation.MovieList.route) {
        composable(route = MovieNavigation.MovieList.route) {
            MovieListScreen()
        }
    //}
}