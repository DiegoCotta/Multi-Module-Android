package com.example.android.core_impl.functional

import java.lang.Exception
import kotlin.reflect.KFunction1


sealed class ResultData<out R> {
    data class Success<out R>(val value: R) : ResultData<R>()
    data class Failure(val throwable: Throwable?) : ResultData<Nothing>()
}

/**
 * Check whether ResultData is successful or failed
 * @return true if ResultData.Success
 */
inline val <R> ResultData<R>.isSuccessful: Boolean
    get() = this is ResultData.Success

/**
 * Check whether ResultData is successful or failed
 * @return true if ResultData.Failure
 */
inline val <R> ResultData<R>.isFailure: Boolean
    get() = this is ResultData.Failure

/**
 * @return the value or null if it is a ResultData.Failure
 */
inline val <R> ResultData<R>.valueOrNull: R?
    get() = if (this is ResultData.Success) value else null

/**
 * @return throwable value or null of the ResultData<R>
 */
inline val <R> ResultData<R>.throwableOrNull: Throwable?
    get() = if (this is ResultData.Failure) throwable else null

/**
 * The block() will be called when it is a success
 */
inline fun <R> ResultData<R>.onSuccess(block: (R) -> Unit) {
    if (this is ResultData.Success) {
        block(value)
    }
}

/**
 * The block() will be called when it is a failure
 */
inline fun <R> ResultData<R>.onFailure(block: (Throwable?) -> Unit) {
    if (this is ResultData.Failure) {
        block(throwable)
    }
}

/**
 * Map successful value into something else.
 * @return a new transformed ResultData.
 */
inline fun <T, R> ResultData<T>.map(transform: (T) -> R): ResultData<R> {
    return when (this) {
        is ResultData.Failure -> this
        is ResultData.Success -> ResultData.Success(transform(value))
    }
}

/**
 * Map ResultData successful value into something else.
 * @return a new transformed ResultData.
 */
inline fun <T, R> ResultData<T>.flatMap(transform: (T) -> ResultData<R>): ResultData<R> {
    return when (this) {
        is ResultData.Failure -> this
        is ResultData.Success -> transform(value)
    }
}

/**
 * Map an throwable into another throwable
 * @return a new transform ResultData
 */
inline fun <T, R : Throwable> ResultData<T>.failureMap(transform: (Throwable?) -> R): ResultData<T> {
    return when (this) {
        is ResultData.Failure -> ResultData.Failure(transform(throwable))
        is ResultData.Success -> this
    }
}

/**
 * Map ResultData failure's throwable into another throwable
 * @return a new transform ResultData
 */
inline fun <T> ResultData<T>.failureFlatMap(transform: (Throwable?) -> ResultData.Failure): ResultData<T> {
    return when (this) {
        is ResultData.Failure -> transform(throwable)
        is ResultData.Success -> this
    }
}

/**
 * Get value or default value when failed.
 * @return value or default value.
 * @param defaultValue a default to be return when failed.
 */
inline fun <R> ResultData<R>.valueOrDefault(defaultValue: (Throwable?) -> R): R {
    return when (this) {
        is ResultData.Failure -> defaultValue(throwable)
        is ResultData.Success -> value
    }
}

/**
 * @return an instance of ResultData
 */
inline fun <R> ResultData(block: () -> R): ResultData<R> {
    return try {
        ResultData.Success(block())
    } catch (throwable: Throwable) {
        ResultData.Failure(throwable)
    }
}

/**
 * Create a ResultData<T> from a standard Result<T>.
 * @return ResultData<T>
 */
fun <T> Result<T>.asResultData(): ResultData<T> = ResultData { getOrThrow() }