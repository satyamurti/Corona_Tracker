package com.mrspd.mrspdcoronatracker.Network

import com.mrspd.mrspdcoronatracker.Network.response.ServerResponse_World
import retrofit2.Call
import retrofit2.http.GET

interface APIServices_World {
    @GET("/covid/data")
    fun Data_the_Collecter(): Call<ServerResponse_World>
}