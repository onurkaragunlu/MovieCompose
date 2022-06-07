package com.onurkaragunlu.feature_movie_impl.screen

import androidx.lifecycle.ViewModel
import com.onurkaragunlu.domain_movie.usecase.MoviePagingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Onur Karagünlü on 7.06.2022.
 */
@HiltViewModel
class MovieListViewModel @Inject constructor(private val moviePagingUseCase: MoviePagingUseCase) :
    ViewModel() {
}