package com.mrspd.mrspdcoronatracker.Models

import com.google.gson.annotations.SerializedName

class  Data_the_Corona{

    @SerializedName("state")
    private var mState  : String? = null

    @SerializedName("recovered")
    private var mrecovered  : String? = null

    @SerializedName("confirmed")
    private var mConfirmed: String? = null

    @SerializedName("deltaconfirmed")
    private var mdeltaconfirmed: String? = null
    @SerializedName("deaths")
    private var mDeaths  : String? = null

fun Data_the_Corona(
    state: String,confirmed: String?, recovered: String?, deaths: String?, deltaconfirmed: String?
){

    this.mConfirmed = confirmed
    this.mState = state
    this.mrecovered = recovered
    this.mDeaths = deaths
    this.mdeltaconfirmed = deltaconfirmed
}

    fun getrecovered() : String?{
        return mrecovered
    }
    fun getdeltaconfirmed() : String?{
        return mdeltaconfirmed
    }
    fun setdeltaconfirmed(deltaconfirmed: String){
        mdeltaconfirmed = deltaconfirmed
    }

    fun setrecovered(recovered : String){
        mrecovered = recovered

    }
    fun getstate() : String?{
        return mState
    }

    fun setstate(state: String) {
        mState = state
    }

    fun getConfirmed(): String? {
        return mConfirmed
    }

    fun setConfirmed(confirmed: String?) {
        this.mConfirmed = confirmed
    }


    fun getdeaths(): String? {
        return mDeaths
    }

    fun setdeaths(deaths: String?) {
        this.mDeaths = deaths
    }

}
