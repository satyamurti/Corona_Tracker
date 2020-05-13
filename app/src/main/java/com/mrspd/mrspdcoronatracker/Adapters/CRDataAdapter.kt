package com.mrspd.mrspdcoronatracker.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mrspd.mrspdcoronatracker.Models.Data_the_Corona
import com.mrspd.mrspdcoronatracker.R
import kotlinx.android.synthetic.main.corna_data_row.view.*

class CRDataAdapter(private  val cRdata: MutableList<Data_the_Corona>, private val mListener: (Data_the_Corona) -> Unit) : RecyclerView.Adapter<CRDataAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.corna_data_row,parent,false)
        return ViewHolder(
            view
        )
    }


    override fun getItemCount()= cRdata.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = cRdata[position]
        holder.tvState.text = data.getstate()
        holder.tvConfirmed.text = data.getConfirmed()
        holder.tvRecovered.text = data.getrecovered()
        holder.tvDeaths.text = data.getdeaths()
        holder.tvDeltaConfrm.text ="+"+data.getdeltaconfirmed()

        holder.itemView.setOnClickListener {
            data.let { it1 -> mListener.invoke(it1) }
        }

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        val tvState : TextView = itemView.tvState_Dist
        val tvConfirmed : TextView = itemView.tvConfirmedDist
        val tvDeaths : TextView = itemView.deathCount
        val tvRecovered : TextView = itemView.recoveredCount
        val tvDeltaConfrm : TextView = itemView.tvDeltacnfm_Dist


        override fun onClick(v: View?) {
        }
    }


    interface OnNoteListener {
        fun onNoteClickkk(position: Int)
    }

}
