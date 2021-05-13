package com.example.excercise4_monstarlab.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.excercise4_monstarlab.Object.Menu
import com.example.excercise4_monstarlab.R

class MenuAdapter(private var list: MutableList<Menu>):
        RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> {
                val view: View =
                        LayoutInflater.from(parent.context)
                                .inflate(R.layout.item_layout_one, parent, false)
                OneViewHolder(view)
            }
            2 -> {
                val view: View =
                        LayoutInflater.from(parent.context)
                                .inflate(R.layout.item_layout_two, parent, false)
                TwoViewHolder(view)
            }
            else -> {
                val view: View =
                        LayoutInflater.from(parent.context)
                                .inflate(R.layout.item_layout_three, parent, false)
                ThreeViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is OneViewHolder -> holder.bind(
                    list[position].image,
                    list[position].title
            )
            is TwoViewHolder -> holder.bind(
                    list[position].title
            )
            is ThreeViewHolder -> holder.bind(
                    list[position].image,
                    list[position].title
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }

    inner class OneViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(img: Int,title: String) {
            var imgOne: ImageView = itemView.findViewById(R.id.imageViewItemOne)
            var titleOne: TextView = itemView.findViewById(R.id.textViewItemOne)
            imgOne.setImageResource(img)
            titleOne.text = title
        }
    }
    inner class TwoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(title: String) {
            var titleTwo:TextView = itemView.findViewById(R.id.textViewItemTwo)
            titleTwo.text = title
        }
    }
    inner class ThreeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(img: Int,title: String) {
            var imgThree: ImageView =  itemView.findViewById(R.id.imageViewItemThree);
            var titleThree: TextView = itemView.findViewById(R.id.textViewItemThree)
            imgThree.setImageResource(img)
            titleThree.text = title
        }
    }

}