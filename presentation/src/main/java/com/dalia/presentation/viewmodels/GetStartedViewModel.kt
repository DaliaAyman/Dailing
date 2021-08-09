package com.dalia.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.dalia.data.preferences.PrefsStore
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetStartedViewModel @Inject constructor(private val prefsStore: PrefsStore) : ViewModel(){


    val showOnboarding = prefsStore.showOnboarding().asLiveData()



    fun disableOnboarding(){
        viewModelScope.launch {
            prefsStore.disableOnboarding()
        }
    }

}
