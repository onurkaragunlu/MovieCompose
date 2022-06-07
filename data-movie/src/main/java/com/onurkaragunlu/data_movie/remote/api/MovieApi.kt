package com.onurkaragunlu.data_movie.remote.api

import com.onurkaragunlu.core_network_model.NetworkResponse
import com.onurkaragunlu.data_movie.model.MovieResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Onur Karagünlü on 5.06.2022.
 */
interface MovieApi {
    @GET("movie/popular")
    suspend fun getMovieList(@Query("page") page: Int): NetworkResponse<MovieResponseDTO>
}