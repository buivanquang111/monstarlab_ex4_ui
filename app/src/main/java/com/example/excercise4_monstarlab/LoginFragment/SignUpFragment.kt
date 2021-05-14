package com.example.excercise4_monstarlab.LoginFragment

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.excercise4_monstarlab.LoginActivity
import com.example.excercise4_monstarlab.R
import kotlinx.android.synthetic.main.fragment_sign_up.view.*

class SignUpFragment : Fragment() {
    lateinit var mLoginActivity: LoginActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_sign_up,container,false)

        mLoginActivity = activity as LoginActivity

        view.textViewLogin.setOnClickListener {
            var transaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayoutLogin, LoginFragment())
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
        view.btnSignUp.setOnClickListener {
            val email: String = view.editTextEmailSignUp.text.toString()
            val passWord: String = view.editTextPasswordSignUp.text.toString()
            if (email.equals("") || passWord.equals("")){
                Toast.makeText(context,"bạn cần nhập đủ tài khoản và mật khẩu !!!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val editor: SharedPreferences.Editor = mLoginActivity.sharedPreferences.edit()
            editor.putString("Email",email)
            editor.putString("Password",passWord)
            editor.apply()

            var transaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayoutLogin, LoginFragment())
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
        view.textViewForgotPasswordSingUp.setOnClickListener {
            var transaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayoutLogin, EmailFragment())
            transaction?.addToBackStack(null)
            transaction?.commit()
        }

        return view
    }
}