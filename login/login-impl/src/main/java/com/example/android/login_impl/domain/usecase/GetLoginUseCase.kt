package com.example.android.login_impl.domain.usecase

import com.example.android.core_impl.base.BaseUseCase
import com.example.android.core_impl.base.BaseUseCaseRequest
import com.example.android.core_impl.functional.ResultData
import com.example.android.login_impl.domain.model.User
import java.lang.Exception

class GetLoginUseCase : BaseUseCase<User, BaseUseCaseRequest>() {
    override suspend fun run(params: BaseUseCaseRequest?): ResultData<User> {
        return try {
            ResultData.Success(User("a", 1))
        } catch (e: Exception) {
            ResultData.Failure(e)
        }
    }

}