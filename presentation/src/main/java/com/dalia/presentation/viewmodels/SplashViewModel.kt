package com.dalia.presentation.viewmodels

import androidx.lifecycle.*
import com.dalia.data.preferences.PrefsStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val prefsStore: PrefsStore) : ViewModel() {

    val isLoggedIn = prefsStore.isLoggedIn().asLiveData().default(false)



    fun saveLoggedInState(){
        viewModelScope.launch {
            prefsStore.saveLoggedInState()
        }
    }

    fun <T : Any?> LiveData<T>.default(initialValue: T) = apply { value == initialValue }

}