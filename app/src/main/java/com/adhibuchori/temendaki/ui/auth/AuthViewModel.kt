package com.adhibuchori.temendaki.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.adhibuchori.temendaki.data.remote.repository.UserRepository

class AuthViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun register(
        username: String,
        email: String,
        province: String,
        experienceLevel: String,
        password: String,
        confirmPassword: String
    ) = userRepository.register(
        username,
        email,
        province,
        experienceLevel,
        password,
        confirmPassword
    ).asLiveData()

    fun login(
        email: String,
        password: String
    ) = userRepository.login(
        email,
        password
    ).asLiveData()

    fun isLogin() = userRepository.isLogin().asLiveData()
}