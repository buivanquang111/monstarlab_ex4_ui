package com.example.excercise4_monstarlab.LoginFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.excercise4_monstarlab.R
import kotlinx.android.synthetic.main.fragment_confirm_password_changed.view.*

class ConfirmPasswordChangedFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_confirm_password_changed, container, false)
        view.btnConfirmPasswordChanged.setOnClickListener {
            var transaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayoutLogin, LoginFragment())
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
        return view;
    }
}