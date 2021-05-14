package com.example.excercise4_monstarlab.LoginFragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.excercise4_monstarlab.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {
    lateinit var mLoginActivity: LoginActivity
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_login,container,false)

        mLoginActivity = activity as LoginActivity

        view.textViewSignUp.setOnClickListener {
            var transaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayoutLogin, SignUpFragment())
            transaction?.addToBackStack(null)
            transaction?.commit()
        }
        val email = mLoginActivity.sharedPreferences.getString("Email","")
        val passWord = mLoginActivity.sharedPreferences.getString("Password","")
        view.editTextEmailLogin.setText(email)
        view.editTextPasswordLogin.setText(passWord)
        view.btnLogin.setOnClickListener {
            val edEmail = view.editTextEmailLogin.text.toString()
            val edPassWord = view.editTextPasswordLogin.text.toString()
            if (edEmail.equals("") || edPassWord.equals("")){
                Toast.makeText(context,"bạn cần nhập đủ tài khoản và mật khẩu để đăng nhập!!!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (email.equals("") || passWord.equals("")) {
                Toast.makeText(context,"bạn chưa có tài khoản!!!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (edEmail.equals(email) && edPassWord.equals(passWord)){
                Toast.makeText(mLoginActivity,"Login thành công",Toast.LENGTH_SHORT).show()
                val intent: Intent = Intent(mLoginActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
        view.textViewForgotPassword.setOnClickListener {
            var transaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayoutLogin, EmailFragment())
            transaction?.addToBackStack(null)
            transaction?.commit()
        }

        return view
    }
}