package com.example.android.core_impl.base

import com.example.android.core_impl.functional.ResultData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class BaseUseCase<out Type, in BaseUseCaseRequest> where Type : Any {

    abstract suspend fun run(params: BaseUseCaseRequest?): ResultData<Type>

    open operator fun invoke(
        scope: CoroutineScope,
        params: BaseUseCaseRequest? = null,
        onResult: (ResultData<Type>) -> Unit = {}
    ) {
        val backgroundJob = scope.async { run(params) }
        scope.launch { onResult(backgroundJob.await()) }
    }
}