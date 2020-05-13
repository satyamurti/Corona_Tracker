package com.mrspd.mrspdcoronatracker.Models

import com.google.gson.annotations.SerializedName

class Data_the_Corona_World{
    @SerializedName("displayName")
    private var mdisplayName  : String? = null

    @SerializedName("totalConfirmed")
    private var mConfirmed: String? = null

    @SerializedName("totalRecovered")
    private var mtotalRecovered: String? = null

    @SerializedName("totalDeaths")
    private var mtotalDeaths: String? = null

    fun Data_the_Corona(
        displayName: String,totalConfirmed: String?,totalDeaths : String? , totalRecovered: String?
    ){

        this.mConfirmed = totalConfirmed
        this.mdisplayName = displayName
        this.mtotalRecovered = totalRecovered
        this.mtotalDeaths = totalDeaths
    }

    fun getdisplayName() : String?{
        return mdisplayName
    }

    fun setdisplayName(displayName: String) {
        mdisplayName = displayName
    }

    fun getConfirmed(): String? {
        return mConfirmed
    }

    fun setConfirmed(totalConfirmed: String?) {
        this.mConfirmed = totalConfirmed
    }

    fun gettotalRecovered() : String?{
        return mtotalRecovered
    }
    fun settotalRecovered(totalRecovered: String) {
        mtotalRecovered = totalRecovered
    }
    fun gettotalDeaths() : String?{
        return mtotalDeaths
    }
    fun settotalDeaths(totalDeaths: String) {
        mtotalDeaths = totalDeaths
    }
}