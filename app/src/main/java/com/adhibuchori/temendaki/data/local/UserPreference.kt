package com.adhibuchori.temendaki.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreference private constructor(private val dataStore: DataStore<Preferences>) {

    private val email = stringPreferencesKey("email")

    fun getEmail(): Flow<String?> {
        return dataStore.data.map { preferences ->
            preferences[email]
        }
    }

    suspend fun saveEmail(token: String) {
        dataStore.edit { preferences ->
            preferences[email] = "Bearer $token"
        }
    }

    suspend fun logout(){
        dataStore.edit {
            it.clear()
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: UserPreference? = null

        fun getInstance(dataStore: DataStore<Preferences>): UserPreference {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}