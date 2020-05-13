package com.mrspd.mrspdcoronatracker.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mrspd.mrspdcoronatracker.Models.Data_the_Corona_World
import com.mrspd.mrspdcoronatracker.R
import kotlinx.android.synthetic.main.corna_data_row.view.*

class CRDataAdapter_World(private  val crdat_world: MutableList<Data_the_Corona_World>) : RecyclerView.Adapter<CRDataAdapter_World.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.corna_data_row,parent,false)
        return ViewHolder(
            view
        )
    }
    override fun getItemCount() =crdat_world.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = crdat_world[position]
        holder.tvState.text = data.getdisplayName()
        holder.tvConfirmed.text = data.getConfirmed()
        holder.tvRecoverd.text = data.gettotalRecovered()
        holder.tvDeaths.text = data.gettotalDeaths()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvState : TextView = itemView.tvState_Dist
        val tvConfirmed : TextView = itemView.tvConfirmedDist
        val tvRecoverd : TextView = itemView.recoveredCount
        val tvDeaths : TextView = itemView.deathCount
    }

}
