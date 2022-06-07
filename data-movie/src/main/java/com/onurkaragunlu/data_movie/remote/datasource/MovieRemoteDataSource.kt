package com.onurkaragunlu.data_movie.remote.datasource

import com.onurkaragunlu.core_model.network.Resource
import com.onurkaragunlu.data_movie.model.MovieResponseDTO

/**
 * Created by Onur Karagünlü on 5.06.2022.
 */
interface MovieRemoteDataSource {
    suspend fun getMovieList(page: Int): Resource<MovieResponseDTO>
}