package com.example.excercise4_monstarlab.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.excercise4_monstarlab.Object.News
import com.example.excercise4_monstarlab.R
import kotlinx.android.synthetic.main.item_recyclerview_news.view.*

class NewsAdapter(private var listNews: MutableList<News>, private val listener: OnItemClickLister) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_news, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listNews.size;
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        var news: News = listNews[position]
        holder.txtMinus.text = news.minus
        holder.txtDate.text = news.date
        holder.txtName.text = news.name
        holder.txtDetail.text = news.detail
        holder.img.setImageResource(news.image)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var img: ImageView
        var txtMinus: TextView
        var txtDate: TextView
        var txtName: TextView
        var txtDetail: TextView

        init {
            img = itemView.findViewById(R.id.imageViewItemNews)
            txtMinus = itemView.findViewById(R.id.textViewMinusItemNews)
            txtDate = itemView.findViewById(R.id.textViewDateItemNews)
            txtName = itemView.findViewById(R.id.textViewNameItemNews)
            txtDetail = itemView.findViewById(R.id.textViewDetailItemNews)
            img.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = layoutPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickLister {
        fun onItemClick(position: Int)
    }
}