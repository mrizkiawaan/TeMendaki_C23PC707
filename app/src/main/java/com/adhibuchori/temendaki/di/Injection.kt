package com.adhibuchori.temendaki.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.adhibuchori.temendaki.data.local.UserPreference
import com.adhibuchori.temendaki.data.remote.repository.UserRepository
import com.adhibuchori.temendaki.data.remote.retrofit.ApiConfig

object Injection {
    fun provideUserRepository(dataStore: DataStore<Preferences>): UserRepository {
        val apiService = ApiConfig.getApiService()
        val authPreferences = UserPreference.getInstance(dataStore)
        return UserRepository.getInstance(apiService, authPreferences)
    }
}