package com.onurkaragunlu.feature.favoritelist.api.navigation

sealed class FavoriteListNavigation(val route: String) {
    object FavoriteList : FavoriteListNavigation("favorite/favoriteList")
}
