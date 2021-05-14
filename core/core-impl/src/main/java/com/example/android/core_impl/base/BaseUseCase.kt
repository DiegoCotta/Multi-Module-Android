package com.example.android.core_impl.base

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.channels.sendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
abstract class BaseUseCase<Type : Any, Params : Any?> : UseCase<Type> {
    private val channel = ConflatedBroadcastChannel<Params>()

    operator fun invoke(params: Params) = channel.sendBlocking(params)

    protected abstract fun doWork(params: Params): Flow<Type?>

    fun produce(params: Params): Flow<Type?> = doWork(params = params)
        .flowOn(dispatcher)

    override fun observe(): Flow<Type?> = channel.asFlow()
        .distinctUntilChanged()
        .flatMapLatest { doWork(it) }
        .flowOn(dispatcher)

    object None
}
