package com.onurkaragunlu.base_domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

/**
 * Created by Onur Karagünlü on 7.06.2022.
 */
abstract class FlowUseCase<in Params, Type> constructor(
    private val dispatcher: CoroutineDispatcher
) {
    abstract suspend fun getExecutable(params: Params): Flow<Type>

    suspend operator fun invoke(params: Params): Flow<Type> {
        return withContext(dispatcher) {
            getExecutable(params)
        }
    }
}