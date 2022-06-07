package com.onurkaragunlu.core_model.network

/**
 * Created by Onur Karagünlü on 4.06.2022.
 */
sealed class Resource<out T> {
    data class Success<out T>(val value: T) : Resource<T>()
    data class Failure(val error: MovieError) : Resource<Nothing>()
}