package com.mrspd.mrspdcoronatracker.Models


class  Data_the_Corona_District {
  //  @SerializedName("confirmed")
    private var mConfirmed: String? = null
    private var mDistrict: String? = null
    private var mDelta: String? = null




    fun Data_the_Corona_World(
        confirmed: String?,delta : String?, district: String?
    ) {

        this.mConfirmed = confirmed
        this.mDistrict = district
        this.mDelta = delta
    }



    fun getdelta(): String? {
        return mDelta
    }

    fun setdelta(delta: String?) {
        this.mDelta = delta
    }

    fun getConfirmed(): String? {
        return mConfirmed
    }

    fun setConfirmed(confirmed: String?) {
        this.mConfirmed = confirmed
    }


    fun getdistrict(): String? {
        return mDistrict
    }

    fun setdistrict(district: String?) {
        this.mDistrict = district
    }
}
