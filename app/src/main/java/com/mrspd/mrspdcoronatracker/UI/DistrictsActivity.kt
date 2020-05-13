package com.mrspd.mrspdcoronatracker.UI

import android.os.Bundle
import android.util.Log.d
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.mrspd.mrspdcoronatracker.Adapters.CRDataAdapter_district
import com.mrspd.mrspdcoronatracker.CustomLoadingBar
import com.mrspd.mrspdcoronatracker.Models.Data_the_Corona_District
import com.mrspd.mrspdcoronatracker.R
import kotlinx.android.synthetic.main.activity_districts_.*
import org.json.JSONArray
import org.json.JSONObject


class DistrictsActivity : AppCompatActivity() {
    var customLoadingBarrrr = CustomLoadingBar(this)


    var JSONurlForDistricts: String = "https://api.covid19india.org/v2/state_district_wise.json"


    override fun onCreate(savedInstanceState: Bundle?) {
        //  customLoadingBarrrr.startLoader()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_districts_)
        var stateName: String = intent.getStringExtra("stateName")

        d("confirmed cases-11", " state ")
        val queue = Volley.newRequestQueue(this)
        customLoadingBarrrr.startLoader()


        var stringrequest = StringRequest(Request.Method.GET, JSONurlForDistricts,
            com.android.volley.Response.Listener<String> { response ->

                var strResp = response.toString()

                val jsonObj: JSONArray = JSONArray(strResp)

                for (i in 0 until jsonObj.length()) {
                    val jsonObj2: JSONObject = jsonObj.getJSONObject(i)
                    var state: String? = jsonObj2.getString("state")
                    d("confirmed cases00", " state $state ")

                    if (state == stateName) {
                        var distictsDAta = mutableListOf<Data_the_Corona_District>()
//                        val playersModelArrayList: ArrayList<PlayerModel> = ArrayList()
                        var jsonArray2: JSONArray = jsonObj2.getJSONArray("districtData")
                        for (i in 0 until jsonArray2.length()) {
                            val data =
                                Data_the_Corona_District()

                            var jsnObjDistrict: JSONObject = jsonArray2.getJSONObject(i)
                            var jsonObj44: JSONObject = jsnObjDistrict.getJSONObject("delta")

                            data.setdelta(jsonObj44.getString("confirmed"))
                            data.setdistrict(jsnObjDistrict.getString("district"))
                            data.setConfirmed(jsnObjDistrict.getString("confirmed"))
                           distictsDAta.add(data)

                            d("confirmed cases11", " state $state ")

                        }
                        customLoadingBarrrr.dismissLoader()
                        recyclerview66.apply {
                            layoutManager =
                                LinearLayoutManager(this@DistrictsActivity)
                            adapter =
                                CRDataAdapter_district(
                                    distictsDAta
                                )
                        }

                    }
                    d("confirmed cases", " state $state ")
                }

            }, com.android.volley.Response.ErrorListener { d("hii", "didnt work bro") })
        queue.add(stringrequest)
    }

    fun back(view: View) {
        finish()
    }
}
