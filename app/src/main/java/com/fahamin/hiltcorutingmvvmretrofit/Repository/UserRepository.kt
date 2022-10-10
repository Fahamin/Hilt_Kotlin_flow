package com.fahamin.hiltcorutingmvvmretrofit.Repository

import com.fahamin.hiltcorutingmvvmretrofit.Api.Api
import com.fahamin.hiltcorutingmvvmretrofit.Model.NetworkResult
import com.fahamin.hiltcorutingmvvmretrofit.Utility.Constance
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepository @Inject constructor(private var api: Api) {

    suspend fun getImageList() = flow {
        emit(NetworkResult.Loading(true))
        var result = api.getImageList(Constance.tokernID)
        emit(NetworkResult.Success(result))
    }.catch { e ->
        emit(NetworkResult.Failure("" + e.message))
    }

}