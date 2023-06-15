package com.adhibuchori.temendaki.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.adhibuchori.temendaki.data.remote.repository.UserRepository

class MainViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    fun isLogin() = userRepository.isLogin().asLiveData()

    fun logout() = userRepository.logout().asLiveData()
}