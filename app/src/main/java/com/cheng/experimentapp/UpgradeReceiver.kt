package com.cheng.experimentapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.cheng.experimentapp.usecase.LaunchAppUC
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

class UpgradeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Timber.e("trpb67, intent received: ${intent.action}")

        MainScope().launch {
            Timber.e("trpb67, inside scope")
            delay(60_000)
            LaunchAppUC(context).launchApp()
            Timber.e("trpb67, leaving scope")
        }
        Timber.e("trpb67, onReceive end.")
    }
}
