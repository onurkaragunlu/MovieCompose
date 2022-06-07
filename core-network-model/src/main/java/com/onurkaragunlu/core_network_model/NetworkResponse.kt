package com.onurkaragunlu.core_network_model

/**
 * Created by Onur Karagünlü on 6.06.2022.
 */
sealed class NetworkResponse<T> {
    data class Success<T>(val body: T) : NetworkResponse<T>()
    data class Failure<T>(val error: Error) : NetworkResponse<T>()
}