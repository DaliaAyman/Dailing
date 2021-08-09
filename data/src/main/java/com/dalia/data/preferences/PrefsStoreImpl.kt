package com.dalia.data.preferences

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.createDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

private const val STORE_NAME = "dailings_data_store"

class PrefsStoreImpl @Inject constructor(
    @ApplicationContext context: Context
) : PrefsStore {

    private val dataStore = context.createDataStore(
        name = STORE_NAME
    )

    override fun showOnboarding(): Flow<Boolean> {
        return dataStore.data.catch {
            exception ->
            if(exception is IOException){
                emit(emptyPreferences())
            }else{
                throw exception
            }
        }.map {
            it[PreferencesKeys.ONBOARDING_ENABLED_KEY] ?: true
        }
    }

    override suspend fun disableOnboarding() {
        dataStore.edit {
            it[PreferencesKeys.ONBOARDING_ENABLED_KEY] = !(it[PreferencesKeys.ONBOARDING_ENABLED_KEY] ?: false)
        }
    }

    override fun isLoggedIn(): Flow<Boolean> {
        return dataStore.data.catch {
                exception ->
            if(exception is IOException){
                emit(emptyPreferences())
            }else{
                throw exception
            }
        }.map {
            it[PreferencesKeys.IS_LOGGED_IN_KEY] ?: false
        }
    }

    override suspend fun saveLoggedInState() {
        dataStore.edit {
            it[PreferencesKeys.IS_LOGGED_IN_KEY] = !(it[PreferencesKeys.IS_LOGGED_IN_KEY] ?: false)
        }
    }


    private object PreferencesKeys {
        val ONBOARDING_ENABLED_KEY = booleanPreferencesKey("onboarding_enabled")
        val IS_LOGGED_IN_KEY = booleanPreferencesKey("is_logged_in")
    }
}