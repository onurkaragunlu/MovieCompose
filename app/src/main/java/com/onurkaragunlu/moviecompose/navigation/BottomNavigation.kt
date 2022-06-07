package com.onurkaragunlu.moviecompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Place
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.onurkaragunlu.feature.favoritelist.api.navigation.FavoriteListNavigation
import com.onurkaragunlu.feature_movie_api.navigation.MovieNavigation
import com.onurkaragunlu.moviecompose.R


class MovieTopLevelNavigation(private val navController: NavHostController) {

    fun navigateTo(destination: BottomNavItem) {
        navController.navigate(destination.route) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
}

class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val iconTextId: Int
)

val TOP_LEVEL_DESTINATIONS = listOf(
    BottomNavItem(
        route = MovieNavigation.MovieList.route,
        icon = Icons.Filled.Home,
        iconTextId = R.string.bottom_movie
    ),
    BottomNavItem(
        route = FavoriteListNavigation.FavoriteList.route,
        icon = Icons.Filled.Favorite,
        iconTextId = R.string.bottom_favorite
    )
)