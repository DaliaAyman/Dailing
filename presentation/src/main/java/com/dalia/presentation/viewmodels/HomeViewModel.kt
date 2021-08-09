package com.dalia.presentation.viewmodels

import androidx.lifecycle.*
import com.dalia.common.DispatchersProvider
import com.dalia.common.NetworkException
import com.dalia.common.NetworkUnavailableException
import com.dalia.common.extensions.createExceptionHandler
import com.dalia.domain.model.common.Writing
import com.dalia.presentation.common.Event
import com.dalia.presentation.features.homewritings.WritingsEvent
import com.dalia.presentation.features.homewritings.WritingsViewState
import com.dalia.presentation.mappers.UiWritingMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val uiWritingMapper: UiWritingMapper,
    private val dispatchersProvider: DispatchersProvider,
    private val compositeDisposable: CompositeDisposable
) : ViewModel() {

    val suggestionsState: LiveData<WritingsViewState> get() = _suggestionsState

    private val _suggestionsState = MutableLiveData<WritingsViewState>()

    init {
        _suggestionsState.value = WritingsViewState()
    }


    fun onEvent(event: WritingsEvent) {
        when (event) {
            is WritingsEvent.RequestWritings -> loadWritings()
        }
    }

    private fun checkIfNotEnoughSuggestions(list: List<Writing>): Boolean{
        return list.isEmpty() || list.size < 4
    }

    private fun loadWritings() {
        val errorMessage = "Failed to fetch writings"
        val exceptionHandler = viewModelScope.createExceptionHandler(errorMessage) { onFailure(it) }

        viewModelScope.launch(exceptionHandler) {
            withContext(dispatchersProvider.io()){
//                getWritings()
            }
        }
    }

    private fun onFailure(failure: Throwable) {
        when (failure) {
            is NetworkUnavailableException,
            is NetworkException -> {
                _suggestionsState.value = suggestionsState.value!!.copy(
                    loading = false,
                    failure = Event(failure)
                )
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}