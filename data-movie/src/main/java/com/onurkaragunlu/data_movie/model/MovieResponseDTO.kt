package com.onurkaragunlu.data_movie.model

import com.onurkaragunlu.base_data.extension.mapper.ResponseModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by Onur Karagünlü on 4.06.2022.
 */
@JsonClass(generateAdapter = true)
data class MovieResponseDTO(
    val page: Int = 0,
    @Json(name = "results")
    val movieList: List<MovieDTO>?,
    val total_pages: Int = 1,
    val total_results: Int = 0
) : ResponseModel