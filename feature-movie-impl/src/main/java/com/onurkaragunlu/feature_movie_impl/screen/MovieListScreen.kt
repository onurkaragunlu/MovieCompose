package com.onurkaragunlu.feature_movie_impl.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MovieListScreen( viewModel: MovieListViewModel = hiltViewModel()) {
    Column {
        Text("Movie List")
    }
}