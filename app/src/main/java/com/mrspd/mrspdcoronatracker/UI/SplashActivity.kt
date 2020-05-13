package com.mrspd.mrspdcoronatracker.UI

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mrspd.mrspdcoronatracker.R


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

    }

    fun Go(view: View) {
        val mainIntent =
            Intent(this, MainActivity::class.java)
        this.startActivity(mainIntent)
        this.finish()
    }
}
