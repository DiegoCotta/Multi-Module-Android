package com.example.android.core_impl.base

import com.example.android.core_impl.functional.ResultData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class BaseUseCase<out Type, in BaseUseCaseRequest> where Type : Any {

    abstract suspend fun run(params: BaseUseCaseRequest): ResultData<Type>

    operator fun invoke(params: BaseUseCaseRequest, onResult: (ResultData<Type>) -> Unit = {}) {
        val job = GlobalScope.async(Dispatchers.IO) { run(params) }
        GlobalScope.launch(Dispatchers.Main) { onResult(job.await()) }
    }

    object None
}