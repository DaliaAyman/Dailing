package com.dalia.data.preferences

import kotlinx.coroutines.flow.Flow

interface PrefsStore {

    fun showOnboarding(): Flow<Boolean>
    suspend fun disableOnboarding()

    fun isLoggedIn(): Flow<Boolean>
    suspend fun saveLoggedInState()

}