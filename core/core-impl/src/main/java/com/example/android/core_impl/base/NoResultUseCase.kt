package com.example.android.core_impl.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class NoResultUseCase<in Params> {

    protected val workDispatcher: CoroutineDispatcher
        get() = Dispatchers.IO

    abstract suspend fun run(params: Params)

    suspend operator fun invoke(params: Params) = withContext(workDispatcher) {
        run(params)
    }
}
