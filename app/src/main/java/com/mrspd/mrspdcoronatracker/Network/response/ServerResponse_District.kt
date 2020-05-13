package com.mrspd.mrspdcoronatracker.Network.response

import com.google.gson.annotations.SerializedName
import com.mrspd.mrspdcoronatracker.Models.Data_the_Corona


class ServerResponse_District {
    @SerializedName("statewise")

    private var mStateName : String? = null

    private var mResult: List<Data_the_Corona>? = null

    fun getResult():List<Data_the_Corona?>? {
        return mResult
    }
    fun setStateName(state: String?) {
        this.mStateName = state

    }

}