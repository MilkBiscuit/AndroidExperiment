package com.cheng.experimentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cheng.experimentapp.usecase.LaunchAppUC

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btn_restart).setOnClickListener {
            val launchAppUC = LaunchAppUC(this)
            launchAppUC.immediateRestart()
        }
    }
}
