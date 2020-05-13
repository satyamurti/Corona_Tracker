package com.mrspd.mrspdcoronatracker.Network

import com.mrspd.mrspdcoronatracker.Network.response.ServerResponse
import retrofit2.Call
import retrofit2.http.GET

interface APIServices {
    @GET("/data.json")
    fun Data_the_Collecter(): Call<ServerResponse>
}