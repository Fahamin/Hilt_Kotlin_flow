package com.fahamin.hiltcorutingmvvmretrofit.Api

import com.fahamin.hiltcorutingmvvmretrofit.Model.userModel.User
import com.fahamin.unplashapi_jetpack.UnsplashModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("/users")
    suspend fun getUserList(): Response<List<User>>

    @GET("photos")
    suspend fun getImageList(@Query("client_id") cid: String?): Response<List<UnsplashModel>>


}