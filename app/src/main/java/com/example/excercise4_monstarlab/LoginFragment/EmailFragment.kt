package com.example.excercise4_monstarlab.LoginFragment

import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.excercise4_monstarlab.LoginActivity
import com.example.excercise4_monstarlab.R
import kotlinx.android.synthetic.main.fragment_email.view.*

class EmailFragment : Fragment() {
    lateinit var mLoginActivity: LoginActivity
    val pass: String = "123"
    lateinit var backZero: Runnable
    var mHandler: Handler = Handler()
    var number: Int = 30
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_email,container,false)

        backZero = Runnable {
            if (number > 0) {
                number--
                view.textViewNumber.text = number.toString()
                mHandler.postDelayed(backZero,500)
            }else if (number == 0){
                Toast.makeText(mLoginActivity,"change password thanh cong",Toast.LENGTH_SHORT).show()
                var transaction: FragmentTransaction? = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.frameLayoutLogin, ConfirmPasswordChangedFragment())
                transaction?.addToBackStack(null)
                transaction?.commit()
            }
        }
        mHandler.postDelayed(backZero,1000)

        mLoginActivity = activity as LoginActivity
        view.btnResendEmail.setOnClickListener {
            val editor: SharedPreferences.Editor = mLoginActivity.sharedPreferences.edit()
            editor.putString("Password",pass)
            editor.apply()
            Toast.makeText(mLoginActivity,"${mLoginActivity.sharedPreferences.getString("Email","")} , ${mLoginActivity.sharedPreferences.getString("Password","")}",Toast.LENGTH_SHORT).show()
            var transaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayoutLogin, ConfirmPasswordChangedFragment())
            transaction?.addToBackStack(null)
            transaction?.commit()
            mHandler.removeCallbacks(backZero)
        }

        return view
    }
}