package com.example.flightsearcher.flight.data

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class UserPreferencesRepository(
    private val dataStore: DataStore<Preferences>
) {
    private companion object {
        val SEARCH_FIELD_TEXT = stringPreferencesKey("search_field_text")
        const val TAG = "UserPreferencesRepository"
    }

    suspend fun saveSearchFieldData(newText: String) {
        dataStore.edit { preferences ->
            preferences[SEARCH_FIELD_TEXT] = newText
        }
    }

    val searchFieldText: Flow<String> = dataStore.data
        .catch {
            if(it is IOException) {
                Log.e(TAG, "Error reading preferences", it)
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
            preferences[SEARCH_FIELD_TEXT] ?: ""
        }
}