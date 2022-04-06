package com.cheng.experimentapp

import android.app.Application
import timber.log.Timber


class MainApplication: Application() {

    override fun onCreate() {
        super<Application>.onCreate()

        Timber.plant(Timber.DebugTree())
        Timber.e("trpb67, application onCreate called")
    }

}
