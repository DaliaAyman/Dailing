package com.dalia.dailing

import android.app.Application
import androidx.databinding.library.BuildConfig
import com.dalia.device.logging.Logger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DailingApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
            Logger.init()
        }


    }
}