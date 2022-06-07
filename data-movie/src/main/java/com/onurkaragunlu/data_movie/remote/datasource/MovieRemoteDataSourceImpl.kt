package com.onurkaragunlu.data_movie.remote.datasource

import com.onurkaragunlu.base_data.extension.getResourceFromResponse
import com.onurkaragunlu.core_model.network.Resource
import com.onurkaragunlu.data_movie.model.MovieResponseDTO
import com.onurkaragunlu.data_movie.remote.api.MovieApi
import javax.inject.Inject

/**
 * Created by Onur Karagünlü on 5.06.2022.
 */
class MovieRemoteDataSourceImpl @Inject constructor(
    private val movieApi: MovieApi,
) : MovieRemoteDataSource {

    override suspend fun getMovieList(page: Int): Resource<MovieResponseDTO> {
        return  movieApi.getMovieList(page).getResourceFromResponse()
    }
}