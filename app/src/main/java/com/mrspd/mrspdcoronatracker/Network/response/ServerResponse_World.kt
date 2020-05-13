package com.mrspd.mrspdcoronatracker.Network.response

import com.google.gson.annotations.SerializedName
import com.mrspd.mrspdcoronatracker.Models.Data_the_Corona_World

class ServerResponse_World{
    @SerializedName("areas")
    private var mResult: List<Data_the_Corona_World?>? = null

    fun getResult():List<Data_the_Corona_World?>? {
        return mResult
    }

    fun setResult(result: List<Data_the_Corona_World?>?) {
        mResult = result
    }
}