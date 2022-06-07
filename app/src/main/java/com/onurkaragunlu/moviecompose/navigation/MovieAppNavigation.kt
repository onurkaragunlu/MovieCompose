package com.onurkaragunlu.moviecompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.onurkaragunlu.feature.favoritelist.impl.navigation.addFavoriteGraph
import com.onurkaragunlu.feature_movie_api.navigation.MovieNavigation
import com.onurkaragunlu.feature_movie_impl.navigation.addMovieGraph


@Composable
fun MovieAppNavigation( navController: NavHostController) {
    NavHost(navController = navController, startDestination = MovieNavigation.MovieList.route) {
        addMovieGraph(navController)
        addFavoriteGraph(navController)
    }
}