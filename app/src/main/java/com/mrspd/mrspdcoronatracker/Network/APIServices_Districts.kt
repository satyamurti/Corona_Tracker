package com.mrspd.mrspdcoronatracker.Network

import com.mrspd.mrspdcoronatracker.Network.response.ServerResponse_District
import retrofit2.Call
import retrofit2.http.GET

interface APIServices_Districts {
    @GET("/state_district_wise.json")
    fun Data_the_Collecter(): Call<ServerResponse_District>
}