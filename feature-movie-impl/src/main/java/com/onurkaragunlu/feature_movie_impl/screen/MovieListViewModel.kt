package com.onurkaragunlu.feature_movie_impl.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.onurkaragunlu.domain_movie.model.Movie
import com.onurkaragunlu.domain_movie.repository.MovieRepository
import com.onurkaragunlu.domain_movie.usecase.MoviePagingUseCase
import com.onurkaragunlu.feature_movie_impl.mapper.MovieUIMapper
import com.onurkaragunlu.feature_movie_impl.model.MovieUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Onur Karagünlü on 7.06.2022.
 */
@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val moviePagingUseCase: MoviePagingUseCase,
    private val movieUIMapper: MovieUIMapper
) : ViewModel() {


    val pagingFlow = moviePagingUseCase(Unit).map { value: PagingData<Movie> ->
        value.map {
            movieUIMapper.mapToUIModel(it)
        }
    }.cachedIn(viewModelScope)


}