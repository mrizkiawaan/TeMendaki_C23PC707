package com.adhibuchori.temendaki.data.remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("data")
    val data: LoginData
)

data class LoginData(
    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("password")
    val password: String
)

data class RegisterResponse(
    @field:SerializedName("message")
    val message: String,
)