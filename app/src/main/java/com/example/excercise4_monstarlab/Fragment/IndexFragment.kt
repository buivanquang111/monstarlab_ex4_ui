package com.example.excercise4_monstarlab.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.excercise4_monstarlab.Adapter.IndexAdapter
import com.example.excercise4_monstarlab.Object.Home
import com.example.excercise4_monstarlab.R
import kotlinx.android.synthetic.main.fragment_indext.view.*

class IndexFragment : Fragment() {
    private var list: MutableList<Home> = mutableListOf()
    val adapter: IndexAdapter = IndexAdapter(list)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_indext, container, false)


        return view
    }

    private fun setData() {
        list.add(Home("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        list.add(Home("FTSE 100", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        list.add(Home("IBEX 35", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        list.add(Home("DAX", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        list.add(Home("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        list.add(Home("FTSE 100", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        list.add(Home("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        list.add(Home("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        list.add(Home("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        list.add(Home("FTSE 100", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        list.add(Home("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        list.add(Home("FTSE 100", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        list.add(Home("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        list.add(Home("IBEX 35", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))
        list.add(Home("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"))

    }
}