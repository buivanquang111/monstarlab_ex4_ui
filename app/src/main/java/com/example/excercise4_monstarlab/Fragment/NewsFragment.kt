package com.example.excercise4_monstarlab.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.excercise4_monstarlab.Adapter.NewsAdapter
import com.example.excercise4_monstarlab.LoginFragment.LoginFragment
import com.example.excercise4_monstarlab.Object.News
import com.example.excercise4_monstarlab.R
import kotlinx.android.synthetic.main.fragment_news.view.*

class NewsFragment : Fragment(), NewsAdapter.OnItemClickLister {
    private var list: MutableList<News> = mutableListOf()
    val adapter: NewsAdapter = NewsAdapter(list, this)
    lateinit var detail: String
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_news, container, false)
        detail = "Rem deserunt voluptatem sapiente. Quod sint officiis quae magnam. Qui eaque atque quia. " +
                "Incidunt dolor reiciendis tenetur libero error consequatur voluptate recusandae. Sequi voluptatum quas. Ullam voluptatem" +
                "reprehenderit ea commodi. Doloremque autem praesentium qui harum quia sunt voluptatem eius at." +
                "Voluptates voluptatem eaque et voluptas maxime molestiae et. Et saepe perferendis ut quidem et est. Et" +
                " iusto ut nostrum delectus. Libero et modi placeat labore sit et quaerat sed. Dolorem libero earum ipsum illum nemo."
        list.add(News("ATLANTIA", "ALT -3,87%", "3 Sept 2020", "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus", R.drawable.photo2390177))
        list.add(News("ATLANTIA", "HKD -2,13%", "2 Sept 2020", "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus", R.drawable.photo2351087))
        list.add(News("ATLANTIA", "ALT -3,87%", "3 Sept 2020", "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus", R.drawable.photo2390177))
        list.add(News("ATLANTIA", "ALT -3,87%", "3 Sept 2020", "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus", R.drawable.photo2351087))
        list.add(News("ATLANTIA", "ALT -3,87%", "3 Sept 2020", "Illum velit nam voluptatum enim aut ratione ratione officiis totam. Mollitia eum sint tempora ducimus", R.drawable.photo2390177))
        view.recyclerViewNews.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        view.recyclerViewNews.adapter = adapter
        view.imageViewBackCoin.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        return view
    }

    override fun onItemClick(position: Int) {
        Log.d("aaa", "b chon" + list[position])
        var transaction: FragmentTransaction? = fragmentManager?.beginTransaction()
        var newsArticleFragment: NewsArticleFragment = NewsArticleFragment()
        val bundle: Bundle = Bundle()
        bundle.putString("title", list[position].name)
        bundle.putString("date", list[position].date)
        bundle.putString("details", detail + "\n" + detail + "\n" + detail)
        newsArticleFragment.arguments = bundle
        transaction?.replace(R.id.frameLayoutHome, newsArticleFragment)
        transaction?.addToBackStack(newsArticleFragment.TAG)
        transaction?.commit()
    }
}