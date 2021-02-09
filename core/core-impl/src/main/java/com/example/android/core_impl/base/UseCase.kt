package com.example.android.core_impl.base


import com.example.android.core_impl.functional.ResultData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): ResultData<Type>

    operator fun invoke(params: Params, onResult: (ResultData<Type>) -> Unit = {}) {
        val job = GlobalScope.async(Dispatchers.IO) { run(params) }
        GlobalScope.launch(Dispatchers.Main) { onResult(job.await()) }
    }

    object None
}