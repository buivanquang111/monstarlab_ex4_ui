package com.example.excercise4_monstarlab.Fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.marginBottom
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.*
import com.example.excercise4_monstarlab.Adapter.IndexAdapter
import com.example.excercise4_monstarlab.Object.Home
import com.example.excercise4_monstarlab.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlin.math.sign

class HomeFragment : Fragment() {
    private var list: MutableList<Home> = mutableListOf()
    private val adapter: IndexAdapter = IndexAdapter(list)
    private var isLoading: Boolean = false
    private var page = 1
    private var limit = 10
    lateinit var linearLayoutManager: LinearLayoutManager
    private var y =0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home,container,false)


        var itemTouchHelper: ItemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.DOWN or  ItemTouchHelper.UP,
                ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
        ) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                adapter.notifyItemMoved(viewHolder.layoutPosition, target.layoutPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                var position = viewHolder.layoutPosition
                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        list.removeAt(position)
                        adapter.notifyItemRemoved(viewHolder.layoutPosition)

                    }
                    ItemTouchHelper.RIGHT -> {
                        list.removeAt(position)
                        adapter.notifyItemRemoved(viewHolder.layoutPosition)

                    }
                }
            }
        })
        itemTouchHelper.attachToRecyclerView(view.recyclerViewIndex)

        linearLayoutManager = LinearLayoutManager(context)
        view.recyclerViewIndex.layoutManager = linearLayoutManager

        setData()
        view.recyclerViewIndex.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 ){
                    val visibleItemCount: Int =linearLayoutManager.childCount
                    val pastVisibleItem: Int = linearLayoutManager.findFirstCompletelyVisibleItemPosition()
                    val total: Int = adapter.itemCount
                    if (!isLoading){
                        if ((visibleItemCount+pastVisibleItem) >= total) {
                            view.btnLoad.visibility = View.VISIBLE
                            view.btnLoad.setOnClickListener {
                                page++
                                setData()
                                for (i in 0 until list.size - 2) {
                                    if (list[i].name.equals("")) {
                                        list.removeAt(i)
                                        adapter.notifyItemRemoved(i)
                                    }
                                }
                            }
                        }
                    }
                    y=dy
                }
                if (dy < y){
                    view.btnLoad.visibility = View.GONE
                    adapter.notifyDataSetChanged()
                }
            }
        })

        view.buttonAlarmHome.setOnClickListener {
            var  builder: AlertDialog.Builder = AlertDialog.Builder(context)
            builder.setTitle("Thông báo")
            builder.setMessage("bạn vừa click thay đổi background!!!")
            builder.setPositiveButton("Ok",DialogInterface.OnClickListener {
                dialog, which ->  dialog.cancel()

            })
            var alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }
        return view
    }

    private fun setData(){
        isLoading=true
        view?.btnLoad?.visibility = View.GONE
        list.add(Home("DOWN JONES","NYSE","10:44:45","20.047,50","+203 (+1,04%)"))
        list.add(Home("FTSE 100","NYSE","10:44:45","20.047,50","+203 (+1,04%)"))
        list.add(Home("IBEX 35","NYSE","10:44:45","20.047,50","+203 (+1,04%)"))
        list.add(Home("DOWN JONES","NYSE","10:44:45","20.047,50","+203 (+1,04%)"))
        list.add(Home("DOWN JONES","NYSE","10:44:45","20.047,50","+203 (+1,04%)"))
        list.add(Home("FTSE 100","NYSE","10:44:45","20.047,50","+203 (+1,04%)"))
        list.add(Home("DOWN JONES","NYSE","10:44:45","20.047,50","+203 (+1,04%)"))
        list.add(Home("IBEX 35","NYSE","10:44:45","20.047,50","+203 (+1,04%)"))
        list.add(Home("DOWN JONES","NYSE","10:44:45","20.047,50","+203 (+1,04%)"))
        list.add(Home("FTSE 100","NYSE","10:44:45","20.047,50","+203 (+1,04%)"))
        list.add(Home("","","","",""))
        adapter.notifyDataSetChanged()
        Handler().postDelayed({
            view?.recyclerViewIndex?.adapter = adapter
            isLoading=false
        },1000)
    }



}