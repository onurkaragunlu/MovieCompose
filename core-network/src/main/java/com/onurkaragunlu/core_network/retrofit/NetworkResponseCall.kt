package com.onurkaragunlu.core_network.retrofit

import com.squareup.moshi.Moshi
import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import com.onurkaragunlu.core_network_model.NetworkResponse
import com.squareup.moshi.JsonClass
import com.onurkaragunlu.core_network_model.Error
/**
 * Created by Onur Karagünlü on 4.06.2022.
 */
class NetworkResponseCall<T : Any>(
    private val delegate: Call<T>,
    private val errorConverter: Converter<ResponseBody, Error>,
    private val moshi: Moshi
) : Call<NetworkResponse<T>> {
    override fun clone(): Call<NetworkResponse<T>> =
        NetworkResponseCall(delegate.clone(), errorConverter, moshi)

    override fun execute(): Response<NetworkResponse<T>> {
        throw  UnsupportedOperationException("NetworkResponseCall doesn't support execute")
    }

    override fun enqueue(callback: Callback<NetworkResponse<T>>) {

        delegate.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()
                if (response.isSuccessful) {
                    if (body != null) {
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(NetworkResponse.Success(body))
                        )
                    } else {
                        notifyCallBackWithError(
                            callback,
                            error = Error.UnKnownError
                        )
                    }
                } else {
                    val errorBody = response.errorBody()
                    if (errorBody != null) {
                        val apiError =
                            moshi.adapter<ApiError>(ApiError::class.java).fromJson(errorBody.charStream().readText())
                        if (apiError?.status_message != null) {
                            callback.onResponse(
                                this@NetworkResponseCall,
                                Response.success(
                                    NetworkResponse.Failure(
                                        Error.ApiError(
                                            response.code(),
                                            apiError.status_message.toString()
                                        )
                                    )
                                )
                            )
                        } else {
                            notifyCallBackWithError(
                                callback,
                                error = Error.UnKnownError
                            )
                        }

                    } else {
                        notifyCallBackWithError(
                            callback,
                            error = Error.UnKnownError
                        )
                    }
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                notifyCallBackWithError(
                    callback,
                    error = getError(t)
                )
            }
        })
    }

    private fun notifyCallBackWithError(callback: Callback<NetworkResponse<T>>, error: Error) {
        callback.onResponse(
            this@NetworkResponseCall,
            Response.success(NetworkResponse.Failure(error))
        )
    }

    private fun getError(t: Throwable): Error {
        return when (t) {
            is IOException -> {
                Error.NoConnectivityError
            }
            is SocketTimeoutException -> {
                Error.TimeOutException(t.localizedMessage)
            }
            else -> {
                Error.UnKnownError
            }
        }
    }

    override fun isExecuted() = delegate.isExecuted

    override fun cancel() = delegate.cancel()

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()
}

@JsonClass(generateAdapter = true)
internal data class ApiError(
    val status_message: String?
)