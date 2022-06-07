package com.onurkaragunlu.feature_movie_api.navigation

sealed class MovieNavigation(val route: String) {
    object MovieList : MovieNavigation("movie/movieList")
}
