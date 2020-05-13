package com.mrspd.mrspdcoronatracker.UI

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mrspd.mrspdcoronatracker.R
import kotlinx.android.synthetic.main.activity_precautions.*
import kotlin.random.Random

class PrecautionsActivity : AppCompatActivity() {
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_precautions)

        val listOfImage  = mutableListOf<Int>()
        listOfImage.add(R.drawable.precautions1)
        listOfImage.add(R.drawable.precautions2)
        listOfImage.add(R.drawable.precautions3)
        listOfImage.add(R.drawable.precautions4)

        handler.post(object : Runnable {
            override fun run() {
                val randomNumber = Random.nextInt(0, listOfImage.size)
                val randomItem = listOfImage[randomNumber]
                precautionsImageView.setImageResource(listOfImage[randomNumber])
                handler.postDelayed(this, 5000)
            }
        })
    }

    fun back1(view: View) {
        finish()
    }
}
