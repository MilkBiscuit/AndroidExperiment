package com.cheng.experimentapp

import android.app.Application
import android.util.Log

class MainApplication: Application() {

    override fun onCreate() {
        super<Application>.onCreate()

        Log.e("MainApplication", "trpb67, onCreate called")
    }

}
