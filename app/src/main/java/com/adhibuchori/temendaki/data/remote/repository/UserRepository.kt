package com.adhibuchori.temendaki.data.remote.repository

import android.util.Log
import com.adhibuchori.temendaki.data.local.UserPreference
import com.adhibuchori.temendaki.data.remote.retrofit.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import com.adhibuchori.temendaki.data.remote.utils.Result

class UserRepository private constructor(
    private val apiService: ApiService,
    private val userPreference: UserPreference
) {
    fun isLogin(): Flow<String?> = flow { emitAll(userPreference.getEmail()) }

    fun login(email: String, password: String): Flow<Result<String>> = flow {
        emit(Result.Loading)
        try {
            val response = apiService.login(email, password)

            @Suppress("NAME_SHADOWING")
            val email = response.data.email

            userPreference.saveEmail(email)
            emit(Result.Success(response.message))
        } catch (e: Exception) {
            Log.d("UserRepository", "login: ${e.message.toString()}")
            emit(Result.Error(e.message.toString()))
        }
    }

    fun register(
        username: String,
        email: String,
        province: String,
        experienceLevel: String,
        password: String,
        confirmPassword: String,

        ): Flow<Result<String>> = flow {
        emit(Result.Loading)
        try {
            val response = apiService.register(
                username,
                email,
                province,
                experienceLevel,
                password,
                confirmPassword,
            )
            emit(Result.Success(response.message))
        } catch (e: Exception) {
            Log.d("UserRepository", "register: ${e.message.toString()}")
            emit(Result.Error(e.message.toString()))
        }
    }

    fun logout(): Flow<Result<String>> = flow {
        emit(Result.Loading)
        userPreference.logout()
        emit(Result.Success("success"))
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            apiService: ApiService,
            userPreference: UserPreference
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(apiService, userPreference)
            }.also { instance = it }
    }
}