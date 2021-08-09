package com.dalia.dailing.util

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavDirections

fun NavController.safeNavigate(direction: NavDirections) {
    Log.d("NavController", "Click happened")
    currentDestination?.getAction(direction.actionId)?.run {
        Log.d("NavController", "Click Propagated")
        navigate(direction)
    }
}