package com.dalia.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dalia.data.preferences.PrefsStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val prefsStore: PrefsStore) : ViewModel() {

    val isLoggedIn = prefsStore.isLoggedIn().asLiveData()

    fun loggedInSuccessful(){
        viewModelScope.launch {
            prefsStore.saveLoggedInState()
        }
    }
}