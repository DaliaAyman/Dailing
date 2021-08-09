package com.dalia.presentation.features.homewritings

sealed class WritingsEvent {
    object RequestWritings: WritingsEvent()
}