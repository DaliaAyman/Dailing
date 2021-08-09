package com.dalia.presentation.features.homewritings

import com.dalia.presentation.common.Event
import com.dalia.presentation.models.UIWriting

data class WritingsViewState(
        val loading: Boolean = true,
        val writings: List<UIWriting> = emptyList(),
        val failure: Event<Throwable>? = null
)