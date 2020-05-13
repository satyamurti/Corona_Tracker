package com.mrspd.mrspdcoronatracker

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable

class CustomLoadingBar(val activity: Activity) {


   lateinit var dialog: AlertDialog
    fun startLoader() {
        val inflater = activity.layoutInflater
        var  builder = AlertDialog.Builder(activity)
        builder.setView(inflater.inflate(R.layout.custom_loading_bar, null))
        dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    fun dismissLoader() {
        dialog.dismiss()
    }

}