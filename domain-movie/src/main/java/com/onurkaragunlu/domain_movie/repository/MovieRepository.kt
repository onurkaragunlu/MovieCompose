package com.onurkaragunlu.domain_movie.repository

import androidx.paging.PagingData
import com.onurkaragunlu.core_model.network.Resource
import com.onurkaragunlu.domain_movie.model.Movie
import com.onurkaragunlu.domain_movie.model.MovieResponse
import kotlinx.coroutines.flow.Flow

/**
 * Created by Onur Karagünlü on 4.06.2022.
 */
interface MovieRepository {
    suspend fun getMovieList(page: Int): Resource<MovieResponse>
    fun getMovieListFlow(): Flow<PagingData<Movie>>
    //suspend fun getMovieDetail(movieId: Int): Resource<MovieDetailResponse>
}