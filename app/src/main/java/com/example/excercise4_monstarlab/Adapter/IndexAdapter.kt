package com.example.excercise4_monstarlab.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.excercise4_monstarlab.Object.Home
import com.example.excercise4_monstarlab.R

class IndexAdapter(private var list: MutableList<Home>) : RecyclerView.Adapter<IndexAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndexAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_home, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: IndexAdapter.ViewHolder, position: Int) {
        var home: Home = list[position]
        if (home.number.equals("") && home.name.equals("") && home.address.equals("") && home.time.equals("") && home.numberPlus.equals("")) {
            holder.txtNumber.visibility = View.GONE
            holder.imageLine.visibility = View.GONE

        }
        holder.txtName.text = home.name
        holder.txtAddress.text = home.address
        holder.txtTime.text = home.time
        holder.txtNumber.text = home.number
        holder.txtNumberPlus.text = home.numberPlus

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageLine: ImageView
        var txtName: TextView
        var txtAddress: TextView
        var txtTime: TextView
        var txtNumber: TextView
        var txtNumberPlus: TextView

        init {
            txtName = itemView.findViewById(R.id.textViewName)
            txtAddress = itemView.findViewById(R.id.textViewAddress)
            txtTime = itemView.findViewById(R.id.textViewTime)
            txtNumber = itemView.findViewById(R.id.textViewNumber)
            txtNumberPlus = itemView.findViewById(R.id.textViewNumberPlus)
            imageLine = itemView.findViewById(R.id.imageViewLine)
        }
    }

}