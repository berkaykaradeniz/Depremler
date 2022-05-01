package com.example.appretrofit.adapter

import android.graphics.Color.RED
import android.hardware.camera2.params.RggbChannelVector.RED
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appretrofit.R
import com.example.appretrofit.model.QuakeResponse
import kotlinx.android.synthetic.main.activity_items_layout.view.*

class DepremlerAdapter : RecyclerView.Adapter<DepremlerAdapter.DepremViewHolder>() {

    private var DepremDataList: ArrayList<QuakeResponse.Result> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DepremViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.activity_items_layout, parent, false)
    )

    override fun onBindViewHolder(holder: DepremlerAdapter.DepremViewHolder, position: Int) {
        holder.bind(DepremDataList[position])
    }

    override fun getItemCount(): Int = DepremDataList.size

    inner class DepremViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(s: QuakeResponse.Result) {
            itemView.tvTown.text = s.lokasyon
            itemView.tvQuake.text = s.mag.toString()
            if (s.mag > 3.0)
                itemView.ivAlert.visibility = View.VISIBLE
        }
    }

    fun setDepremNameList(listDeprem: ArrayList<QuakeResponse.Result>){
        DepremDataList.clear()
        DepremDataList.addAll(listDeprem)
        notifyDataSetChanged()
    }

    fun clear(){
        DepremDataList.clear()
        notifyDataSetChanged()
    }
}