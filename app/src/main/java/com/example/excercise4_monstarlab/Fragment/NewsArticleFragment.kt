package com.example.excercise4_monstarlab.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.excercise4_monstarlab.R
import kotlinx.android.synthetic.main.fragment_news_article.view.*

class NewsArticleFragment : Fragment(){

    val TAG: String ="newsArticleFragment"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_news_article,container,false)
        var bundle: Bundle? = arguments
        view.textViewTitle.text = bundle?.getString("title")
        view.textViewCalendar.text = bundle?.getString("date")
        view.textViewDetails.text = bundle?.getString("details")
        view.imageViewBackNewsArticle.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        return view
    }
}