package com.cheng.experimentapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.cheng.experimentapp.ui.BoomFragment
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        setContentView(R.layout.activity_main_with_fragment)
        showFragment()

//        findViewById<View>(R.id.button).setOnClickListener {
//            Handler(Looper.getMainLooper()).postDelayed({
//                findViewById<Button>(R.id.button).text = "Hello World"
//            }, 5000)
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("trpb67, onDestroy")
    }

    private fun showFragment() {
        val fragment = BoomFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.rootContentPanel, fragment)
            .commit()
    }
}
