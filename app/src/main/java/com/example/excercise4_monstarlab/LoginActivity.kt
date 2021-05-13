package com.example.excercise4_monstarlab

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.excercise4_monstarlab.LoginFragment.LoginFragment

class LoginActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE)

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayoutLogin, LoginFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}