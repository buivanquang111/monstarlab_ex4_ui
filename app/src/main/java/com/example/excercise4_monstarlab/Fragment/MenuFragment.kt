package com.example.excercise4_monstarlab.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.excercise4_monstarlab.Adapter.MenuAdapter
import com.example.excercise4_monstarlab.Object.Menu
import com.example.excercise4_monstarlab.R
import kotlinx.android.synthetic.main.fragment_menu.view.*

class MenuFragment : Fragment(){
    private var list: MutableList<Menu> = mutableListOf()
    private var adapterViewType: MenuAdapter = MenuAdapter(list)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_menu,container,false)
        setData()
        view.recyclerViewMenu.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        view.recyclerViewMenu.adapter = adapterViewType
        view.imageViewBackMenu.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        return view
    }
    private fun setData(){
        list.add(Menu(R.drawable.icons_8_1_alarm,"Alerts",1))
        list.add(Menu(R.drawable.icons_8_left_and_right_arrows,"Predictions",1))
        list.add(Menu(R.drawable.icons_8_pin,"Saved elements",1))
        list.add(Menu(R.drawable.icons_8_no_entry,"Remove Ads",1))
        list.add(Menu(0,"Tools",2))
        list.add(Menu(R.drawable.icons_8_profit_2,"Select Stocks",3))
        list.add(Menu(R.drawable.icons_8_swap,"Currency Exchange",3))
        list.add(Menu(R.drawable.icons_8_video_call,"Webinar",3))
        list.add(Menu(R.drawable.icons_8_rent,"Best Broker",3))
        list.add(Menu(0,"Markets",2))
        list.add(Menu(R.drawable.icons_8_profit_2,"Select Stocks",3))
        list.add(Menu(R.drawable.icons_8_swap,"Currency Exchange",3))
        list.add(Menu(R.drawable.icons_8_video_call,"Webinar",3))
        list.add(Menu(R.drawable.icons_8_rent,"Best Broker",3))
    }
}