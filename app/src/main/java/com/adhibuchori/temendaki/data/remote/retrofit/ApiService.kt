package com.adhibuchori.temendaki.data.remote.retrofit

import com.adhibuchori.temendaki.data.remote.response.LoginResponse
import com.adhibuchori.temendaki.data.remote.response.RegisterResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("province") province: String,
        @Field("experience_level") experienceLevel: String,
        @Field("password") password: String,
        @Field("confirm_password") confirmPassword: String
    ) : RegisterResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse
}