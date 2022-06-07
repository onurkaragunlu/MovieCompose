package com.onurkaragunlu.base_data.extension

import com.onurkaragunlu.core_model.network.Resource
import com.onurkaragunlu.core_network_model.NetworkResponse

/**
 * Created by Onur Karagünlü on 6.06.2022.
 */
fun <T> NetworkResponse<T>.getResourceFromResponse(): Resource<T>{
    return when (this) {
        is NetworkResponse.Success -> Resource.Success(body)
        is NetworkResponse.Failure -> Resource.Failure(error.toMovieError())
    }
}
