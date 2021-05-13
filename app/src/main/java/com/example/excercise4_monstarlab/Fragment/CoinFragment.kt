package com.example.excercise4_monstarlab.Fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.excercise4_monstarlab.R
import kotlinx.android.synthetic.main.fragment_coin.view.*

class CoinFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_coin,container,false)
        view.buttonAlarmCoin.setOnClickListener {
            var  builder: AlertDialog.Builder = AlertDialog.Builder(context)
            builder.setTitle("Thông báo")
            builder.setMessage("bạn vừa click thay đổi background!!!")
            builder.setPositiveButton("Ok", DialogInterface.OnClickListener {
                dialog, which ->  dialog.cancel()

            })
            var alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }

        view.imageViewBack.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        return view
    }
}