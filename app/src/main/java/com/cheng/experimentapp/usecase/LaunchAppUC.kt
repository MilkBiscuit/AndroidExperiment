package com.cheng.experimentapp.usecase

import android.content.Context
import android.content.Intent
import kotlin.system.exitProcess


class LaunchAppUC constructor(
    private val context: Context
) {

    fun immediateRestart() {
        val packageManager = context.packageManager
        val intent = packageManager.getLaunchIntentForPackage(context.packageName)
        val componentName = intent!!.component
        val mainIntent = Intent.makeRestartActivityTask(componentName)
        context.startActivity(mainIntent)

        exitProcess(0)
    }

}
