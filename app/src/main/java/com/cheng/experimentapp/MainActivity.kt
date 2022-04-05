package com.cheng.experimentapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.button).setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                Log.e("trpb67", "button instance:" + findViewById<Button>(R.id.button))
                findViewById<Button>(R.id.button).text = "Hello World"
            }, 5000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("trpb67", "onDestroy")
    }
}
