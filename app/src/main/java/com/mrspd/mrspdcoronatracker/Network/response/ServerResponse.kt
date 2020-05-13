package com.mrspd.mrspdcoronatracker.Network.response

import com.google.gson.annotations.SerializedName
import com.mrspd.mrspdcoronatracker.Models.Data_the_Corona


class ServerResponse {
    @SerializedName("statewise")
    private var mResult: List<Data_the_Corona?>? = null

    fun getResult():List<Data_the_Corona?>? {
        return mResult
    }

//    fun setResult(result: List<Data_the_Corona?>?) {
//        mResult = result
//    }

}