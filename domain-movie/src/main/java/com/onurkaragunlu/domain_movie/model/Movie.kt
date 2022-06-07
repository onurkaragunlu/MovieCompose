package com.onurkaragunlu.domain_movie.model

import com.onurkaragunlu.base_domain.model.DomainModel


/**
 * Created by Onur Karagünlü on 4.06.2022.
 */
data class Movie(
    val backdrop_path: String,
    val first_air_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val name: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double?,
    val poster_path: String,
    val vote_average: Double?,
    val vote_count: Int?
) : DomainModel