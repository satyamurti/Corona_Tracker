package com.mrspd.mrspdcoronatracker.UI

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrspd.mrspdcoronatracker.Adapters.CRDataAdapter_World
import com.mrspd.mrspdcoronatracker.CustomLoadingBar
import com.mrspd.mrspdcoronatracker.Models.Data_the_Corona_World
import com.mrspd.mrspdcoronatracker.Network.APIServices_World
import com.mrspd.mrspdcoronatracker.Network.response.ServerResponse_World
import com.mrspd.mrspdcoronatracker.R
import kotlinx.android.synthetic.main.activity_world_the_corona.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WorldActivity : AppCompatActivity() {
    var customLoadingBarrrr  =
        CustomLoadingBar(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_world_the_corona)
        customLoadingBarrrr.startLoader()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://bing.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(APIServices_World::class.java)
        api.Data_the_Collecter().enqueue(object : Callback<ServerResponse_World> {

            override fun onFailure(call: Call<ServerResponse_World>, t: Throwable) {
                customLoadingBarrrr.dismissLoader()
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<ServerResponse_World>,
                response: Response<ServerResponse_World>
            ) {
                val serverResponse = response.body()
                customLoadingBarrrr.dismissLoader()

                if (serverResponse != null) {
                    Log.d("succeess hua", " successss")
                    var resultList: MutableList<Data_the_Corona_World> =
                        serverResponse.getResult() as MutableList<Data_the_Corona_World>

                    recyclerview1_world.apply {
                        layoutManager = LinearLayoutManager(this@WorldActivity)
                        adapter =
                            CRDataAdapter_World(
                                resultList
                            )

                    }

                }
            }
        })

    }

    fun back(view: View) {
        finish()
    }
}
