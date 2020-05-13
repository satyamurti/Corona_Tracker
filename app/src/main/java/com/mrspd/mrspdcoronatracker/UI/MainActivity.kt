package com.mrspd.mrspdcoronatracker.UI

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log.d
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrspd.mrspdcoronatracker.Adapters.CRDataAdapter
import com.mrspd.mrspdcoronatracker.CustomLoadingBar
import com.mrspd.mrspdcoronatracker.Models.Data_the_Corona
import com.mrspd.mrspdcoronatracker.Network.APIServices
import com.mrspd.mrspdcoronatracker.Network.response.ServerResponse
import com.mrspd.mrspdcoronatracker.R
import kotlinx.android.synthetic.main.activity_main1.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    var customLoadingBarrrr =
        CustomLoadingBar(this@MainActivity)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        setupBottomBar()

        customLoadingBarrrr.startLoader()


        val CRdata = mutableListOf<Data_the_Corona>()


//        fab.setOnClickListener { view ->
//            intent = Intent(applicationContext,World_the_corona::class.java)
//            startActivity(intent)
//        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.covid19india.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(APIServices::class.java)

        api.Data_the_Collecter().enqueue(object : Callback<ServerResponse> {
            override fun onResponse(
                call: retrofit2.Call<ServerResponse>,
                response: Response<ServerResponse>
            ) {
                val serverResponse = response.body()
                customLoadingBarrrr.dismissLoader()

                if (serverResponse != null) {
                    d("succeess hua", " successss")
                    var resultList: MutableList<Data_the_Corona> =
                        serverResponse.getResult() as MutableList<Data_the_Corona>



                    for (index in resultList.indices) {
                        val item = resultList[index]
                        if (item.getstate() == "Total") {
                            setupCounts(item)
                            resultList.removeAt(index)
                            break
                        }
                    }




                recyclerview1.apply {
                    layoutManager =
                        LinearLayoutManager(this@MainActivity)
                    adapter =
                        CRDataAdapter(
                            resultList
                        ) {
                            d("adapter", "Onclick hua ${it.getstate()}")
                            intent = Intent(this@MainActivity, DistrictsActivity::class.java)
                            intent.putExtra("stateName", it.getstate())
                            startActivity(intent)
                        }
                }

            }
        }

                override fun onFailure(call: retrofit2.Call<ServerResponse>, t: Throwable) {
            customLoadingBarrrr.dismissLoader()
            d("ille", "iiillle")
        }

    })


}

    private fun setupCounts(item: Data_the_Corona) {
        tvConfirmed111.text = item.getConfirmed()
        tvCured.text = item.getrecovered()
        tvDeaths.text = item.getdeaths()
       tvDeltacnfm_Dist123.text ="+ "+ item.getdeltaconfirmed()

    }
    private fun setupBottomBar() {
        bottomNavBar.setOnNavigationItemSelectedListener { item: MenuItem ->
            when(item.itemId) {
                R.id.action_overview -> wolrd()
                R.id.action_india -> source()
                R.id.action_Precaution -> about()
                R.id.act_aboutus -> prec()
                R.id.action_source -> trustedsource()
            }

            return@setOnNavigationItemSelectedListener true
        }
    }


    private fun wolrd() {
        intent = Intent(applicationContext, WorldActivity::class.java)
        startActivity(intent)
    }

    fun trustedsource() {
        intent = Intent(applicationContext, TrustedSourceActivity::class.java)
        startActivity(intent)
    }

    fun prec() {
        intent = Intent(applicationContext, AboutUsActivity::class.java)
        startActivity(intent)
    }
    fun about() {
        intent = Intent(applicationContext, PrecautionsActivity::class.java)
        startActivity(intent)
    }
    fun source() {
//            val webIntent: Intent = Uri.parse("https://play.google.com/store/apps/details?id=nic.goi.aarogyasetu").let { webpage ->
//                Intent(Intent.ACTION_VIEW, webpage)
        intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://play.google.com/store/apps/details?id=nic.goi.aarogyasetu")
        startActivity(intent)

    }

}



