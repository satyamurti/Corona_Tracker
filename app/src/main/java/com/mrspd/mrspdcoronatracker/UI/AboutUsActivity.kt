package com.mrspd.mrspdcoronatracker.UI

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mrspd.mrspdcoronatracker.R

class AboutUsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
    }

    fun back(view: View) {
        finish()
    }
}
