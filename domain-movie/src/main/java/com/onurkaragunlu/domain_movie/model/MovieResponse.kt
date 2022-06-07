package com.onurkaragunlu.domain_movie.model

import com.onurkaragunlu.base_domain.model.DomainModel

/**
 * Created by Onur Karagünlü on 4.06.2022.
 */
data class MovieResponse(
    val page: Int,
    val movieList: List<Movie>,
    val total_pages: Int,
    val total_results: Int
) : DomainModel