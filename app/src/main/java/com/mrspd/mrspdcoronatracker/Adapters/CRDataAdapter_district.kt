package com.mrspd.mrspdcoronatracker.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mrspd.mrspdcoronatracker.Models.Data_the_Corona_District
import com.mrspd.mrspdcoronatracker.R
import kotlinx.android.synthetic.main.corna_data_row.view.*

class CRDataAdapter_district(private val crdat_district: MutableList<Data_the_Corona_District>) : RecyclerView.Adapter<CRDataAdapter_district.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.corna_data_row_districts,parent,false)
        return ViewHolder(
            view
        )
    }
    override fun getItemCount() =crdat_district.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = crdat_district[position]

        holder.tvConfirmedDistrict.text = data.getConfirmed()
        holder.tvState.text = data.getdistrict()
        holder.tvDelta.text = "+"+data.getdelta()

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvConfirmedDistrict : TextView = itemView.tvConfirmedDist
        val tvState : TextView = itemView.tvState_Dist
        val tvDelta : TextView = itemView.tvDeltacnfm_Dist



    }

}