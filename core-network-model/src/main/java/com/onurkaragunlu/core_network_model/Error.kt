package com.onurkaragunlu.core_network_model

import java.io.IOException

/**
 * Created by Onur Karagünlü on 6.06.2022.
 */
sealed class Error : IOException() {
    class ApiError(var code: Int, override var message: String) : Error()
    object UnKnownError : Error()
    class TimeOutException(override var message: String?) : Error()
    object NoConnectivityError : Error()
}