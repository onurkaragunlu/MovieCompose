package com.onurkaragunlu.feature.favoritelist.impl.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.onurkaragunlu.feature.favoritelist.api.navigation.FavoriteListNavigation
import com.onurkaragunlu.feature.favoritelist.impl.screen.FavoriteListScreen

fun NavGraphBuilder.addFavoriteGraph(navController: NavController) {
    navigation(route = "favorite", startDestination = FavoriteListNavigation.FavoriteList.route) {
        composable(route = FavoriteListNavigation.FavoriteList.route) {
            FavoriteListScreen()
        }
    }
}